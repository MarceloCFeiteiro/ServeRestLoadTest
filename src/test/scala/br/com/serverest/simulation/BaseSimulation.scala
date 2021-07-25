package br.com.serverest.simulation

import br.com.serverest.Utils.{Config, ConversorJson, ManipularArquivo, Session, Utils}
import br.com.serverest.http.HeaderServeRest
import br.com.serverest.model.{Carrinho, Produto, Usuario}
import io.gatling.core.Predef._

abstract class BaseSimulation extends Simulation {
  def scn: String = Utils.getProperty("LT_SCENARIO", "ramp")
  def userCount: Int = Utils.getProperty("LT_USERS", "1").toInt
  def rampDuration: Int = Utils.getProperty("LT_RAMP_DURATION", "30").toInt
  def constantDuration: Int = Utils.getProperty("LT_CONSTANT_DURATION", "10").toInt
  def maxDuration: Int = Utils.getProperty("LT_MAX_DURATION", "2").toInt

  Config.authServeRestUrl = Utils.getProperty("LT_AUTH_SERVEREST_URL", Config.authServeRestUrl)
  Config.clientId = Utils.getProperty("LT_CLIENT_ID", Config.clientId)
  Config.clientSecret = Utils.getProperty("LT_CLIENT_SECRET", Config.clientSecret)
  Config.apiServeRestUrl = Utils.getProperty("LT_API_SERVEREST_URL", Config.apiServeRestUrl)

  before {
    ManipularArquivo.salvaArquivo(ConversorJson.EntidadeParaJson(Produto.criaProduto()),"produto")
    ManipularArquivo.salvaArquivo(ConversorJson.EntidadeParaJson(Usuario.CriaUsuarioAdministrador()),"usuario")

   // ManipularArquivo.salvaArquivo(ConversorJson.EntidadeParaJson(Carrinho.criaCarinhoComProdutos()),"carrinho")
    println("================================================================================")
    println("Iniciando os testes de carga, utilizando as seguintes configurações:")
    println(s"Execução")
    println(s" - Cenário escolhido: ${scn}")
    println(s" - Executando testes com ${userCount} usuários")
    println(s" - Rampa de usuários em ${rampDuration} segundos")
    println(s" - Usuários constantes por ${rampDuration} segundos")
    println(s" - Duração máxima: ${maxDuration} hora(s)")
    println(s"Configurações")
    println(s" - Auth URL: ${Config.authServeRestUrl}")
    println(s" - Cliente ID: ${Config.clientId}")
    println(s" - Cliente Secret: ${if (Config.clientSecret.isEmpty()) "" else "{suprimido}"}")
    println(s" - API URL: ${Config.apiServeRestUrl}")
    println("================================================================================")
    println(s"${HeaderServeRest.authorization}")
  }

  after{
    println(HeaderServeRest.authorization)
    println("Simulação finalizada")
  }
}
