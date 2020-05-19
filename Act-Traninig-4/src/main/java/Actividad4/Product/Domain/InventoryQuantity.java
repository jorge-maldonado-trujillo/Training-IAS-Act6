package Actividad4.Product.Domain;

import Actividad4.Serialization.IntegerSerializable;
import Actividad4.common.preconditions;
import lombok.Value;

@Value (staticConstructor = "of")
public class InventoryQuantity implements IntegerSerializable {
	Integer value;

	public InventoryQuantity(Integer value) {
		preconditions.checkNotNull(value);
		preconditions.checkArgument(value.intValue() >=1);
		this.value = value;
	}

	@Override
	public Integer valueOf() {
		// TODO Auto-generated method stub
		return value;
	}
	
	

}
