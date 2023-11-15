package br.com.relatorio_api.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

public class RelatorioCidadeResponseBean {
    private List<Param> params;

  @Data
  @AllArgsConstructor
  public static class Param {
    private String name;
    private long contagem;
  }

  public void addParam(Param param) {
    params.add(param);
  }

  public void addParam(String name, long contagem) {
     addParam(new Param(name,contagem)); 
    }

}
