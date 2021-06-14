package br.com.serverest.model;

import java.util.UUID;

public class Usuario {
    private String nome;
    private String email;
    private String password;
    private String administrador;

    public static Usuario CriaUsuarioAdministrador() {
        Usuario u = new Usuario();

        u.nome = UUID.randomUUID().toString().substring(0, 10);
        u.email = u.nome.concat("@email.com");
        u.password = UUID.randomUUID().toString().substring(0, 6);
        u.administrador = "true";

        return u;
    }
}
