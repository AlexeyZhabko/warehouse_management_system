package by.zhabko.warehouse_management_system.repository.postgres;

import by.zhabko.warehouse_management_system.model.entity.DeliveryNotesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryNotesRepository extends JpaRepository<DeliveryNotesEntity, Long> {

}
