package by.zhabko.warehouse_management_system.controller;

import by.zhabko.warehouse_management_system.mapper.CustomsDeclarationMapper;
import by.zhabko.warehouse_management_system.model.input.CustomsDeclarationInput;
import by.zhabko.warehouse_management_system.model.output.CustomsDeclarationOutput;
import by.zhabko.warehouse_management_system.service.CustomsDeclarationService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "v1/declarations")
public class CustomsDeclarationsControllerV1 {

  private final CustomsDeclarationService customsDeclarationService;
  private final CustomsDeclarationMapper customsDeclarationMapper;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<CustomsDeclarationOutput> getAll() {
    return customsDeclarationService.findAll()
        .stream()
        .map(customsDeclarationMapper::toOutput)
        .collect(Collectors.toList());
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public CustomsDeclarationOutput insertDeclaration(@RequestBody CustomsDeclarationInput input) {
    return Optional.ofNullable(input)
        .map(customsDeclarationService::insertDeclaration)
        .map(customsDeclarationMapper::toOutput)
        .orElse(null);
  }
}
