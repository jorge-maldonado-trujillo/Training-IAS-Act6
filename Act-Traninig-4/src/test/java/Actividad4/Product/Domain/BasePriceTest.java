package Actividad4.Product.Domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BasePriceTest {

	@Test
	@DisplayName("Deberia crear precios bases para Productos")
	void isShouldBasePrice() {
		//arrenge organizar todo lo que necesitamos
		// actuar 
		// assertions
		BigDecimal BasePrice1 = new BigDecimal ("1.50");
		BigDecimal BasePrice2 =  new BigDecimal("1.80");
		BigDecimal BasePrice3 = new BigDecimal("1.90");
		
		
		assertAll(
				()->assertNotNull(BasePrice.of(BasePrice1)),
				()->assertNotNull(BasePrice.of(BasePrice2)),
				()->assertTrue(BasePrice3.doubleValue() > 0)
				);
		
	}
	
	@Test
	@DisplayName("No deberia ingresar precios bases para productos ")
	void isShouldNotBasePrice() {
		
		BigDecimal BasePrice1 = null;
		BigDecimal BasePrice2 = new BigDecimal ("-1.50");
		assertAll(
			()-> assertThrows(NullPointerException.class, ()->BasePrice.of(BasePrice1)),
			()->assertTrue(BasePrice2.doubleValue() < 0)
				);
		
	}
}
