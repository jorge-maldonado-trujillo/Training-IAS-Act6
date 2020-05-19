package Actividad4.Product.Serialization;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Actividad4.Product.Domain.InventoryQuantity;
import Actividad4.Serialization.IntegerSerializableAdapter;

class IntegerSerializableTest {

	static Gson gson;

    @BeforeAll
    static void setUp() {
        gson = new GsonBuilder()
                .registerTypeAdapter(InventoryQuantity.class,new IntegerSerializableAdapter<>(InventoryQuantity::of))
                .create();
    }

    @Test
    void deserialize() {
    }

    @Test
    void serialize() {
        // organizar
        Integer inventoryQuantityInteger = 1;
        InventoryQuantity inventoryQuantity = InventoryQuantity.of(inventoryQuantityInteger);

        //actuar
        String actual = String.format("\"%s\"", gson.toJson(inventoryQuantity));

        //comprueban
        String expected = String.format("\"%s\"", inventoryQuantity.getValue());
        assertEquals(actual, expected);
    }

}
