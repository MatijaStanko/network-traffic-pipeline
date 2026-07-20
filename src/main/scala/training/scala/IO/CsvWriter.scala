package training.scala.IO

import java.io.PrintWriter
import java.nio.file.Files
import java.nio.file.Paths

import scala.util.Try
import scala.util.Using

import training.scala.parse.ValidationError
import training.scala.parse.ValidationError.InvalidCsvRow

object CsvWriter {

  type MetricKey = (String, String)

  def writeValidSummary(
                         outputPath: String,
                         counts: Map[MetricKey, Int],
                         minimums: Map[MetricKey, Double],
                         maximums: Map[MetricKey, Double],
                         averages: Map[MetricKey, Double]
                       ): Try[Unit] =
    writeFile(outputPath) { writer =>
      writer.println(
        "deviceName,metricName,measurementCount,minimumValue,maximumValue,averageValue"
      )

      counts.keys.toList.sorted.foreach {
        case key @ (deviceName, metricName) =>
          val count =
            counts.getOrElse(key, 0)

          val minimum =
            minimums.getOrElse(key, 0.0)

          val maximum =
            maximums.getOrElse(key, 0.0)

          val average =
            averages.getOrElse(key, 0.0)

          writer.println(
            s"${escapeCsv(deviceName)}," +
              s"${escapeCsv(metricName)}," +
              s"$count," +
              f"$minimum%.2f," +
              f"$maximum%.2f," +
              f"$average%.2f"
          )
      }
    }

  def writeRejectedRows(
                         outputPath: String,
                         errors: List[ValidationError]
                       ): Try[Unit] =
    writeFile(outputPath) { writer =>
      writer.println(
        "lineNumber,deviceName,metricName,error,rawLine"
      )

      errors.foreach {
        case error: InvalidCsvRow =>
          writer.println(
            s"${error.lineNumber}," +
              s"${escapeCsv(error.deviceName)}," +
              s"${escapeCsv(error.metricName)}," +
              s"${escapeCsv(error.cause.message)}," +
              s"${escapeCsv(error.rawLine)}"
          )

        case error =>
          writer.println(
            s",,," +
              s"${escapeCsv(error.message)},"
          )
      }
    }

  private def writeFile(
                         outputPath: String
                       )(
                         writeContent: PrintWriter => Unit
                       ): Try[Unit] =
    Try {
      val path = Paths.get(outputPath)
      val parentDirectory = path.getParent

      if (parentDirectory != null) {
        Files.createDirectories(parentDirectory)
      }

      Using.resource(
        new PrintWriter(
          path.toFile,
          "UTF-8"
        )
      ) { writer =>
        writeContent(writer)
      }
    }

  private def escapeCsv(
                         value: String
                       ): String = {
    val escapedValue =
      value.replace("\"", "\"\"")

    if (
      value.contains(",") ||
        value.contains("\"") ||
        value.contains("\n")
    ) {
      s""""$escapedValue""""
    } else {
      escapedValue
    }
  }
}
