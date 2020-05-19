package Actividad4.Product.Domain;

import java.math.BigDecimal;

import Actividad4.Serialization.BigDecimalSerializable;
import Actividad4.common.preconditions;
import lombok.Value;

@Value (staticConstructor = "of")
public class TaxRate implements BigDecimalSerializable{
	BigDecimal value;

	public TaxRate(BigDecimal value) {
		preconditions.checkNotNull(value);
		preconditions.checkArgument(value.doubleValue() > 0 && value.doubleValue() <1);
		this.value = value;
	}

	@Override
	public BigDecimal valueOf() {
		// TODO Auto-generated method stub
		return value;
	}
	
	

}
