package Actividad4.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import Actividad4.Product.Domain.BasePrice;
import Actividad4.Product.Domain.Description;
import Actividad4.Product.Domain.InventoryQuantity;
import Actividad4.Product.Domain.Name;
import Actividad4.Product.Domain.Product;

import Actividad4.Product.Domain.ProductOperation;
import Actividad4.Product.Domain.ProductOperationRequest;
import Actividad4.Product.Domain.ProductStatus;
import Actividad4.Product.Domain.TaxRate;
import Actividad4.Product.Repositories.SqlProductsRepository;

@Service
public class ProductsService {
	
	
	private final SqlProductsRepository sqlProductsRepository;
	
	private final Gson gson;
	
	public ProductsService( Gson gson, SqlProductsRepository sqlProductsRepository) {
		this.gson=gson;
		this.sqlProductsRepository = sqlProductsRepository;
		
		// TODO Auto-generated constructor stub
	}
	

	public ProductOperation insertOne(Name name, Description description, BasePrice basePrice, TaxRate taxRate, ProductStatus productStatus, InventoryQuantity inventoryQuantity) {
		ProductOperation productOperation = sqlProductsRepository.insertOne(ProductOperationRequest.of(name, description, basePrice, taxRate, productStatus, inventoryQuantity));
		return productOperation;
	}
	
	public ProductOperation findById (Long id) {
		ProductOperation productOperation = sqlProductsRepository.findById(id);
		return productOperation;
		
	}
	
	public List<Product> findAll(){
		List<Product>  productOperation = sqlProductsRepository.findAll();
		return productOperation;
	}
	
	public ProductOperation updateOne(Long id, Name name, Description description, BasePrice basePrice, TaxRate taxRate, ProductStatus productStatus, InventoryQuantity inventoryQuantity) {
		ProductOperation productOperation = sqlProductsRepository.updateOne(id, ProductOperationRequest.of(name, description, basePrice, taxRate, productStatus, inventoryQuantity));
		return productOperation;
	}
	public ProductOperation deleteOne(Long id) {
		ProductOperation productOperation = sqlProductsRepository.deleteOne(id);
		return productOperation;
	}
}
