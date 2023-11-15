package br.com.relatorio_api.useCases;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.relatorio_api.bean.RelatorioResponseBean;
import br.com.relatorio_api.entity.CategoryEntity;
import br.com.relatorio_api.entity.ItemEntity;
import br.com.relatorio_api.repository.CategoryRepository;
import br.com.relatorio_api.repository.ItemRepository;

@Service
public class RelatorioItemUseCase {
  
  @Autowired
  private ItemRepository itemRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  public RelatorioResponseBean execute() {

    List<CategoryEntity> categories = categoryRepository.findAll();

    RelatorioResponseBean response = new RelatorioResponseBean();

    categories.forEach(category -> {
      response.addParam(category.getName(), category.getCodigo(), itemRepository.countItemFromCategory(category.getCodigo()));
  });

    return response;
  }
}
