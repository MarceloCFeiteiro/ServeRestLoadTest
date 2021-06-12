package br.com.serverest.Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ManipularArquivo {

  private static String caminho = System.getProperty("user.dir").concat("/src/test/resources/bodies/data/produto.json");

  public static void salvaArquivo(String obj) {
    try {
      FileWriter arquivo = new FileWriter(caminho);
      arquivo.write(obj);
      arquivo.close();

    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public static String LerArquivo(String caminhoArquivo){
    String conteudoArquivo = null;
    try {
      Path path = Paths.get(caminhoArquivo);
      List<String> linhas = Files.readAllLines(path);

      for (String linha:linhas) {
        conteudoArquivo += linha;
      }

    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    return conteudoArquivo.trim();
  }
}
