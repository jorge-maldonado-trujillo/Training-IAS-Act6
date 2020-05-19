package Actividad4.Product.Domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class ProductOperationRequest {
	Name name;
	Description description;
	BasePrice basePrice;
	TaxRate taxRate;
	ProductStatus productStatus;
	InventoryQuantity inventoryQuantity;
	
	/*String name;
	String description;
	BigDecimal basePrice;
	BigDecimal TaxRate;
	String productStatus;
	Integer inventoryQuantity
	*/


}
