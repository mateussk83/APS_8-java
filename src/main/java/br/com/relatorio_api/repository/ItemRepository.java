package br.com.relatorio_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.relatorio_api.entity.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {

  @Query(value = "SELECT count(*) FROM ItemReciclavel WHERE IdCategoriasReciclaveis = :codigo", nativeQuery = true) 
  Integer countItemFromCategory(@Param("codigo") Integer codigo);
}
