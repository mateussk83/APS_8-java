package br.com.aps8.relatorio_api.modules.items.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aps8.relatorio_api.constant.CategoryConstant;
import br.com.aps8.relatorio_api.constant.CategoryDescriptionConstant;
import br.com.aps8.relatorio_api.modules.items.ItemEntity;
import br.com.aps8.relatorio_api.modules.items.ItemRepository;
import br.com.aps8.relatorio_api.modules.items.bean.RelatorioResponseBean;

@Service
public class ItemUseCase {
  
  @Autowired
  private ItemRepository itemRepository;

  public ItemEntity execute(ItemEntity itemEntity) {
    return this.itemRepository.save(itemEntity);
  }

  public Object createRelatorio() {
    RelatorioResponseBean response = new RelatorioResponseBean();

    response.addParam(
      CategoryDescriptionConstant.CONSTRUCAO_DEMOLICAO, 
      CategoryConstant.CONSTRUCAO_DEMOLICAO, 
      itemRepository.countItemFromCategory(CategoryConstant.CONSTRUCAO_DEMOLICAO));
    response.addParam(
      CategoryDescriptionConstant.DIVERSOS, 
      CategoryConstant.DIVERSOS, 
      itemRepository.countItemFromCategory(CategoryConstant.DIVERSOS));
    response.addParam(
      CategoryDescriptionConstant.ELETRICOS, 
      CategoryConstant.ELETRICOS, 
      itemRepository.countItemFromCategory(CategoryConstant.ELETRICOS));
    response.addParam(
      CategoryDescriptionConstant.ELETRODOMESTICO, 
      CategoryConstant.ELETRODOMESTICO, 
      itemRepository.countItemFromCategory(CategoryConstant.ELETRODOMESTICO));
    response.addParam(
      CategoryDescriptionConstant.EMBALAGEM_CARTONADA, 
      CategoryConstant.EMBALAGEM_CARTONADA, 
      itemRepository.countItemFromCategory(CategoryConstant.EMBALAGEM_CARTONADA));
    response.addParam(
      CategoryDescriptionConstant.LAMPADAS, 
      CategoryConstant.LAMPADAS, 
      itemRepository.countItemFromCategory(CategoryConstant.LAMPADAS));
    response.addParam(
      CategoryDescriptionConstant.LIQUIDOS_E_PRODUTOS_QUIMICOS, 
      CategoryConstant.LIQUIDOS_E_PRODUTOS_QUIMICOS, 
      itemRepository.countItemFromCategory(CategoryConstant.LIQUIDOS_E_PRODUTOS_QUIMICOS));
    response.addParam(
      CategoryDescriptionConstant.MATERIAIS_ORGANICOS, 
      CategoryConstant.MATERIAIS_ORGANICOS, 
      itemRepository.countItemFromCategory(CategoryConstant.MATERIAIS_ORGANICOS));
    response.addParam(
      CategoryDescriptionConstant.METAIS, 
      CategoryConstant.METAIS, 
      itemRepository.countItemFromCategory(CategoryConstant.METAIS));
    response.addParam(
      CategoryDescriptionConstant.MOVEIS, 
      CategoryConstant.MOVEIS, 
      itemRepository.countItemFromCategory(CategoryConstant.MOVEIS));
    response.addParam(
      CategoryDescriptionConstant.OLEOS, 
      CategoryConstant.OLEOS, 
      itemRepository.countItemFromCategory(CategoryConstant.OLEOS));
    response.addParam(
      CategoryDescriptionConstant.PAPELAO_E_PAPEL, 
      CategoryConstant.PAPELAO_E_PAPEL, 
      itemRepository.countItemFromCategory(CategoryConstant.PAPELAO_E_PAPEL));
    response.addParam(
      CategoryDescriptionConstant.PILHAS_BATERIAS, 
      CategoryConstant.PILHAS_BATERIAS, 
      itemRepository.countItemFromCategory(CategoryConstant.PILHAS_BATERIAS));
    response.addParam(
      CategoryDescriptionConstant.PLASTICO, 
      CategoryConstant.PLASTICO, 
      itemRepository.countItemFromCategory(CategoryConstant.PLASTICO));
    response.addParam(
      CategoryDescriptionConstant.REMEDIOS, 
      CategoryConstant.REMEDIOS, 
      itemRepository.countItemFromCategory(CategoryConstant.REMEDIOS));
    response.addParam(
      CategoryDescriptionConstant.VEICULOS, 
      CategoryConstant.VEICULOS, 
      itemRepository.countItemFromCategory(CategoryConstant.VEICULOS));
    response.addParam(
      CategoryDescriptionConstant.VESTUARIO, 
      CategoryConstant.VESTUARIO, 
      itemRepository.countItemFromCategory(CategoryConstant.VESTUARIO));
    response.addParam(
      CategoryDescriptionConstant.VESTUARIO, 
      CategoryConstant.VESTUARIO, 
      itemRepository.countItemFromCategory(CategoryConstant.VESTUARIO));
    response.addParam(CategoryDescriptionConstant.VIDRO, 
    CategoryConstant.VIDRO, 
    itemRepository.countItemFromCategory(CategoryConstant.VIDRO));

    return response;
  }
}
