package br.com.serverest.api

import br.com.serverest.http.HeaderServeRest
import io.gatling.core.Predef.{exec, _}
import io.gatling.http.Predef.{http, _}
import br.com.serverest.Utils._

object AuthApi {

  def login() = {
    exec(
      http("Api serveRest autenticacao")
        .post(Config.authServeRestUrl.concat("/login"))
        .body(ElFileBody("bodies/login/loginApiServeRest.json"))
        .headers(HeaderServeRest.content_type_json)
        .headers(HeaderServeRest.accept)
        .headers(HeaderServeRest.host)
        .headers(HeaderServeRest.connection)
        .headers(HeaderServeRest.content_length)
        .check(status is 200)
        .check(jsonPath("$.authorization").find.saveAs(Session.bearerToken))
    )
  }
}
