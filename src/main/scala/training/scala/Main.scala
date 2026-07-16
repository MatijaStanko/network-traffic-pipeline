package training.scala

object Main {

  def main(args: Array[String]): Unit = {

    val capacityBps = 1_000_000_000.0

    val metrics = List(
      SimpleMetric("router-1", "traffic-in", 120_000_000.0, "bps"),
      SimpleMetric("router-1", "traffic-out", 340_000_000.0, "bps"),
      SimpleMetric("router-2", "traffic-in", 450_000_000.0, "bps"),
      SimpleMetric("router-2", "traffic-out", 680_000_000.0, "bps"),
      SimpleMetric("router-3", "traffic-in", 720_000_000.0, "bps"),
      SimpleMetric("router-3", "traffic-out", 910_000_000.0, "bps"),
      SimpleMetric("switch-1", "traffic-in", 50_000_000.0, "bps"),
      SimpleMetric("switch-1", "traffic-out", 390_000_000.0, "bps"),
      SimpleMetric("switch-2", "traffic-in", 850_000_000.0, "bps"),
      SimpleMetric("switch-2", "traffic-out", -10_000_000.0, "bps")
    )

    MetricUtils.formatMetrics(metrics, capacityBps)
  }

}
