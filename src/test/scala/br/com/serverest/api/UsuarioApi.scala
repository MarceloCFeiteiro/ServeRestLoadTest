package br.com.serverest.api

import br.com.serverest.Utils.Config
import br.com.serverest.http.HeaderServeRest
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
import io.gatling.core.Predef.{exec, _}


object UsuarioApi {

  def Cadastrar(): ChainBuilder = {
    exec(
      http("Cadastrar Usuário")
        .post(Config.apiServeRestUrl.concat("/usuario"))
        .headers(HeaderServeRest.authorization)
        .headers(HeaderServeRest.content_type_json)
        .headers(HeaderServeRest.accept)
        .headers(HeaderServeRest.host)
        .headers(HeaderServeRest.connection)
        .body(ElFileBody("bodies/data/usuario.json"))
        .check(jsonPath("$._id").saveAs("idUsuario"))
        .check(status is 201)
    )
  }
}
