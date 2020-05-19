package Actividad4.Product.Domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class NameTest {

	@Test
	@DisplayName("Deberia crear Nombres validos para Productos")
	void isShouldName() {
		//arrenge organizar todo lo que necesitamos
		// actuar 
		// assertions
		String Name1 = "Jugos";
		String Name2 = "Pizza";
		String Name3 = "Perros";
		int longitud = Name1.length();
		
		assertAll(
				()->assertNotNull(Name.of(Name1)),
				()->assertNotNull(Name.of(Name2)),
				()->assertNotNull(Name.of(Name3)),
				()->assertTrue(longitud < 100)
				);
		
	}
	
	@Test
	@DisplayName("No deberia crear un Nombres para productos ")
	void isShouldNotName() {
		
		String Name1 = null;
		String Name2 = "";
		assertAll(
			()-> assertThrows(NullPointerException.class, ()->Name.of(Name1)),
			()-> assertThrows(IllegalArgumentException.class, ()->Name.of(Name2))
				);
		
	}

}
