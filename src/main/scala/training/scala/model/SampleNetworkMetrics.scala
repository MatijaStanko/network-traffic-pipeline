package training.scala.model

import training.scala.model.DeviceType._
import training.scala.model.MetricUnit._

object SampleNetworkMetrics {

  val metrics: List[NetworkMetric] = List(
    NetworkMetric(
      timestamp = 1784275200L,
      deviceName = "router-1",
      deviceType = Router,
      entityName = "interface-1",
      metricName = "traffic-in",
      value = 120_000_000.0,
      unit = Bps
    ),
    NetworkMetric(
      timestamp = 1784275500L,
      deviceName = "router-1",
      deviceType = Router,
      entityName = "interface-2",
      metricName = "traffic-out",
      value = 450.0,
      unit = Mbps
    ),
    NetworkMetric(
      timestamp = 1784275800L,
      deviceName = "router-2",
      deviceType = Router,
      entityName = "interface-1",
      metricName = "traffic-in",
      value = 720_000_000.0,
      unit = Bps
    ),
    NetworkMetric(
      timestamp = 1784276100L,
      deviceName = "router-2",
      deviceType = Router,
      entityName = "interface-2",
      metricName = "traffic-out",
      value = 950.0,
      unit = Mbps
    ),
    NetworkMetric(
      timestamp = 1784276400L,
      deviceName = "cmts-1",
      deviceType = Cmts,
      entityName = "upstream-1",
      metricName = "utilization",
      value = 35.0,
      unit = Percent
    ),
    NetworkMetric(
      timestamp = 1784276700L,
      deviceName = "cmts-1",
      deviceType = Cmts,
      entityName = "upstream-2",
      metricName = "utilization",
      value = 65.0,
      unit = Percent
    ),
    NetworkMetric(
      timestamp = 1784277000L,
      deviceName = "cmts-2",
      deviceType = Cmts,
      entityName = "downstream-1",
      metricName = "utilization",
      value = 85.0,
      unit = Percent
    ),
    NetworkMetric(
      timestamp = 1784277300L,
      deviceName = "cmts-2",
      deviceType = Cmts,
      entityName = "downstream-2",
      metricName = "modem-count",
      value = 1250.0,
      unit = Count
    ),
    NetworkMetric(
      timestamp = 1784277600L,
      deviceName = "olt-1",
      deviceType = Olt,
      entityName = "pon-1",
      metricName = "signal-level",
      value = -18.0,
      unit = Dbm
    ),
    NetworkMetric(
      timestamp = 1784277900L,
      deviceName = "olt-1",
      deviceType = Olt,
      entityName = "pon-2",
      metricName = "signal-level",
      value = -28.0,
      unit = Dbm
    ),
    NetworkMetric(
      timestamp = 1784278200L,
      deviceName = "olt-2",
      deviceType = Olt,
      entityName = "pon-1",
      metricName = "subscriber-count",
      value = 320.0,
      unit = Count
    ),
    NetworkMetric(
      timestamp = 1784278500L,
      deviceName = "router-3",
      deviceType = Router,
      entityName = "interface-1",
      metricName = "traffic-in",
      value = 0.0,
      unit = Bps
    ),
    NetworkMetric(
      timestamp = 1784278800L,
      deviceName = "router-3",
      deviceType = Router,
      entityName = "interface-2",
      metricName = "traffic-out",
      value = -50.0,
      unit = Mbps
    ),
    NetworkMetric(
      timestamp = 1784279100L,
      deviceName = "unknown-1",
      deviceType = Unknown,
      entityName = "entity-1",
      metricName = "unknown-metric",
      value = 15.0,
      unit = Count
    ),
    NetworkMetric(
      timestamp = 1784279400L,
      deviceName = "router-4",
      deviceType = Router,
      entityName = "interface-1",
      metricName = "packet-count",
      value = 5000.0,
      unit = Count
    )
  )
}
