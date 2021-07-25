package br.com.serverest.Scenario

import br.com.serverest.api.{AuthApi, UsuarioApi}
import io.gatling.core.Predef.scenario

object FluxosUsuarios {

  val cenarioBuscaTodosUsuariosCadastrados = scenario("Busca todos os usuarios cadastrados.")
    .exec(UsuarioApi.BuscarTodos())

  val cenarioCadastrarAlterarDeletar = scenario("Cadastra um usuario, altera e deleta por id.")
    .exec(UsuarioApi.Cadastrar())
    .exec(UsuarioApi.Alterar())
    .exec(UsuarioApi.Deletar())

  val cenarioCadastrarBuscaPorId = scenario("Cadastra um usuario e busca por id.")
    .exec(UsuarioApi.Cadastrar())
    .exec(UsuarioApi.BuscarPorId())
    .exec(UsuarioApi.Deletar())

  val cenarioCadastrarDeletar = scenario("Cadastra um usuario e deleta por id.")
    .exec(UsuarioApi.Cadastrar())
    .exec(UsuarioApi.Deletar())


}
