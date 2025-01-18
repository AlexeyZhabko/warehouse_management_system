package by.zhabko.warehouse_management_system.facade;

import by.zhabko.warehouse_management_system.model.entity.CountryEntity;
import by.zhabko.warehouse_management_system.repository.postgres.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component(DictionaryFacade.NAME)
@RequiredArgsConstructor
public class DictionaryFacade {

  public static final String NAME = "dictionaryFacade";

  private final CountryRepository countryRepository;

  //todo add caching
  public CountryEntity getCountryEntityByName(String countryName) {
    return countryRepository.findByName(countryName);
  }
}
