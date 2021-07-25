package br.com.serverest.api

import br.com.serverest.Utils.Config
import br.com.serverest.http.HeaderServeRest
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
import io.gatling.core.Predef.{exec, _}

object CarrinhoApi {

  def BuscarTodos(): ChainBuilder = {
    exec(
      http("Busca todos os carrinhos")
        .get(Config.apiServeRestUrl.concat("/carrinhos"))
        .headers(HeaderServeRest.content_type_json)
        .headers(HeaderServeRest.accept)
        .headers(HeaderServeRest.host)
        .headers(HeaderServeRest.connection)
        .check(status is 200)
        .check(jsonPath("$.carrinhos[0].produtos").saveAs("produtos"))
    )
  }

  def Cadastar(): ChainBuilder = {
    exec(
      http("Cadastrar carrinho")
        .post(Config.apiServeRestUrl.concat("/carrinhos"))
        .headers(HeaderServeRest.authorization)
        .headers(HeaderServeRest.content_type_json)
        .headers(HeaderServeRest.accept)
        .headers(HeaderServeRest.host)
        .headers(HeaderServeRest.connection)
        .body(ElFileBody("bodies/data/carrinho.json"))
        .check(jsonPath("$._id").saveAs("idCarrinho"))
        .check(status is 201)
    )
  }

  def Deletar(): ChainBuilder = {
    exec(
      http("Deletar carrinho")
        .delete(Config.apiServeRestUrl.concat("/carrinhos/concluir-compra"))
        .headers(HeaderServeRest.authorization)
        .headers(HeaderServeRest.accept)
        .headers(HeaderServeRest.host)
        .headers(HeaderServeRest.connection)
        .check(status is 200)
    )
  }
}
