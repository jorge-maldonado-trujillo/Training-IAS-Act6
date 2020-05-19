package Actividad4.Product.Domain;

import Actividad4.Product.Exceptions.ProductException;
import lombok.Value;

@Value (staticConstructor = "of")
public class ProductOperationSuccess implements ProductOperation{
	
	
	ProductOperationRequest product;

	@Override
	public ProductOperationRequest value() {
		// TODO Auto-generated method stub
		return product;
	}

	@Override
	public ProductException errorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

}
