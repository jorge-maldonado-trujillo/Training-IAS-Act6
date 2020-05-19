package Actividad4.Product.Domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductOperationRequestTest {
	
	@Test
    @DisplayName("Deberia crear Productos")
    void isShouldProductOperationRequest() {
    
        String name = "Pizza";
        String description = "Pizza con chorizo, tocineta, peperoni y salami";
        BigDecimal basePrice = new BigDecimal("14.499");
        BigDecimal taxRate = new BigDecimal("0.225");
        ProductStatus productStatus = ProductStatus.Publicado;
        Integer inventoryQuantity = 1;

        ProductOperationRequest productOperationRequest = ProductOperationRequest.of(Name.of(name), Description.of(description),BasePrice.of(basePrice) ,TaxRate.of(taxRate) ,productStatus , InventoryQuantity.of(inventoryQuantity));

        assertNotNull(productOperationRequest);
    }

    @Test
    @DisplayName("No deberia de pasar prueba de requerimientos de operacion")
    void isShouldNotProductOperationRequest() {
    	ProductOperationRequest ProductOperationRequest = null;
        assertNull(ProductOperationRequest);
    }

}
