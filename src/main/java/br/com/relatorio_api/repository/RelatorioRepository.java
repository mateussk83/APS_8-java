package br.com.relatorio_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.relatorio_api.entity.RelatorioEntity;

@Repository
public interface RelatorioRepository extends JpaRepository<RelatorioEntity, Integer> {
  
  @Query(value = "SELECT DISTINCT TextoCidade FROM Cidade", nativeQuery = true) 
  List<String> buscarCidades();

  @Query(value = "SELECT count(*) FROM Cidade WHERE TextoCidade = :cidade", nativeQuery = true) 
  Integer countNumberFromCidade(@Param("cidade") String cidade);
}