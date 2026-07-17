package training.scala.parse

sealed trait ValidationError {
  def message:String
}

object ValidationError {
  case class InvalidColumnCount(
                                 expected: Int,
                                 actual: Int
                               ) extends ValidationError {

    override def message: String =
      s"Expected $expected columns, but received $actual."
  }

  case class EmptyField(
                         fieldName: String
                       ) extends ValidationError {

    override def message: String =
      s"Field '$fieldName' must not be empty."
  }

  case class InvalidTimestamp(
                               value: String
                             ) extends ValidationError {

    override def message: String =
      s"Invalid timestamp: '$value'."
  }

  case class InvalidDouble(
                            value: String
                          ) extends ValidationError {

    override def message: String =
      s"Invalid numeric value: '$value'."
  }

  case class InvalidDeviceType(
                                value: String
                              ) extends ValidationError {

    override def message: String =
      s"Invalid device type: '$value'."
  }

  case class InvalidMetricUnit(
                                value: String
                              ) extends ValidationError {

    override def message: String =
      s"Invalid metric unit: '$value'."
  }

  case class NegativeMetricValue(
                                  value: Double
                                ) extends ValidationError {

    override def message: String =
      s"Metric value must not be negative: $value."
  }
}
