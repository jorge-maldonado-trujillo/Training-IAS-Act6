package Actividad4.Product.Domain;

import Actividad4.Product.Exceptions.ProductDoesNotExists;
import Actividad4.Product.Exceptions.ProductException;
import lombok.Value;

@Value(staticConstructor = "of")
public class ProductOperationFailure implements ProductOperation{
	
	ProductDoesNotExists exception;

	@Override
	public ProductOperationRequest value() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductException errorMessage() {
		// TODO Auto-generated method stub
		return exception;
	}

	@Override
	public Boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

}
