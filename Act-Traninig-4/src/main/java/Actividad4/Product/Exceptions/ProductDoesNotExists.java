package Actividad4.Product.Exceptions;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value(staticConstructor = "of")
public class ProductDoesNotExists extends ProductException{
	
	Long  id;
	
	public ProductDoesNotExists(Long  id) {
		super(String.format("El producto con id"+ id +" no existe"));
		this.id=id;
	}
	
	

}
