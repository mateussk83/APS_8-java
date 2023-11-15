package br.com.aps8.relatorio_api.modules.items.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class RelatorioResponseBean {
  private List<Param> params;

  @Data
  @AllArgsConstructor
  public static class Param {
    private String name;
    private long id;
    private long contagem;
  }

  public void addParam(Param param) {
    params.add(param);
  }

  public void addParam(String name, long id, long contagem) {
     addParam(new Param(name, id,contagem)); 
    }

  

}
