package br.com.serverest.Scenario
import br.com.serverest.api.{AuthApi}
import io.gatling.core.Predef._

object FluxoApiServeRest {

  val usuarioscsv = csv("bodies/data/usuarios.csv").circular

  val cenarioObtertokenPadrao = scenario("Obter Token")
    .feed(usuarioscsv)
    .exec(AuthApi.login())
}
