package br.com.serverest.simulation

import br.com.serverest.http.Http
import br.com.serverest.Scenario.{FluxoApiServeRest, FluxosProdutos}
import io.gatling.core.Predef._

import scala.concurrent.duration._

class MainSimulation extends BaseSimulation {
  val scenarios = Map(
    "ramp" -> List(
      FluxosProdutos.cenarioCadastrarAlterarDeletar.inject(rampUsers(userCount) during (rampDuration.seconds))
    ),
    "constants" -> List(
      FluxosProdutos.cenarioCadastrarAlterarDeletar.inject(constantUsersPerSec(userCount) during (constantDuration.seconds))
    )
  )

  setUp(scenarios(scn): _*).protocols(Http.httpProtocol).maxDuration(maxDuration.hours)
}
