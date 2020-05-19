package Actividad4.Product.Serialization;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Actividad4.Product.Domain.ProductId;
import Actividad4.Serialization.LongSerializableAdapter;

class LongSerializableTest {

	static Gson gson;

    @BeforeAll
    static void setUp() {
        gson = new GsonBuilder()
                .registerTypeAdapter(ProductId.class, new LongSerializableAdapter<>(ProductId::of))
                .create();
    }

    @Test
    void deserialize() {
    	
    }

	@Test
    void serialize() {
        // organizar
        Long ProductIdLong = 1L;
        ProductId productId = ProductId.of(ProductIdLong);
        //actuar
		String actual = String.format("\"%s\"",  gson.toJson(productId));
		
        //comprueban
		String expected = String.format("\"%s\"", productId.getValue());
        assertEquals(actual, expected);
    }

}
