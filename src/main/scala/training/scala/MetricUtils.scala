package training.scala

object MetricUtils {

  def bpsToMbps(valueInBps: Double): Double =
    valueInBps / 1000000.0

  def isPositive(value: Double): Boolean = value > 0.0

  def utilizationPercent(trafficBps: Double, capacityBps: Double): Double =
    if (capacityBps <= 0) 0.0
    else trafficBps / capacityBps * 100

  def classifyLoad(utilizationPercent: Double): String = {
    if (utilizationPercent < 0.0) "Invalid"
    else if (utilizationPercent < 40.0) "Low"
    else if (utilizationPercent < 70.0) "Medium"
    else if (utilizationPercent < 90.0) "High"
    else "Critical"
  }

  def formatMetric(metric: SimpleMetric, capacityBps: Double): Unit = {
    val valueInMbps = bpsToMbps(metric.value)
    val utilization = utilizationPercent(metric.value, capacityBps)
    val load = classifyLoad(utilization)

    println(f"${metric.deviceName}%-12s | " +
      f"${metric.metricName}%-18s | " +
      f"$valueInMbps%8.2f Mbps | " +
      f"$utilization%6.2f%% | " +
      f"$load%-8s |")
  }

  def formatMetrics(
                     metrics: List[SimpleMetric],
                     capacityBps: Double): Unit ={

    println("NETWORK TRAFFIC REPORT")
    println("=" * 71)

    println(
      f"${"Device"}%-12s | " +
        f"${"Metric"}%-18s | " +
        f"${"Value"}%-13s | " +
        f"${"Util."}%-7s | " +
        f"${"Load"}%-8s |"
    )

    println("-" * 71)

    metrics.foreach{ metric =>
    if (isPositive(metric.value)){
      formatMetric(metric, capacityBps)
    }else{
      println(
      f"${metric.deviceName}%-12s | " +
        f"${metric.metricName}%-18s | " +
        f"${"   Invalid: Non Positive value"}%-34s |")
    }
    }

    println("=" * 71)
  }

}
