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

}
