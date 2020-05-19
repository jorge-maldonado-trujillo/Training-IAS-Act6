package Actividad4.Product.Domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DescriptionTest {

	@Test
	@DisplayName("Deberia crear Descripciones validas para Productos")
	void isShouldDescription() {
		//arrenge organizar todo lo que necesitamos
		// actuar 
		// assertions
		String Description1 = "Esto es una descripcion";
		String Description2 = "Esto es una descripcion para un producto";
		String Description3 = "Esto es una descripcion para un segundo producto,Esto es una descripcion para un segundo producto,Esto es una descripcion para un segundo producto,Esto es una descripcion para un segundo producto,Esto es una descripcion para un segundo producto,";
		int longitud = Description3.length();
		
		assertAll(
				()->assertNotNull(Description.of(Description1)),
				()->assertNotNull(Description.of(Description2)),
				()->assertNotEquals(Description.of(Description3),""),
				()->assertTrue(longitud <= 280)
				);
		
	}
	
	@Test
	@DisplayName("No deberia Descripciones un Validas para productos ")
	void isShouldNotDescription() {
		
		String Description1 = null;
		String Description2 = "";
		assertAll(
			()-> assertThrows(NullPointerException.class, ()->Description.of(Description1)),
			()-> assertThrows(IllegalArgumentException.class, ()->Description.of(Description2))
				);
		
	}

}
