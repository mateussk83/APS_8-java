package br.com.relatorio_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.relatorio_api.bean.RequestCidadeBean;
import br.com.relatorio_api.useCases.CidadeUseCase;


@RestController
@RequestMapping("/cidade")
public class CidadeController {
    
  @Autowired
  private CidadeUseCase cidadeUseCase;

    @PostMapping("/")
  public ResponseEntity<Object> criarCidade(@RequestBody RequestCidadeBean requestCidadeBean) {
    try {
      var result = this.cidadeUseCase.create(requestCidadeBean.getCep());
      return ResponseEntity.ok(result);
    }
    catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
