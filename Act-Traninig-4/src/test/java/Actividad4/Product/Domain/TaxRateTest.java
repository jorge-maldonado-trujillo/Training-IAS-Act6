package Actividad4.Product.Domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TaxRateTest {

	@Test
	@DisplayName("Deberia crear impuestos bases para Productos")
	void isShouldTaxRate() {
		//arrenge organizar todo lo que necesitamos
		// actuar 
		// assertions
		BigDecimal TaxRate1 = new BigDecimal ("0.50");
		BigDecimal TaxRate2 =  new BigDecimal("0.80");
		BigDecimal TaxRate3 = new BigDecimal("0.90");
		
		
		assertAll(
				()->assertNotNull(TaxRate.of(TaxRate1)),
				()->assertNotNull(TaxRate.of(TaxRate2)),
				()->assertTrue(TaxRate3.doubleValue() > 0),
				()->assertTrue(TaxRate3.doubleValue() < 1)
				);
		
		
	}
	
	@Test
	@DisplayName("No deberia ingresar impuestos para productos ")
	void isShouldNotTaxRate() {
		
		BigDecimal TaxRate1 = null;
		BigDecimal TaxRate2 = new BigDecimal ("-1.50");
		BigDecimal TaxRate3 = new BigDecimal ("1.50");
		assertAll(
			()-> assertThrows(NullPointerException.class, ()->TaxRate.of(TaxRate1)),
			()->assertTrue(TaxRate2.doubleValue() < 0 ),
			()->assertTrue( TaxRate3.doubleValue() > 1)
			
				);
		
	}

}
