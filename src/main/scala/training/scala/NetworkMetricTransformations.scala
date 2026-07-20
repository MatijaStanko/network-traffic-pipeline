package training.scala

import training.scala.model.NetworkMetric

object NetworkMetricTransformations {

  def countByDeviceAndMetric(metrics: List[NetworkMetric]): Map[(String, String), Int] =
    metrics.groupBy(
      metric => (metric.deviceName, metric.metricName)
    ).map {
      case (metricKey, listOfMetrics) =>
        metricKey -> listOfMetrics.size
    }

  def minByDeviceAndMetric(metrics: List[NetworkMetric]): Map[(String, String), Double] =
    metrics.groupBy(
      metric => (metric.deviceName, metric.metricName)
    ).map {
      case (metricKey, listOfMetrics) =>
        metricKey -> listOfMetrics.map(_.value).min
    }

  def maxByDeviceAndMetric(metrics: List[NetworkMetric]): Map[(String, String), Double] =
    metrics.groupBy(
      metric => (metric.deviceName, metric.metricName)
    ).map {
      case (metricKey, listOfMetrics) =>
        metricKey -> listOfMetrics.map(_.value).max
    }

  def avgByDeviceAndMetric(metrics: List[NetworkMetric]): Map[(String, String), Double] =
    metrics.groupBy(
      metric => (metric.deviceName, metric.metricName)
    ).map {
      case (metricKey, listOfMetrics) =>
        metricKey -> listOfMetrics.map(_.value).sum / listOfMetrics.size
    }

}
