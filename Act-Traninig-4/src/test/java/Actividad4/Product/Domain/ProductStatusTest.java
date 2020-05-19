package Actividad4.Product.Domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductStatusTest {

	@Test
	@DisplayName("Deberia crear estado de los Productos")
	void isShouldProductStatus() {
		//arrenge organizar todo lo que necesitamos
		// actuar 
		// assertions
		String ProductStatus1 = "Borrador";
		String ProductStatus2 =  "Publicado";
		
		
		assertAll(
				()->assertEquals(ProductStatus.Borrador.toString(), ProductStatus1),
				()->assertEquals(ProductStatus.Publicado.toString(), ProductStatus2)
				);
		
		
	}
	
	@Test
	@DisplayName("No deberia crear estados de los productos ")
	void isShouldNotProductStatus() {
		
		String ProductStatus1 = null;
		String ProductStatus2 = "";
		String ProductStatus3 = "Activo";
		assertAll(
				()->assertNotEquals(ProductStatus.Publicado.toString(), ProductStatus3),
				()->assertNotEquals(ProductStatus.Borrador.toString(), ProductStatus3)
				);
		
	}

}
