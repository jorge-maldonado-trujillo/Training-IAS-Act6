package Actividad4.Product.Controllers;


import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.google.gson.Gson;
import Actividad4.Product.Domain.BasePrice;
import Actividad4.Product.Domain.Description;
import Actividad4.Product.Domain.InventoryQuantity;
import Actividad4.Product.Domain.Name;
import Actividad4.Product.Domain.ProductOperationRequest;
import Actividad4.Product.Domain.ProductStatus;
import Actividad4.Product.Domain.TaxRate;


@SpringBootTest
@AutoConfigureMockMvc
class SystemTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private Gson gson;

	@Test
	void createProductTest() throws Exception {
		ProductOperationRequest productOperationRequest = ProductOperationRequest.of(
				Name.of("Pizza"), 
				Description.of("Pizza con vegetales"), 
				BasePrice.of(new BigDecimal("1.55")), 
				TaxRate.of(new BigDecimal("0.8")), 
				ProductStatus.valueOf("Publicado"), 
				InventoryQuantity.of(3));
		String jsonExpectedPost = "{\"name\":\"Pizza\",\"description\":\"Pizza con vegetales\",\"basePrice\":1.55,\"taxRate\":0.8,\"productStatus\":\"Publicado\",\"inventoryQuantity\":3}";
        String jsonProduct = this.gson.toJson(productOperationRequest);
        
       
		
		//act
        mockMvc.perform(post("/api/v1/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonProduct))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(jsonExpectedPost));
		
		
		String jsonExpectedGet = "{\"name\":\"Pizza\",\"description\":\"Pizza con vegetales\",\"basePrice\":1.55,\"taxRate\":0.8,\"productStatus\":\"Publicado\",\"inventoryQuantity\":3}";
		mockMvc.perform(get("/api/v1/products/1"))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.content().json(jsonExpectedGet));
	}
	
	@Test
	void createProductAllTest() throws Exception {
		
		ProductOperationRequest productOperationRequest = ProductOperationRequest.of(
				Name.of("Pizza"), 
				Description.of("Pizza con vegetales"), 
				BasePrice.of(new BigDecimal("1.55")), 
				TaxRate.of(new BigDecimal("0.8")), 
				ProductStatus.valueOf("Publicado"), 
				InventoryQuantity.of(3));
		String jsonExpectedPost = "{\"name\":\"Pizza\",\"description\":\"Pizza con vegetales\",\"basePrice\":1.55,\"taxRate\":0.8,\"productStatus\":\"Publicado\",\"inventoryQuantity\":3}";
        String jsonProduct = this.gson.toJson(productOperationRequest);
        
      //act
        mockMvc.perform(post("/api/v1/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonProduct))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(jsonExpectedPost));
        
        mockMvc.perform(get("/api/v1/products/"))
        .andExpect(status().isOk())
        .andExpect(mvcResult -> {
            MockHttpServletResponse servletResponse = mvcResult.getResponse();
            String responseList = servletResponse.getContentAsString();
            String[] stringSplit = responseList.split("},");
            String newProduct = jsonExpectedPost.replace("{", "").replace("}", "");
            List<String> stringResponses = new ArrayList<String>();
            stringResponses = Arrays.asList(stringSplit);
            List<String> listClean = stringResponses.stream()
                    .map(s -> s.replace("{", ""))
                    .map(s -> s.replace("[", ""))
                    .map(s -> s.replace("}]", ""))
                    .filter(s -> s.equals(newProduct))
                    .collect(Collectors.toList());
            assertNotEquals(listClean, "");
        });
		
	}
	
	@Test
	void deleteProductAllTest() throws Exception {
		
		ProductOperationRequest productOperationRequest = ProductOperationRequest.of(
				Name.of("Pizza"), 
				Description.of("Pizza con vegetales"), 
				BasePrice.of(new BigDecimal("1.55")), 
				TaxRate.of(new BigDecimal("0.8")), 
				ProductStatus.valueOf("Publicado"), 
				InventoryQuantity.of(3));
		String jsonExpectedPost = "{\"name\":\"Pizza\",\"description\":\"Pizza con vegetales\",\"basePrice\":1.55,\"taxRate\":0.8,\"productStatus\":\"Publicado\",\"inventoryQuantity\":3}";
        String jsonProduct = this.gson.toJson(productOperationRequest);
        
        //act
        mockMvc.perform(delete("/api/v1/products/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonProduct))
                .andExpect(status().isOk());
        
        mockMvc.perform(get("/api/v1/products/"))
        .andExpect(status().isOk())
        .andExpect(mvcResult -> {
            MockHttpServletResponse servletResponse = mvcResult.getResponse();
            String responseList = servletResponse.getContentAsString();
            String[] stringSplit = responseList.split("},");
            String newProduct = jsonExpectedPost.replace("{", "").replace("}", "");
            List<String> stringResponses = new ArrayList<String>();
            stringResponses = Arrays.asList(stringSplit);
            List<String> listClean = stringResponses.stream()
                    .map(s -> s.replace("{", ""))
                    .map(s -> s.replace("[", ""))
                    .map(s -> s.replace("}]", ""))
                    .filter(s -> s.equals(newProduct))
                    .collect(Collectors.toList());
            assertNotEquals(listClean, "");
        });
		
	}
	
	

}
