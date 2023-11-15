package br.com.relatorio_api.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name= "Item")
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity {

  @Id
  @Column(name = "IdItem")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_Item")
  @SequenceGenerator(sequenceName = "S_Item", allocationSize = 1, name = "S_Item")
  private Integer codigo;

  @Column(name = "TextoItem")
  @NotNull
  private String name;

  @ManyToOne
  @JoinColumn(name="IdCategoria", updatable = false, insertable = false, nullable = false)
  @Fetch(FetchMode.JOIN)
  private CategoryEntity category;

  @Column(name = "Status")
  @CreationTimestamp
  private String status;

  @Column(name = "DataCriado")
  private LocalDateTime createdAt;

  @Column(name = "DataAtualizado")
  private LocalDateTime updatedAt;
}
