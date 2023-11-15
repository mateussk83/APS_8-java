package br.com.aps8.relatorio_api.modules.items;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name= "item")
@NoArgsConstructor
public class ItemEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "ITE_COD")
  private UUID codigo;

  @Column(name = "ITE_NAME")
  private String name;

  @Column(name = "ITE_CATEGORY")
  private long category;

  @Column(name = "ITE_DTHORA")
  @CreationTimestamp
  private LocalDateTime createdAt;
}
