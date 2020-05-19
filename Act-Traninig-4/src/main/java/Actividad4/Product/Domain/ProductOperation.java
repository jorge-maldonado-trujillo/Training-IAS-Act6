package Actividad4.Product.Domain;

import Actividad4.Product.Exceptions.ProductException;

public interface ProductOperation {
	
	ProductOperationRequest value();
	
	
	Boolean isValid();
	ProductException errorMessage();

}
