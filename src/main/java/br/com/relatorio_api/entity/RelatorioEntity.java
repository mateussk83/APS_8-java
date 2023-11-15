package br.com.relatorio_api.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name= "Cidade")
@NoArgsConstructor
public class RelatorioEntity {

  @Id
  @Column(name = "IdCidade")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_Cidade")
  @SequenceGenerator(sequenceName = "S_Cidade", allocationSize = 1, name = "S_Cidade")
  private Integer codigo;
  
  @Column(name = "TextoCidade")
  @NotNull
  private String name;

  @Column(name = "DataCriado")
  private LocalDateTime createdAt;

  @Column(name = "DataAtualizado")
  private LocalDateTime updatedAt;
  
}

