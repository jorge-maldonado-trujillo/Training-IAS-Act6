package Actividad4.Product.Domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InventoryQuantityTest {

	@Test
	@DisplayName("Deberia crear cantidad de inventario de los Productos")
	void isShouldInventoryQuantity() {
		
		//arrenge organizar todo lo que necesitamos
		// actuar 
		// assertions
		Integer InventoryQuantity1 = 1;
		Integer InventoryQuantity2 = 20;
		
		
		assertAll(
				()->assertNotNull(InventoryQuantity.of(InventoryQuantity1)),
				()->assertNotNull(InventoryQuantity.of(InventoryQuantity2)),
				()->assertTrue(InventoryQuantity1 > 0)
				);
		
		
	}
	
	@Test
	@DisplayName("No deberia crear cantidad de inventario de los productos ")
	void isShouldNotInventoryQuantity() {
		
		Integer InventoryQuantity1 = null;
		Integer InventoryQuantity2 = -5;
		assertAll(
				()-> assertThrows(NullPointerException.class, ()->InventoryQuantity.of(InventoryQuantity1)),
				()->assertTrue(InventoryQuantity2 < 0)
				);
		
	}

}
