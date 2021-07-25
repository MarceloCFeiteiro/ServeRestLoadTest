package br.com.serverest.Utils;

import br.com.serverest.model.Usuario;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class ConversorCSV {

    public static <T> void EntidadeParaCSV(T obj)  {
        List<T> list = new ArrayList<>();
       // pessoas.add(new CsvPessoa("Joao",35,"joao@dicasdejava.com.br"));
       // pessoas.add(new CsvPessoa("Maria",23,"maria@dicasdeprogramacao.com.br"));
       // pessoas.add(new CsvPessoa("Ana",25,"ana@dicasdejava.com.br"));

        list.add(obj);

        try (Writer writer = Files.newBufferedWriter(Paths.get("src/test/resources/bodies/data/pessoas.csv"))) {
            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder(writer).build();

            beanToCsv.write(list);

            writer.flush();
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
    }

}
