package br.com.relatorio_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.relatorio_api.entity.CidadeEntity;

@Repository
public interface CidadeRepository extends JpaRepository<CidadeEntity, Integer> {
  
  @Query(value = "SELECT DISTINCT texto_cidade FROM cidade", nativeQuery = true) 
  List<String> buscarCidades();

  @Query(value = "SELECT count(*) FROM cidade where texto_cidade = :cidade", nativeQuery = true) 
  Integer countNumberFromCidade(@Param("cidade") String cidade);
}