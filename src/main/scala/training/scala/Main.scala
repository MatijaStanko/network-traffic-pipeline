package training.scala

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
  }

}
