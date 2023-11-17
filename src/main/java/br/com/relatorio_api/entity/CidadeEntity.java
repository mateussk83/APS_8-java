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
@Entity(name= "cidade")
@NoArgsConstructor
public class CidadeEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_cidade")
  @SequenceGenerator(sequenceName = "S_cidade", allocationSize = 1, name = "S_cidade")
  private Integer codigo;
  
  @Column(name = "texto_cidade")
  @NotNull
  private String name;

  @Column(name = "data_criado")
  private LocalDateTime createdAt;

  @Column(name = "data_atualizado")
  private LocalDateTime updatedAt;
  
}

