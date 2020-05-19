package Actividad4.Product.Controllers;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.google.gson.Gson;
import Actividad4.Product.Domain.*;
import Actividad4.Product.Domain.Description;
import Actividad4.Product.Domain.InventoryQuantity;
import Actividad4.Product.Domain.Name;
import Actividad4.Product.Domain.Product;
import Actividad4.Product.Domain.ProductOperationFailure;
import Actividad4.Product.Domain.ProductOperationRequest;
import Actividad4.Product.Domain.ProductOperationSuccess;
import Actividad4.Product.Domain.ProductStatus;
import Actividad4.Product.Domain.TaxRate;
import Actividad4.Product.Exceptions.ProductDoesNotExists;
import Actividad4.Services.ProductsService;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllersTest {
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	ProductsService service;
	
	@Autowired
	private Gson gson;
	
	private List<Product> array;
	
	
	@Test
	void insertOne() throws Exception  {
		ProductOperationRequest productOperationRequest = ProductOperationRequest.of(
				Name.of("Copa"), 
				Description.of("America de cali"), 
				BasePrice.of(new BigDecimal("1.52")), 
				TaxRate.of(new BigDecimal("0.8")), 
				ProductStatus.valueOf("Publicado"), 
				InventoryQuantity.of(2));
		
		String productJson = this.gson.toJson(productOperationRequest);

        when(service.insertOne(any(), any(), any(), any(), any(), any()))
                .thenReturn(ProductOperationSuccess.of(productOperationRequest));

        //act
        
        MockHttpServletRequestBuilder servletRequestBuilder = MockMvcRequestBuilders.post("/api/v1/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productJson);
        System.out.println("Hola"+productJson);
        this.mockMvc.perform(servletRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(productJson));
        
        

        
        /*
        this.mockMvc.perform(post("/api/v1/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productJson))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(content().json(productJson));*/

      
	}
	
	@Test
    void insertOneEmpty() throws Exception {
        when(service.insertOne(any(), any(), any(), any(), any(), any()))
                .thenReturn(null);

        //act
        this.mockMvc.perform(post("/api/v1/products"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
	
	@Test
	void findById() throws Exception {
		ProductOperationRequest ProductOperation = ProductOperationRequest.of(
				Name.of("Pizza"), 
				Description.of("Pizza con vegetales"), 
				BasePrice.of(new BigDecimal("1.50")), 
				TaxRate.of(new BigDecimal("0.50")), 
				ProductStatus.valueOf("Borrador"), 
				InventoryQuantity.of(5));
		
		when(service.findById(anyLong())).thenReturn(ProductOperationSuccess.of(ProductOperation));
		
		MockHttpServletRequestBuilder servletRequestBuilder = MockMvcRequestBuilders.get("/api/v1/products/1");
        this.mockMvc.perform(servletRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk());
	}
	
	@Test
	void findByIdEmpty() throws Exception {
		 when(service.findById(anyLong()))
         .thenReturn(ProductOperationFailure.of(ProductDoesNotExists.of(anyLong())));
		 
		 //act
		 MockHttpServletRequestBuilder servletRequestBuilder = MockMvcRequestBuilders.get("/api/v1/products/1");
		 this.mockMvc.perform(servletRequestBuilder)
         .andDo(print())
         .andExpect(status().isOk());
	}
	
	@Test
	void findAll() throws Exception{
		
		when(service.findAll())
        .thenReturn(array);
		
		//act
        MockHttpServletRequestBuilder servletRequestBuilder = MockMvcRequestBuilders.get("/api/v1/products/");
        this.mockMvc.perform(servletRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk());
		
	}

	@Test
	void findAllEmpty() throws Exception{
		when(service.findAll())
        .thenReturn(array);
		
		//act
		MockHttpServletRequestBuilder servletRequestBuilder = MockMvcRequestBuilders.get("/api/v1/products/");
        this.mockMvc.perform(servletRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk());
		
	}
	
	@Test
	void updateOne() throws Exception{
		ProductOperationRequest product = ProductOperationRequest.of(
				Name.of("Pizza"), 
				Description.of("Pizza con vegetales"), 
				BasePrice.of(new BigDecimal("1.50")), 
				TaxRate.of(new BigDecimal("0.60")), 
				ProductStatus.valueOf("Publicado"), 
				InventoryQuantity.of(5));
		
		
		
		//organizar
		String productJson = this.gson.toJson(product);
		
		when(service.updateOne(any(),any(), any(), any(), any(), any(), any()))
		.thenReturn(ProductOperationSuccess.of(product));
		
		//act
		this.mockMvc.perform(put("/api/v1/products/1")
				.param("id","1")
		        .contentType(MediaType.APPLICATION_JSON)
		        .content(productJson))
				.andDo(print())
				.andExpect(status().isOk());
		
	}
	
	@Test
	void updateOneEmpty() throws Exception{
		
		when(service.updateOne(any(),any(), any(), any(), any(), any(), any()))
        .thenReturn(null);
		
		//act
		this.mockMvc.perform(put("/api/v1/products/1"))
        .andDo(print())
        .andExpect(status().is4xxClientError());
		
	}
	
	@Test
	void deleteOne() throws Exception{
		ProductOperationRequest ProductOperation = ProductOperationRequest.of(
				Name.of("Pizza"), 
				Description.of("Pizza con vegetales"), 
				BasePrice.of(new BigDecimal("1.50")), 
				TaxRate.of(new BigDecimal("0.60")), 
				ProductStatus.valueOf("Publicado"), 
				InventoryQuantity.of(5));
		//organizar
		
		when(service.deleteOne(anyLong())).thenReturn(ProductOperationSuccess.of(ProductOperation));
		
		//act
        MockHttpServletRequestBuilder servletRequestBuilder = MockMvcRequestBuilders.get("/api/v1/products/1");
        this.mockMvc.perform(servletRequestBuilder)
        .andDo(print())
        .andExpect(status().isOk());
		
	}
	
	@Test
	void deleteOneEmpty() throws Exception{
		
		when(service.deleteOne(anyLong()))
        .thenReturn(null);
		
		//act
		this.mockMvc.perform(put("/api/v1/products/1"))
        .andDo(print())
        .andExpect(status().is4xxClientError());
		
	}
}
