package training.scala.IO

import scala.io.Source
import scala.util.Try
import scala.util.Using

object CsvReader {

  def readLines(inputPath: String): Try[List[String]] =
    Using(
      Source.fromFile(
        inputPath,
        "UTF-8"
      )
    ) { source =>
      source
        .getLines()
        .drop(1)
        .toList
    }
}
