package Actividad4.Product.Domain;

import java.math.BigDecimal;

import lombok.Value;

@Value(staticConstructor = "of")
public class Product {
	ProductId ID;
	Name name;
	Description description;
	BasePrice basePrice;
	TaxRate taxRate;
	ProductStatus productStatus;
	InventoryQuantity inventoryQuantity;
	
	public static Product of(long l, String string, String string2, BigDecimal valueOf, BigDecimal valueOf2,
			String string3, int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
