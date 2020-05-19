package Actividad4.Product.Domain;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductIdTest {

	@Test
	@DisplayName("Deberia crear Id validos para Productos")
	void isShouldProductId() {
		//arrenge organizar todo lo que necesitamos
		// actuar 
		// assertions
		Long productId1 = 1L;
		Long productId2 = 2L;
		Long productId3 = 3L;
		
		assertAll(
				()->assertNotNull(ProductId.of(productId1)),
				()->assertNotNull(ProductId.of(productId2)),
				()->assertNotNull(ProductId.of(productId3))
				);
		
	}
	
	@Test
	@DisplayName("No deberia crear un Id para productos ")
	void isShouldNotProductId() {
		
		Long productId1 = null;
		Long productId2 = 0L;
		assertAll(
			()-> assertThrows(NullPointerException.class, ()->ProductId.of(productId1)),
			()-> assertThrows(IllegalArgumentException.class, ()->ProductId.of(productId2))
				);
		
	}

}
