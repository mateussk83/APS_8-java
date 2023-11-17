package br.com.relatorio_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.relatorio_api.useCases.CidadeUseCase;
import br.com.relatorio_api.useCases.RankingUseCase;

@RestController
@RequestMapping("/relatorio")
public class RankingController {
  
  @Autowired
  private RankingUseCase rankingUseCase;

  @GetMapping("/item")
  public ResponseEntity<Object> gerarRelatorioItem() {
    try {
      var result = this.rankingUseCase.executeRankingItem();
      return ResponseEntity.ok(result);
    }
    catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping("/cidade")
  public ResponseEntity<Object> gerarRelatorioCidade() {
    try {
      var result = this.rankingUseCase.executeRankingCidade();

      return ResponseEntity.ok(result);
    }
    catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
