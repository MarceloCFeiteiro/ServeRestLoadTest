package br.com.serverest.Scenario
import br.com.serverest.api.AuthApi
import io.gatling.core.Predef._

object FluxoApiServeRest {

  var usuarioscsv = csv("data/usuarios.csv").circular

  var cenario = scenario("Fluxo Api ServeRest")
    .feed(usuarioscsv)
    .exec(AuthApi.login())
}
