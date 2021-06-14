package br.com.serverest.Scenario

import br.com.serverest.Scenario.FluxoApiServeRest.usuarioscsv
import br.com.serverest.api.{AuthApi, UsuarioApi}
import io.gatling.core.Predef.scenario

object FluxoUsuarios {

  val cenarioBuscaTodosUsuariosCadastrados = scenario("Busca todos os usuarios cadastrados.")
    .exec(UsuarioApi.BuscarTodos())

  val cenarioCadastrarAlterarDeletar = scenario("Cadastra um usuario, altera e deleta por id.")
    .feed(usuarioscsv)
    .exec(AuthApi.login())
    .exec(UsuarioApi.Cadastrar())
    .exec(UsuarioApi.Alterar())
    .exec(UsuarioApi.Delatar())

  val cenarioCadastrarBuscaPorId = scenario("Cadastra um usuario e busca por id.")
    .feed(usuarioscsv)
    .exec(AuthApi.login())
    .exec(UsuarioApi.Cadastrar())
    .exec(UsuarioApi.BuscarPorId())
    .exec(UsuarioApi.Delatar())

  val cenarioCadastrarDeletar = scenario("Cadastra um usuario e deleta por id.")
    .feed(usuarioscsv)
    .exec(AuthApi.login())
    .exec(UsuarioApi.Cadastrar())
    .exec(UsuarioApi.Delatar())

}
