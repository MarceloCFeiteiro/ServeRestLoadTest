package br.com.serverest.model;

import java.util.UUID;

public class Usuario {

    private String nome;
    private String email;
    private String password;
    private String administrador;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    public static Usuario CriaUsuarioAdministrador() {
        Usuario u = new Usuario();

        u.nome = UUID.randomUUID().toString().substring(0, 10);
        u.email = u.nome.concat("@email.com");
        u.password = UUID.randomUUID().toString().substring(0, 6);
        u.administrador = "true";

        return u;
    }
}
