package Actividad4.Product.Domain;


import Actividad4.Serialization.LongSerializable;
import Actividad4.common.preconditions;
import lombok.Value;

@Value (staticConstructor = "of")
public class ProductId implements LongSerializable{
	Long value;

	public ProductId(Long value) {
		preconditions.checkNotNull(value);
		preconditions.checkArgument(value >= 1);
		this.value = value;
	}

	@Override
	public Long valueOf() {
		return value;
	}
	
	
}
