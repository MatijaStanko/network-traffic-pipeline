package training.scala

case class SimpleMetric (
                        timestamp: Long,
                        deviceName: String,
                        entityName: String,
                        metricName: String,
                        value: Double,
                        unit: String
                        ) 
