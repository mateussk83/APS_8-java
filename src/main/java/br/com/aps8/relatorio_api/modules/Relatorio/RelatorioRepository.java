package br.com.aps8.relatorio_api.modules.items;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {

  @Query(value = "SELECT count(*) FROM ITEM WHERE ITE_CATEGORY = :codigo", nativeQuery = true) 
  long countItemFromCategory(@Param("codigo") long codigo);
}
