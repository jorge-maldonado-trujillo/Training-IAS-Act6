package Actividad4.Product.Domain;

import java.math.BigDecimal;

import Actividad4.Serialization.BigDecimalSerializable;
import Actividad4.common.preconditions;
import lombok.Value;

@Value (staticConstructor = "of")
public class BasePrice implements BigDecimalSerializable{
	BigDecimal value;

	public BasePrice(BigDecimal value) {
		preconditions.checkNotNull(value);
		preconditions.checkArgument(value.doubleValue() > 0);
		this.value = value;
	}
	
	@Override
	public BigDecimal valueOf() {
		return value;
	}
	
	

	
	
	

}
