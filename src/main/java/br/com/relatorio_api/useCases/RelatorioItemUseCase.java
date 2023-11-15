package br.com.relatorio_api.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.relatorio_api.bean.RelatorioItemResponseBean;
import br.com.relatorio_api.entity.CategoryEntity;
import br.com.relatorio_api.repository.CategoryRepository;
import br.com.relatorio_api.repository.ItemRepository;

@Service
public class RelatorioItemUseCase {
  
  @Autowired
  private ItemRepository itemRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  public RelatorioItemResponseBean execute() {

    List<CategoryEntity> categories = categoryRepository.findAll();

    RelatorioItemResponseBean response = new RelatorioItemResponseBean();

    categories.forEach(category -> {
      response.addParam(category.getName(), category.getCodigo(), itemRepository.countItemFromCategory(category.getCodigo()));
  });

    return response;
  }
}
