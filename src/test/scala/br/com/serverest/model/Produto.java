package br.com.serverest.model;

import java.util.Random;
import java.util.UUID;

public class Produto {

  public String nome;
  public int preco;
  public String descricao;
  public int quantidade;


  public static Produto criaProduto() {

    Produto p = new Produto();

    p.nome = UUID.randomUUID().toString();
    p.preco = new Random().nextInt(5000);
    p.descricao = UUID.randomUUID().toString();
    p.quantidade = new Random().nextInt(20);

    return p;
  }

}
