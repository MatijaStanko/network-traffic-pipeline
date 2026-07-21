package training.scala.parse

import training.scala.model.{DeviceType, MetricUnit, NetworkMetric}
import training.scala.parse.ValidationError.{EmptyField, InvalidColumnCount, InvalidDeviceType, InvalidDouble, InvalidMetricUnit, InvalidTimestamp, NegativeMetricValue}

import scala.util.Try

object NetworkMetricParser {

  private val expectedColumnCount = 7

  def parseTimestamp(value: String): Either[ValidationError, Long] = {
    Try(value.toLong)
      .toEither
      .left
      .map(_ => InvalidTimestamp(value))
  }

  def parseDouble(
                   value: String
                 ): Either[ValidationError, Double] =
    Try(value.toDouble)
      .toEither
      .left
      .map(_ => InvalidDouble(value))

  def parseDeviceType(
                       value: String
                     ): Either[ValidationError, DeviceType] =
    value.trim.toLowerCase match {
      case "cmts" =>
        Right(DeviceType.Cmts)

      case "olt" =>
        Right(DeviceType.Olt)

      case "router" =>
        Right(DeviceType.Router)

      case "unknown" =>
        Right(DeviceType.Unknown)

      case invalidValue =>
        Left(InvalidDeviceType(invalidValue))
    }


  private def parseMetricUnit(
                               value: String
                             ): Either[ValidationError, MetricUnit] =
    value.trim.toLowerCase match {
      case "bps" =>
        Right(MetricUnit.Bps)

      case "mbps" =>
        Right(MetricUnit.Mbps)

      case "dbm" =>
        Right(MetricUnit.Dbm)

      case "percent" =>
        Right(MetricUnit.Percent)

      case "count" =>
        Right(MetricUnit.Count)

      case invalidValue =>
        Left(InvalidMetricUnit(invalidValue))
    }

  def parseCsvLine(
                    line: String
                  ): Either[ValidationError, NetworkMetric] = {
    val columns = line.split(",", -1).map(_.trim)

    if (columns.length != expectedColumnCount) {
      Left(
        InvalidColumnCount(
          expected = expectedColumnCount,
          actual = columns.length
        )
      )
    } else {
      val Array(
        timestampText,
        deviceName,
        deviceTypeText,
        entityName,
        metricName,
        valueText,
        unitText
      ) = columns

      for {
        validDeviceName <- requireNonEmpty(deviceName, "deviceName")
        validEntityName <- requireNonEmpty(entityName, "entityName")
        validMetricName <- requireNonEmpty(metricName, "metricName")

        timestamp <- parseTimestamp(timestampText)

        deviceType <- parseDeviceType(deviceTypeText)

        value <- parseDouble(valueText)

        unit <- parseMetricUnit(unitText)

        validValue <- validateValue(value, unit)
      } yield NetworkMetric(
        timestamp = timestamp,
        deviceName = validDeviceName,
        deviceType = deviceType,
        entityName = validEntityName,
        metricName = validMetricName,
        value = validValue,
        unit = unit
      )
    }
  }


  private def requireNonEmpty(
                               value: String,
                               fieldName: String
                             ): Either[ValidationError, String] =
    if (value.nonEmpty) {
      Right(value)
    } else {
      Left(EmptyField(fieldName))
    }

  private def validateValue(
                             value: Double,
                             unit: MetricUnit
                           ): Either[ValidationError, Double] =
    unit match {
      case MetricUnit.Dbm =>
        Right(value)

      case _ if value >= 0.0 =>
        Right(value)

      case _ =>
        Left(NegativeMetricValue(value))
    }

}
