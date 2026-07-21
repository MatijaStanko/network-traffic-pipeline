package training.scala.model

case class NetworkMetric(
                        timestamp: Long,
                        deviceName: String,
                        deviceType: DeviceType,
                        entityName: String,
                        metricName: String,
                        value: Double,
                        unit: MetricUnit,
                        normalizedValue: Option[Double] = None,
                        tags: Set[String] = Set.empty
                        )


