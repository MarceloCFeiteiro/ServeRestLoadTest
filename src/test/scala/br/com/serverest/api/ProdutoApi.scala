package br.com.serverest.api

import br.com.serverest.Utils.Config
import br.com.serverest.http.HeaderServeRest
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
import io.gatling.core.Predef.{exec, _}

object ProdutoApi {

  def Alterar(): ChainBuilder = {
    exec(
      http("Atera um Produto.")
        .put(Config.apiServeRestUrl.concat("/produtos").concat("/${idProduto}"))
        .headers(HeaderServeRest.authorization)
        .headers(HeaderServeRest.content_type_json)
        .headers(HeaderServeRest.accept)
        .headers(HeaderServeRest.host)
        .headers(HeaderServeRest.connection)
        .body(ElFileBody("bodies/data/produtoAlterado.json"))
        .check(status is 200)
    )
  }

  def BuscarPorId(): ChainBuilder = {
    exec(
      http("Busca um Produto por id")
        .get(Config.apiServeRestUrl.concat("/produtos").concat("/${idProduto}"))
        .headers(HeaderServeRest.content_type_json)
        .headers(HeaderServeRest.accept)
        .headers(HeaderServeRest.host)
        .headers(HeaderServeRest.connection)
        .check(status is 200)
    )
  }

  def BuscarTodos(): ChainBuilder = {
    exec(
      http("Busca todos os produtos")
        .get(Config.apiServeRestUrl.concat("/produtos"))
        .headers(HeaderServeRest.content_type_json)
        .headers(HeaderServeRest.accept)
        .headers(HeaderServeRest.host)
        .headers(HeaderServeRest.connection)
        .check(status is 200)
    )
  }

  def Cadastrar(): ChainBuilder = {
    exec(
      http("Cadastrar Produto")
        .post(Config.apiServeRestUrl.concat("/produtos"))
        .headers(HeaderServeRest.authorization)
        .headers(HeaderServeRest.content_type_json)
        .headers(HeaderServeRest.accept)
        .headers(HeaderServeRest.host)
        .headers(HeaderServeRest.connection)
        .body(ElFileBody("bodies/data/produto.json"))
        .check(jsonPath("$._id").saveAs("idProduto"))
        .check(status is 201)
    )
  }

  def CadastrarProdutoCarrinho(): ChainBuilder = {
    exec(
      http("Cadastrar Produto")
        .post(Config.apiServeRestUrl.concat("/produtos"))
        .headers(HeaderServeRest.authorization)
        .headers(HeaderServeRest.content_type_json)
        .headers(HeaderServeRest.accept)
        .headers(HeaderServeRest.host)
        .headers(HeaderServeRest.connection)
        .body(ElFileBody("bodies/data/produtosParaCarrinho.json"))
        .check(jsonPath("$._id").saveAs("idProduto"))
        .check(status is 201)
    )
  }

  def Deletar(): ChainBuilder = {
    exec(
      http("Deletar Produto")
        .delete(Config.apiServeRestUrl.concat("/produtos").concat("/${idProduto}"))
        .headers(HeaderServeRest.authorization)
        .headers(HeaderServeRest.accept)
        .headers(HeaderServeRest.host)
        .headers(HeaderServeRest.connection)
        .check(status is 200)
    )
  }
}
