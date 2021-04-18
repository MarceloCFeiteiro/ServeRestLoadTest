package br.com.serverest

import com.sun.deploy.config.Config
import io.gatling.core.Predef._
import io.gatling.http.Predef.{Response, http, status}

object AuthApi {
  def login() = {
    exec()
      .pause(Config.pausa.usuario_preenchimento_formulario_curto)
      .exec(
        actionBuilder = http("Api serveRest")
          .post(Config.uris.apiserveRest.concat("/login"))// //.post(Config.uris.authurl.concat("/auth/login/"))
          .body(ElFileBody("bodies/login/loginApiServeRest.json"))
          .headers(HeaderServeRest.content_type_json)
          .headers(HeaderServeRest.accept)
          .headers(HeaderServeRest.host)
          .headers(HeaderServeRest.connection)
          .headers(HeaderServeRest.content_length)
          .check(status is 200)
          .check(jsonPath("$.authorization").find.saveAs(SessionKeys.bearer_token))
      )
      .pause(Config.pausa.processamento_resposta)
  }
}
