package Utils

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder

object Utils {
  def getProperty(propertyName: String, defaultValue: String) = {
    Option(System.getenv(propertyName))
      .orElse(Option(System.getProperty(propertyName)))
      .getOrElse(defaultValue)
  }

  def printSessionAttributes(): ChainBuilder = {
    exec(session => {
      println(session)
      session
    })
  }
}
