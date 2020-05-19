package Actividad4.Product.Serialization;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Actividad4.Product.Domain.BasePrice;
import Actividad4.Product.Domain.TaxRate;
import Actividad4.Serialization.BigDecimalSerializableAdapter;

class BigDecimalSerializableTest {

    static Gson gson;

    @BeforeAll
    static void setUp() {
        gson = new GsonBuilder()
        		.registerTypeAdapter(BasePrice.class, new BigDecimalSerializableAdapter<>(BasePrice::of))
				.registerTypeAdapter(TaxRate.class,new BigDecimalSerializableAdapter<>(TaxRate::of))
                .create();
    }

    @Test
    void deserialize() {
    }

    @Test
    void serializeBasePrice() {
        // organizar
        BigDecimal basePriceBigDecimal = new BigDecimal ("1.50");
        BasePrice basePrice = BasePrice.of(basePriceBigDecimal);

        //actuar
        String actual = String.format("\"%s\"",gson.toJson(basePrice));

        //comprueban
        String expected = String.format("\"%s\"", basePrice.getValue());
        assertEquals(actual, expected);
    }
    
    @Test
    void serializeTaxRate() {
        // organizar
        BigDecimal TaxRateBigDecimal = new BigDecimal ("0.50");
        TaxRate taxRate =TaxRate.of(TaxRateBigDecimal);

        //actuar
        String actual = String.format("\"%s\"",gson.toJson(taxRate));

        //comprueban
        String expected = String.format("\"%s\"", taxRate.getValue());
        assertEquals(actual, expected);
    }

}
