package br.com.serverest.simulation

import br.com.serverest.http.Http
import br.com.serverest.Scenario.FluxoApiServeRest
import io.gatling.core.Predef._
import scala.concurrent.duration._

class MainSimulation extends BaseSimulation {
  val scenarios = Map(
    "ramp" -> List(
      FluxoApiServeRest.cenario.inject(rampUsers(userCount) during (rampDuration.seconds))
    ),
    "constants" -> List(
      FluxoApiServeRest.cenario.inject(constantUsersPerSec(userCount) during (constantDuration.seconds))
    )
  )

  setUp(scenarios(scn): _*).protocols(Http.httpProtocol).maxDuration(maxDuration.hours)
}
