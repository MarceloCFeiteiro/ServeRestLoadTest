package br.com.serverest.http

import br.com.serverest.Utils.Config
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Http {
  val httpProtocol = http
    .baseUrl(Config.apiServeRestUrl)
    .headers(HeaderServeRest.content_type_json)
}
