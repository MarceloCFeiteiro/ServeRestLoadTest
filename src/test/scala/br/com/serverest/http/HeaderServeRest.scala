package br.com.serverest.http

object HeaderServeRest {
  val authorization = Map(
    "Authorization" -> "${bearerToken}"
  )
  val content_type_json = Map(
    "Content-Type" -> "application/json"
  )

  val accept = Map(
    "Accept" -> "*/*",
    "Accept-Encoding" -> "gzip, deflate, br"
  )

  val host = Map(
    "Host" -> "serverest.dev"
  )

  val connection = Map(
    "Connection" -> "keep-alive"
  )

  val content_length = Map(
    "Content-Length" -> "56"
  )
}
