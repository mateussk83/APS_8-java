package br.com.aps8.relatorio_api.modules.items.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aps8.relatorio_api.modules.items.ItemEntity;
import br.com.aps8.relatorio_api.modules.items.useCases.ItemUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/item")
public class ItemsController {
  
  @Autowired
  private ItemUseCase itemUseCase;

  @PostMapping("/")
  public ResponseEntity<Object> add(@Valid @RequestBody ItemEntity itemEntity) {
    try {
      var result = this.itemUseCase.execute(itemEntity);
      return ResponseEntity.ok(result);
    }
    catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping("/relatorio")
  public ResponseEntity<Object> gerarRelatorio() {
    try {
      var result = this.itemUseCase.createRelatorio();
      return ResponseEntity.ok(result);
    }
    catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
