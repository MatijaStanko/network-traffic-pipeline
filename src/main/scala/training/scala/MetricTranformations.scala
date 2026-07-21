package training.scala

object MetricTranformations {

  def filterValidMetrics (metrics: List[SimpleMetric]): List[SimpleMetric] =
    metrics.filter(metric => MetricUtils.isPositive(metric.value))

  def countMetricsByDevice(metrics: List[SimpleMetric]): Map[String, Int] =
    metrics.groupBy(_.deviceName)
      .map{
        case (deviceName, deviceMetrics)
        => deviceName -> deviceMetrics.size}

  def averageValueByMetricName (metrics: List[SimpleMetric]): Map[String, Double] =
    metrics.groupBy(_.metricName)
      .map{
        case(metricName, listOfMetrics)
          => metricName -> listOfMetrics.map(_.value).sum / listOfMetrics.size
      }

  def totalValueByEntity(metrics: List[SimpleMetric]): Map[(String, String), Double] =
    metrics.groupBy(
      metric => (metric.deviceName, metric.entityName)
    ).map {
      case((deviceName, entityName), listOfMetrics) =>
        (deviceName, entityName) -> listOfMetrics.map(_.value).sum
    }

  def topFiveEntitiesByValue(metrics: List[SimpleMetric]): List[((String, String), Double)] =
    totalValueByEntity(metrics)
      .toList
      .sortBy {
        case (_, totalValue) => -totalValue
      }
      .take(5)

}
