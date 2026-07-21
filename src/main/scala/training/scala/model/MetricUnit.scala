package training.scala.model

sealed trait MetricUnit

object MetricUnit {
  case object Bps extends MetricUnit
  case object Mbps extends MetricUnit
  case object Dbm extends MetricUnit
  case object Percent extends MetricUnit
  case object Count extends MetricUnit
}


