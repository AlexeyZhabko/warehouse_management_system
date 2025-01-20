package by.zhabko.warehouse_management_system.repository.postgres;

import by.zhabko.warehouse_management_system.model.entity.CountryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<CountryEntity, Long> {

  boolean existsByName(String name);

  CountryEntity findByName(String name);
}
