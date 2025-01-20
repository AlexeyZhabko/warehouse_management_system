package by.zhabko.warehouse_management_system.model.output;

import java.util.List;
import lombok.Data;

@Data
public class CustomsDeclarationOutput {
  private Long id;
  private Company customer;
  private Company seller;
  private List<CustomsDeclarationItem> items;
}
