package br.com.relatorio_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.relatorio_api.useCases.RelatorioCidadeUseCase;
import br.com.relatorio_api.useCases.RelatorioItemUseCase;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController {
  
  @Autowired
  private RelatorioItemUseCase relatorioItemUseCase;

  @Autowired 
  private RelatorioCidadeUseCase relatorioCidadeUseCase;

  @GetMapping("/item")
  public ResponseEntity<Object> gerarRelatorioItem() {
    try {
      var result = this.relatorioItemUseCase.execute();
      return ResponseEntity.ok(result);
    }
    catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping("/cidade")
  public ResponseEntity<Object> gerarRelatorioCidade() {
    try {
      var result = this.relatorioCidadeUseCase.execute();

      return ResponseEntity.ok(result);
    }
    catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
