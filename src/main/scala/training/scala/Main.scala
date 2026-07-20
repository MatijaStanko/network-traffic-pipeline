package training.scala

import training.scala.IO._
import training.scala.model._
import training.scala.parse._

object Main {

  def main(args: Array[String]): Unit = {

//    val capacityBps = 1_000_000_000.0
//    val metrics = SampleMetrics.metrics
//
//    MetricUtils.formatMetrics(metrics, capacityBps)
//
//    println("Broj metrika po uredjaju:".toUpperCase)
//    MetricTranformations.countMetricsByDevice(metrics).foreach(println)
//    println()
//
//    println("Prosecna vrednost po svakoj metrici:".toUpperCase)
//    MetricTranformations.averageValueByMetricName(metrics).foreach(println)
//    println()
//
//    println("5 metrika sa najvecom ukupnom vrednoscu:".toUpperCase)
//    MetricTranformations.topFiveEntitiesByValue(metrics).foreach(println)
//    println()
//
//
//    val capacityBps2 = 1_000_000_000.0
//    val metrics2 = SampleNetworkMetrics.metrics
//
//    println("NETWORK METRICS")
//    println("=" * 90)
//
//    metrics2.foreach { metric =>
//      val normalizedMetric =
//        NetworkMetricUtils.addNormalizedValueToMetric(metric)
//
//      println(
//        NetworkMetricUtils.describeMetric(
//          normalizedMetric,
//          capacityBps2
//        )
//      )
//
//      println(
//        s"Normalized value: ${normalizedMetric.normalizedValue}"
//      )
//
//      println("-" * 90)
//    }
//
//    val csvLines = SampleCsvLines.lines
//    val parseResult = csvLines.map(
//      NetworkMetricParser.parseCsvLine
//    )
//
//
//    val(errors, metrics3) =
//      parseResult.partitionMap(identity)
//
//    println("=" * 90)
//    println("GRESKE:")
//    errors.foreach(println)
//
//    println("-" * 90)
//    println("ISPRAVNO PARSIRANI REDOVI:")
//    metrics3.foreach { metric =>
//      println(NetworkMetricUtils.describeMetric(
//        metric, capacityBps2)
//      )
//      println("-" * 90)
//    }
//  }

    val inputPath =
      "data/sample/network_metrics_sample.csv"

    val capacityBps =
      1_000_000_000.0

    val outputDirectory =
      "data/output"

    val validSummaryPath =
      s"$outputDirectory/valid_summary.csv"

    val rejectedRowsPath =
      s"$outputDirectory/rejected_rows.csv"

    CsvReader
      .readLines(inputPath)
      .fold(
        error =>
          println(
            s"Failed to read CSV file: ${error.getMessage}"
          ),
        csvLines =>
          processLines(
            csvLines,
            capacityBps,
            outputDirectory,
            validSummaryPath,
            rejectedRowsPath
          )
      )

  }

  private def processLines(
                            csvLines: List[String],
                            capacityBps: Double,
                            outputDirectory: String,
                            validSummaryPath: String,
                            rejectedRowsPath: String
                          ): Unit = {
    val parseResults =
      csvLines
        .zipWithIndex
        .map { case (line, index) =>
          NetworkMetricParser.parseCsvLineWithContext(
            line = line,
            lineNumber = index + 2
          )
        }

    val (errors, validMetrics) =
      parseResults.partitionMap(identity)

//    println("=" * 60)
//    println("NUM OF MEASUREMENTS BY DEVICE AND METRIC: ")
    val counts = NetworkMetricTransformations.countByDeviceAndMetric(validMetrics)

    val minimums = NetworkMetricTransformations.minByDeviceAndMetric(validMetrics)

    val maximums = NetworkMetricTransformations.maxByDeviceAndMetric(validMetrics)

    val averages = NetworkMetricTransformations.avgByDeviceAndMetric(validMetrics)

    CsvWriter
      .writeValidSummary(
        outputPath = validSummaryPath,
        counts = counts,
        minimums = minimums,
        maximums = maximums,
        averages = averages
      )
      .fold(
        error =>
          println(
            s"Failed to write valid summary: ${error.getMessage}"
          ),
        _ =>
          println(
            s"Valid summary written to: $validSummaryPath"
          )
      )

    CsvWriter
      .writeRejectedRows(
        outputPath = rejectedRowsPath,
        errors = errors
      )
      .fold(
        error =>
          println(
            s"Failed to write rejected rows: ${error.getMessage}"
          ),
        _ =>
          println(
            s"Rejected rows written to: $rejectedRowsPath"
          )
      )

    println("PARSER SUMMARY")
    println("=" * 60)
    println(s"Total rows:   ${csvLines.size}")
    println(s"Valid rows:   ${validMetrics.size}")
    println(s"Invalid rows: ${errors.size}")

    println("\nVALID METRICS")
    println("=" * 60)

    validMetrics.foreach { metric =>
      println(
        NetworkMetricUtils.describeMetric(
          metric,
          capacityBps
        )
      )
    }

    println("\nINVALID ROWS")
    println("=" * 60)

    errors.foreach { error =>
      println(error.message)
    }
  }


}
