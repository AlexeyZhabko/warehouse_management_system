package by.zhabko.warehouse_management_system.configuration;

import by.zhabko.warehouse_management_system.entity.CountryEntity;
import by.zhabko.warehouse_management_system.repository.postgres.CountryRepository;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDbsConfiguration {

  @Bean
  public CommandLineRunner fillCountries(CountryRepository countryRepository) {
    return args -> {
      Map<Long, String> countries = new HashMap<>();

      countries.put(30L, "Австралия");
      countries.put(40L, "Австрия");
      countries.put(24L, "Ангола");
      countries.put(112L, "Беларусь");
      countries.put(56L, "Бельгия");
      countries.put(398L, "Казахстан");
      countries.put(643L, "Россия");

      countries.entrySet()
          .stream()
          .map(entry -> {
            CountryEntity entity = new CountryEntity();
            entity.setId(entry.getKey());
            entity.setName(entry.getValue());

            return entity;
          })
          .forEach(countryRepository::save);
    };
  }
}
