package training.scala.model

import training.scala.model.DeviceType._
import training.scala.model.MetricUnit._

object NetworkMetricUtils {

  def normalizeValue(metric: NetworkMetric): Double = {
    metric.unit match {
      case Mbps =>
        metric.value * 1_000_000.0
      case Bps =>
        metric.value
      case Dbm =>
        metric.value
      case Percent =>
        metric.value
      case Count =>
        metric.value
    }
  }

  def utilizationPercent(
                          metric: NetworkMetric,
                          capacityBps: Double
                        ): Double =
    if (capacityBps <= 0.0) {
      0.0
    } else {
      normalizeValue(metric) / capacityBps * 100.0
    }

  def classifyLoad(utilizationPercent: Double): String =
    if (utilizationPercent < 0.0) {
      "Invalid"
    } else if (utilizationPercent < 40.0) {
      "Low"
    } else if (utilizationPercent < 70.0) {
      "Medium"
    } else if (utilizationPercent < 90.0) {
      "High"
    } else {
      "Critical"
    }

  def isTrafficMetric(metric: NetworkMetric): Boolean =
    metric.unit match {
      case Bps | Mbps =>
        true

      case Dbm | Percent | Count =>
        false
    }

  def describeMetric(
                      metric: NetworkMetric,
                      capacityBps: Double
                    ): String =
    metric match {
      case NetworkMetric(
        _,
        deviceName,
        deviceType,
        entityName,
        metricName,
        _,
        Bps | Mbps,
        _,
        _
      ) =>
        val normalizedValue = normalizeValue(metric)
        val utilization = utilizationPercent(metric, capacityBps)
        val load = classifyLoad(utilization)

        f"$deviceType device $deviceName, entity $entityName, " +
          f"reported $metricName = $normalizedValue%.2f bps, " +
          f"utilization = $utilization%.2f%%, load = $load."

      case NetworkMetric(
        _,
        deviceName,
        Olt,
        entityName,
        metricName,
        value,
        Dbm,
        _,
        _
      ) =>
        s"OLT $deviceName, entity $entityName, reported $metricName = $value dBm."

      case NetworkMetric(
        _,
        deviceName,
        Cmts,
        entityName,
        metricName,
        value,
        Percent,
        _,
        _
      ) =>
        val load = classifyLoad(value)

        f"CMTS $deviceName, entity $entityName, " +
          f"reported $metricName = $value%.2f%%, load = $load."

      case NetworkMetric(
        _,
        deviceName,
        deviceType,
        entityName,
        metricName,
        value,
        Count,
        _,
        _
      ) =>
        f"$deviceType device $deviceName, entity $entityName, " +
          f"reported $metricName = $value%.0f."

      case NetworkMetric(
        _,
        deviceName,
        Unknown,
        entityName,
        metricName,
        value,
        unit,
        _,
        _
      ) =>
        s"Unknown device $deviceName, entity $entityName, reported $metricName = $value $unit."
      case NetworkMetric(
        _,
        deviceName,
        deviceType,
        entityName,
        metricName,
        value,
        unit,
        _,
        _
      ) =>
        s"$deviceType device $deviceName, entity $entityName, " +
          s"reported $metricName = $value $unit."
    }

  def addNormalizedValueToMetric(
                           metric: NetworkMetric
                         ): NetworkMetric =
    metric.copy(
      normalizedValue = Some(normalizeValue(metric))
    )

  def addTag(
              metric: NetworkMetric,
              tag: String
            ): NetworkMetric =
    metric.copy(
      tags = metric.tags + tag
    )
}
