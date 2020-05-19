package Actividad4.Product.Repositories;

import java.util.List;

import Actividad4.Product.Domain.Product;
import Actividad4.Product.Domain.ProductOperation;
import Actividad4.Product.Domain.ProductOperationRequest;

public interface ProductsRepository {

	ProductOperation insertOne(ProductOperationRequest productOperationRequest);

	ProductOperation findById(Long id);

	List<Product> findAll();

	ProductOperation updateOne(Long id, ProductOperationRequest productOperationRequest);

	ProductOperation deleteOne(Long id);

	

}
