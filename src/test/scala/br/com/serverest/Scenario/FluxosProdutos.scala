package br.com.serverest.Scenario

import br.com.serverest.Scenario.FluxoApiServeRest.usuarioscsv
import br.com.serverest.api.{AuthApi, ProdutoApi}
import io.gatling.core.Predef.scenario

object FluxosProdutos {

  val cenarioBuscaTodosProdutosCadastrados = scenario("Busca todos os produtos cadastrados.")
    .exec(ProdutoApi.BuscarTodos())

  val cenarioCadastrarAlterarDeletar = scenario("Cadastra um produto, altera o e deleta por id.")
    .feed(usuarioscsv)
    .exec(AuthApi.login())
    .exec(ProdutoApi.Cadastrar())
    .exec(ProdutoApi.Alterar())
    .exec(ProdutoApi.Delatar())

  val cenarioCadastrarBuscaPorId = scenario("Cadastra um produto e busca por id.")
    .feed(usuarioscsv)
    .exec(AuthApi.login())
    .exec(ProdutoApi.Cadastrar())
    .exec(ProdutoApi.BuscarPorId())

  val cenarioCadastrarDeletar = scenario("Cadastra um produto e deleta por id.")
    .feed(usuarioscsv)
    .exec(AuthApi.login())
    .exec(ProdutoApi.Cadastrar())
    .exec(ProdutoApi.Delatar())
}
