package br.com.serverest.Scenario

import br.com.serverest.api.CarrinhoApi
import io.gatling.core.Predef.scenario

object FluxosCarrinhos {

  val cenarioBuscaTodosCarrinhosCadastrados = scenario("Busca todos os produtos cadastrados.")
    .exec(CarrinhoApi.BuscarTodos())
}
