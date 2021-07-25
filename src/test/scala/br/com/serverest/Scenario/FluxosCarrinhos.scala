package br.com.serverest.Scenario

import br.com.serverest.Scenario.FluxoApiServeRest.usuarioscsv
import br.com.serverest.api.{AuthApi, CarrinhoApi, ProdutoApi}
import io.gatling.core.Predef._

object FluxosCarrinhos {

  val produtosCsv = csv("bodies/data/produtosParaCarrinho.csv").circular

  val cenarioBuscaTodosCarrinhosCadastrados = scenario("Busca todos os carrinhos cadastrados.")
    .exec(CarrinhoApi.BuscarTodos())

  val cenarioCadastrarCarinho = scenario("Cadastra um carrinho")
    .feed(usuarioscsv)
    .feed(produtosCsv)
    .exec(AuthApi.login())
    .exec(CarrinhoApi.Deletar())
    .exec(ProdutoApi.CadastrarProdutoCarrinho())
    .exec(CarrinhoApi.Cadastar())
    .exec(CarrinhoApi.Deletar())
    .exec(ProdutoApi.Deletar())

}
