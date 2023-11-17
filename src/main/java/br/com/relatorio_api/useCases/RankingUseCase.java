package br.com.relatorio_api.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import br.com.relatorio_api.bean.RankingCidadeResponseBean;
import br.com.relatorio_api.bean.RankingItemResponseBean;
import br.com.relatorio_api.repository.CidadeRepository;

@Service
public class RankingUseCase {
  
  private JdbcTemplate jdbcTemplate;

  @Autowired
  public void ConsultaService(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
  }
  
  @Autowired
  private CidadeRepository cidadeRepository;

  public RankingItemResponseBean executeRankingItem() {
    String sqlQueryCategoria = "SELECT * FROM `CategoriaReciclavel`".replace('`', '"');
    var categories = jdbcTemplate.queryForList(sqlQueryCategoria);
    RankingItemResponseBean response = new RankingItemResponseBean();
     categories.forEach(category -> {
      String sqlQueryItem = "SELECT count(*) FROM `ItemReciclavel` WHERE `CategoriaReciclavelId` = ".replace('`', '"') + category.get("IdCategoria");
      var itemCount = jdbcTemplate.queryForList(sqlQueryItem);
      response.addParam(category.get("TextoCategoria").toString(), category.get("IdCategoria").toString(), itemCount.get(0).get("count").toString());
   });
    return response;
  }

  public RankingCidadeResponseBean executeRankingCidade() {
    List<String> cidades = cidadeRepository.buscarCidades();

    RankingCidadeResponseBean response = new RankingCidadeResponseBean();
    cidades.forEach(cidade -> {
      Integer countCidade = cidadeRepository.countNumberFromCidade(cidade);
      response.addParam(cidade, countCidade.toString());
    });

    return response;

  }
}
