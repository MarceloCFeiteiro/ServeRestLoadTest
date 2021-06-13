package br.com.serverest.model;

import java.util.UUID;

public class Usuario {
    private String nome;
    private String email;
    private String password;

    public static Usuario CriaUsuario() {
        Usuario u = new Usuario();

        u.nome = UUID.randomUUID().toString().substring(0, 10);
        u.email = u.nome.concat("@email.com");
        u.password = UUID.randomUUID().toString().substring(0, 6);

        return u;
    }
}
