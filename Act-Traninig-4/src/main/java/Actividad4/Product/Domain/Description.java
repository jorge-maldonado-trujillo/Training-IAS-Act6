package Actividad4.Product.Domain;

import Actividad4.Serialization.StringSerializable;
import Actividad4.common.preconditions;
import lombok.Value;

@Value (staticConstructor = "of")
public class Description implements StringSerializable{
	String value;

	public Description(String value) {
		preconditions.checkNotNull(value);
		preconditions.checkArgument(io.micrometer.core.instrument.util.StringUtils.isNotBlank(value));
		preconditions.checkArgument(value.length() <=280);
		this.value = value;
	}

	@Override
	public String valueOf() {
		// TODO Auto-generated method stub
		return value;
	}
	
	

}
