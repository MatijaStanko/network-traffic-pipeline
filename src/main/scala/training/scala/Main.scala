package training.scala

import training.scala.model._
import training.scala.parse._

object Main {

  def main(args: Array[String]): Unit = {

    val capacityBps = 1_000_000_000.0
    val metrics = SampleMetrics.metrics

    MetricUtils.formatMetrics(metrics, capacityBps)

    println("Broj metrika po uredjaju:".toUpperCase)
    MetricTranformations.countMetricsByDevice(metrics).foreach(println)
    println()

    println("Prosecna vrednost po svakoj metrici:".toUpperCase)
    MetricTranformations.averageValueByMetricName(metrics).foreach(println)
    println()

    println("5 metrika sa najvecom ukupnom vrednoscu:".toUpperCase)
    MetricTranformations.topFiveEntitiesByValue(metrics).foreach(println)
    println()


    val capacityBps2 = 1_000_000_000.0
    val metrics2 = SampleNetworkMetrics.metrics

    println("NETWORK METRICS")
    println("=" * 90)

    metrics2.foreach { metric =>
      val normalizedMetric =
        NetworkMetricUtils.addNormalizedValueToMetric(metric)

      println(
        NetworkMetricUtils.describeMetric(
          normalizedMetric,
          capacityBps2
        )
      )

      println(
        s"Normalized value: ${normalizedMetric.normalizedValue}"
      )

      println("-" * 90)
    }

    val csvLines = SampleCsvLines.lines
    val parseResult = csvLines.map(
      NetworkMetricParser.parseCsvLine
    )


    val(errors, metrics3) =
      parseResult.partitionMap(identity)

    println("=" * 90)
    println("GRESKE:")
    errors.foreach(println)

    println("-" * 90)
    println("ISPRAVNO PARSIRANI REDOVI:")
    metrics3.foreach { metric =>
      println(NetworkMetricUtils.describeMetric(
        metric, capacityBps2)
      )
      println("-" * 90)
    }
  }
}
