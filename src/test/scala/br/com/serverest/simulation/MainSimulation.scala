package br.com.serverest.simulation

import br.com.serverest.http.Http
import br.com.serverest.Scenario.{FluxoApiServeRest, FluxosUsuarios, FluxosCarrinhos, FluxosProdutos}
import io.gatling.core.Predef._

import scala.concurrent.duration._

class MainSimulation extends BaseSimulation {
  val scenarios = Map(
    "ramp" -> List(
      FluxosCarrinhos.cenarioCadastrarCarinho.inject(rampUsers(userCount) during (rampDuration.seconds))
    ),
    "constants" -> List(
      FluxosCarrinhos.cenarioCadastrarCarinho.inject(constantUsersPerSec(userCount) during (constantDuration.seconds))
    )
  )

  setUp(scenarios(scn): _*).protocols(Http.httpProtocol).maxDuration(maxDuration.hours)
}
