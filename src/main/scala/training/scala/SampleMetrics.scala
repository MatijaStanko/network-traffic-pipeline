package training.scala

object SampleMetrics {

  val metrics: List[SimpleMetric] = List(
    SimpleMetric(
      timestamp = "2026-07-17T08:00:00",
      deviceName = "router-1",
      entityName = "interface-1",
      metricName = "traffic-in",
      value = 120_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:05:00",
      deviceName = "router-1",
      entityName = "interface-1",
      metricName = "traffic-out",
      value = 340_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:10:00",
      deviceName = "router-1",
      entityName = "interface-2",
      metricName = "traffic-in",
      value = 450_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:15:00",
      deviceName = "router-1",
      entityName = "interface-2",
      metricName = "traffic-out",
      value = 680_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:20:00",
      deviceName = "router-1",
      entityName = "interface-3",
      metricName = "traffic-in",
      value = 720_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:25:00",
      deviceName = "router-1",
      entityName = "interface-3",
      metricName = "traffic-out",
      value = 910_000_000.0,
      unit = "bps"
    ),

    SimpleMetric(
      timestamp = "2026-07-17T08:00:00",
      deviceName = "router-2",
      entityName = "interface-1",
      metricName = "traffic-in",
      value = 50_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:05:00",
      deviceName = "router-2",
      entityName = "interface-1",
      metricName = "traffic-out",
      value = 390_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:10:00",
      deviceName = "router-2",
      entityName = "interface-2",
      metricName = "traffic-in",
      value = 850_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:15:00",
      deviceName = "router-2",
      entityName = "interface-2",
      metricName = "traffic-out",
      value = 980_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:20:00",
      deviceName = "router-2",
      entityName = "interface-3",
      metricName = "traffic-in",
      value = 0.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:25:00",
      deviceName = "router-2",
      entityName = "interface-3",
      metricName = "traffic-out",
      value = -10_000_000.0,
      unit = "bps"
    ),

    SimpleMetric(
      timestamp = "2026-07-17T08:00:00",
      deviceName = "router-3",
      entityName = "interface-1",
      metricName = "traffic-in",
      value = 210_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:05:00",
      deviceName = "router-3",
      entityName = "interface-1",
      metricName = "traffic-out",
      value = 410_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:10:00",
      deviceName = "router-3",
      entityName = "interface-2",
      metricName = "traffic-in",
      value = 610_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:15:00",
      deviceName = "router-3",
      entityName = "interface-2",
      metricName = "traffic-out",
      value = 810_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:20:00",
      deviceName = "router-3",
      entityName = "interface-3",
      metricName = "traffic-in",
      value = 930_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:25:00",
      deviceName = "router-3",
      entityName = "interface-3",
      metricName = "traffic-out",
      value = 1_050_000_000.0,
      unit = "bps"
    ),

    SimpleMetric(
      timestamp = "2026-07-17T08:00:00",
      deviceName = "switch-1",
      entityName = "port-1",
      metricName = "traffic-in",
      value = 90_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:05:00",
      deviceName = "switch-1",
      entityName = "port-1",
      metricName = "traffic-out",
      value = 290_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:10:00",
      deviceName = "switch-1",
      entityName = "port-2",
      metricName = "traffic-in",
      value = 490_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:15:00",
      deviceName = "switch-1",
      entityName = "port-2",
      metricName = "traffic-out",
      value = 690_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:20:00",
      deviceName = "switch-1",
      entityName = "port-3",
      metricName = "traffic-in",
      value = 890_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:25:00",
      deviceName = "switch-1",
      entityName = "port-3",
      metricName = "traffic-out",
      value = 990_000_000.0,
      unit = "bps"
    ),

    SimpleMetric(
      timestamp = "2026-07-17T08:00:00",
      deviceName = "switch-2",
      entityName = "port-1",
      metricName = "traffic-in",
      value = 150_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:05:00",
      deviceName = "switch-2",
      entityName = "port-1",
      metricName = "traffic-out",
      value = 350_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:10:00",
      deviceName = "switch-2",
      entityName = "port-2",
      metricName = "traffic-in",
      value = 550_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:15:00",
      deviceName = "switch-2",
      entityName = "port-2",
      metricName = "traffic-out",
      value = 750_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:20:00",
      deviceName = "switch-2",
      entityName = "port-3",
      metricName = "traffic-in",
      value = 950_000_000.0,
      unit = "bps"
    ),
    SimpleMetric(
      timestamp = "2026-07-17T08:25:00",
      deviceName = "switch-2",
      entityName = "port-3",
      metricName = "traffic-out",
      value = -50_000_000.0,
      unit = "bps"
    )
  )
}
