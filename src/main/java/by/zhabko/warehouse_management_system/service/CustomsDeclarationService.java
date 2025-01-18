package by.zhabko.warehouse_management_system.service;

import by.zhabko.warehouse_management_system.mapper.CustomsDeclarationMapper;
import by.zhabko.warehouse_management_system.model.entity.DeliveryNotesEntity;
import by.zhabko.warehouse_management_system.model.input.CustomsDeclarationInput;
import by.zhabko.warehouse_management_system.repository.postgres.DeliveryNotesRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service(CustomsDeclarationService.NAME)
@RequiredArgsConstructor
public class CustomsDeclarationService {

  public static final String NAME = "customsDeclarationService";

  private final CustomsDeclarationMapper customsDeclarationMapper;
  private final DeliveryNotesRepository deliveryNotesRepository;

  public DeliveryNotesEntity insertDeclaration(CustomsDeclarationInput input) {
    return Optional.ofNullable(input)
        .map(customsDeclarationMapper::toEntity)
        .map(deliveryNotesRepository::save)
        .orElseThrow(() -> new IllegalArgumentException("CustomsDeclarationInput cannot be null"));
  }

  public List<DeliveryNotesEntity> findAll() {
    return deliveryNotesRepository.findAll();
  }
}
