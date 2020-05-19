package Actividad4.Product.Controllers;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import Actividad4.Product.Domain.Product;
import Actividad4.Product.Domain.ProductOperation;
import Actividad4.Product.Domain.ProductOperationRequest;
import Actividad4.Services.ProductsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductControllers { 
	
	private final ProductsService productsService;
	
	@PostMapping
	public ProductOperation insertOne(@RequestBody ProductOperationRequest productOperationRequest){
	return productsService.insertOne(productOperationRequest.getName(),productOperationRequest.getDescription(),productOperationRequest.getBasePrice(),productOperationRequest.getTaxRate(),productOperationRequest.getProductStatus(),productOperationRequest.getInventoryQuantity());
		
	}
	@GetMapping("/{id}")
	public ProductOperation findById(@PathVariable Long id){
		return productsService.findById(id);
		
	}
	
	@GetMapping("/")
	public List<Product> findAll(){
		return productsService.findAll();
		
	}
	@PutMapping("/{id}")
	public ProductOperation updateOne(@PathVariable Long id, @RequestBody ProductOperationRequest productOperationRequest) {
		return productsService.updateOne(id, productOperationRequest.getName(),productOperationRequest.getDescription(),productOperationRequest.getBasePrice(),productOperationRequest.getTaxRate(),productOperationRequest.getProductStatus(),productOperationRequest.getInventoryQuantity());
		
	}
	@DeleteMapping("/{id}")
	public ProductOperation deleteOne(@PathVariable Long id) {
		return productsService.deleteOne(id);
	}
	

}
