package br.com.relatorio_api.bean;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class RankingItemResponseBean {
  private List<Param> params;

  @Data
  @AllArgsConstructor
  public static class Param {
    private String name;
    private String id;
    private String contagem;
  }

  public void addParam(Param param) {
    params.add(param);
  }

  public void addParam(String name, String id, String contagem) {
     addParam(new Param(name, id, contagem)); 
    }

  public RankingItemResponseBean() {
    this.params = new ArrayList<Param>();
  }
}
