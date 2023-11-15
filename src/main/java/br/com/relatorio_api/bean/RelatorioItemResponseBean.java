package br.com.relatorio_api.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class RelatorioItemResponseBean {
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
