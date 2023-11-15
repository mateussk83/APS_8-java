package br.com.relatorio_api.entity;

import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data
@Entity(name= "Categoria")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryEntity {

  @Id
  @Column(name = "IdCategoria")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_Categoria")
  @SequenceGenerator(sequenceName = "S_Categoria", allocationSize = 1, name = "S_Categoria")
  private Integer codigo;

  @Column(name = "TextoCategoria")
  @NotNull
  private String name;

  @Column(name = "Status")
  private long category;

  @Column(name = "DataAtualizado")
  private LocalDateTime updatedAt;

  @Column(name = "DataCriado")
  private LocalDateTime createdAt;
}
