package br.com.serverest.Scenario
import br.com.serverest.api.{AuthApi, ProdutoApi}
import io.gatling.core.Predef._

object FluxoApiServeRest {

  val usuarioscsv = csv("bodies/data/usuarios.csv").circular

  val cenarioObtertoken = scenario("Obter Token")
    .feed(usuarioscsv)
    .exec(AuthApi.login())
}
