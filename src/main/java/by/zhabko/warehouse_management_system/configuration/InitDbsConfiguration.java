package by.zhabko.warehouse_management_system.configuration;

import by.zhabko.warehouse_management_system.model.entity.CountryEntity;
import by.zhabko.warehouse_management_system.repository.postgres.CountryRepository;
import java.util.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDbsConfiguration {

  @Bean
  public CommandLineRunner fillCountries(CountryRepository countryRepository) {
    return args -> {

      Stream.of("Австралия", "Австрия", "Ангола", "Беларусь", "Бельгия", "Казахстан", "Россия")
          .filter(countryName -> !countryRepository.existsByName(countryName))
          .map(CountryEntity::new)
          .forEach(countryRepository::save);
    };
  }
}
