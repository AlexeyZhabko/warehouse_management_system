package by.zhabko.warehouse_management_system;

import org.springframework.boot.SpringApplication;

public class TestWarehouseManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.from(WarehouseManagementSystemApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
