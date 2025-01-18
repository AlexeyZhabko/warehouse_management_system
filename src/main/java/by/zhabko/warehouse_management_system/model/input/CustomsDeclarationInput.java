package by.zhabko.warehouse_management_system.model.input;

import java.util.List;
import lombok.Data;

@Data
public class CustomsDeclarationInput {
  private Company customer;
  private Company seller;
  private List<CustomsDeclarationItem> items;
}
