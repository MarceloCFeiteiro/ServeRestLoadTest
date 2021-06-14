package br.com.serverest.api

import br.com.serverest.Utils.Config
import br.com.serverest.http.HeaderServeRest
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
import io.gatling.core.Predef.{exec, _}


object UsuarioApi {

  def Alterar(): ChainBuilder = {
    exec(
      http("Atera um usuário.")
        .put(Config.apiServeRestUrl.concat("/usuarios").concat("/${idUsuario}"))
        .headers(HeaderServeRest.authorization)
        .headers(HeaderServeRest.content_type_json)
        .headers(HeaderServeRest.accept)
        .headers(HeaderServeRest.host)
        .headers(HeaderServeRest.connection)
        .body(ElFileBody("bodies/data/usuarioAlterado.json"))
        .check(status is 200)
    )
  }

  def BuscarPorId(): ChainBuilder = {
    exec(
      http("Busca um usuario por id")
        .get(Config.apiServeRestUrl.concat("/usuarios").concat("/${idUsuario}"))
        .headers(HeaderServeRest.content_type_json)
        .headers(HeaderServeRest.accept)
        .headers(HeaderServeRest.host)
        .headers(HeaderServeRest.connection)
        .check(status is 200)
    )
  }

  def BuscarTodos(): ChainBuilder = {
    exec(
      http("Busca todos os usuarios")
        .get(Config.apiServeRestUrl.concat("/usuarios"))
        .headers(HeaderServeRest.content_type_json)
        .headers(HeaderServeRest.accept)
        .headers(HeaderServeRest.host)
        .headers(HeaderServeRest.connection)
        .check(status is 200)
    )
  }

  def Cadastrar(): ChainBuilder = {
    exec(
      http("Cadastrar Usuário")
        .post(Config.apiServeRestUrl.concat("/usuarios"))
        .headers(HeaderServeRest.content_type_json)
        .headers(HeaderServeRest.accept)
        .headers(HeaderServeRest.host)
        .headers(HeaderServeRest.connection)
        .body(ElFileBody("bodies/data/usuario.json"))
        .check(jsonPath("$._id").saveAs("idUsuario"))
        .check(status is 201)
    )
  }

  def Delatar(): ChainBuilder = {
    exec(
      http("Deletar usuario")
        .delete(Config.apiServeRestUrl.concat("/usuarios").concat("/${idUsuario}"))
        .headers(HeaderServeRest.authorization)
        .headers(HeaderServeRest.accept)
        .headers(HeaderServeRest.host)
        .headers(HeaderServeRest.connection)
        .check(status is 200)
    )
  }
}
