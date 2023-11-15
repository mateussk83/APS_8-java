package br.com.relatorio_api.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.relatorio_api.bean.RelatorioCidadeResponseBean;
import br.com.relatorio_api.entity.RelatorioEntity;
import br.com.relatorio_api.repository.RelatorioRepository;

@Service
public class RelatorioCidadeUseCase {

  @Autowired
  private RelatorioRepository relatorioRepository;

  public RelatorioCidadeResponseBean execute() {

    List<String> cidades = relatorioRepository.buscarCidades();

    RelatorioCidadeResponseBean response = new RelatorioCidadeResponseBean();

    cidades.forEach(cidade -> {
      response.addParam(cidade, relatorioRepository.countNumberFromCidade(cidade));
  });

  return response;
  }
}
