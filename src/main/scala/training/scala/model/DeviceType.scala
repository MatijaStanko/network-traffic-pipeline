package training.scala.model

sealed trait DeviceType

object DeviceType {
  case object Cmts extends DeviceType
  case object Olt extends DeviceType
  case object Router extends DeviceType
  case object Unknown extends DeviceType
}
