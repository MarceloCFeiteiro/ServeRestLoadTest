package br.com.serverest.Utils;

import com.google.gson.Gson;

import java.lang.reflect.Type;


public  class ConversorJson {

  public static String EntidadeParaJson(Object obj){

    System.out.println(new Gson().toJson(obj));

   return new Gson().toJson(obj);

  }
}
