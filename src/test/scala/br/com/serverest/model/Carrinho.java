package br.com.serverest.model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Produto> produtos = new ArrayList<>() ;


    public static Carrinho criaCarinhoComProdutos() {
        Carrinho c = new Carrinho();

        for (int i = 0; i < 2; i++) {
            c.produtos.add(Produto.criaProduto());
        }

        return c;
    }
}
