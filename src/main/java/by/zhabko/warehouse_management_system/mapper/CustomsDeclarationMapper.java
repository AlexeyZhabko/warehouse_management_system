package by.zhabko.warehouse_management_system.mapper;

import by.zhabko.warehouse_management_system.facade.DictionaryFacade;
import by.zhabko.warehouse_management_system.model.entity.CompanyEntity;
import by.zhabko.warehouse_management_system.model.entity.CountryEntity;
import by.zhabko.warehouse_management_system.model.entity.DeliveryNotesEntity;
import by.zhabko.warehouse_management_system.model.entity.DeliveryNotesItemEntity;
import by.zhabko.warehouse_management_system.model.input.Company;
import by.zhabko.warehouse_management_system.model.input.CustomsDeclarationInput;
import by.zhabko.warehouse_management_system.model.input.CustomsDeclarationItem;
import by.zhabko.warehouse_management_system.model.output.CustomsDeclarationOutput;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class CustomsDeclarationMapper {

  @Autowired
  private DictionaryFacade dictionaryFacade;

  @Mapping(target = "totalPrice", source = "input")
  public abstract DeliveryNotesEntity toEntity(CustomsDeclarationInput input);

  public abstract CustomsDeclarationOutput toOutput(DeliveryNotesEntity entity);

  @Mapping(target = "country", source = "company")
  public abstract CompanyEntity toEntity(Company company);

  @AfterMapping
  public void setParent(CustomsDeclarationInput input, @MappingTarget DeliveryNotesEntity entity) {
    for (DeliveryNotesItemEntity item : entity.getItems()) {
      item.setDeliveryNote(entity);
    }
  }

  public Long countTotalPrice(CustomsDeclarationInput input) {
    return input.getItems().stream().mapToLong(CustomsDeclarationItem::getPrice).sum();
  }

  public String countryNameExtractor(CountryEntity countryEntity) {
    return countryEntity.getName();
  }

  public CountryEntity countryEntityByCompanyName(Company company) {
    return dictionaryFacade.getCountryEntityByName(company.getCountry());
  }
}
