package Actividad4.Product.Serialization;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Actividad4.Product.Domain.Description;
import Actividad4.Product.Domain.Name;
import Actividad4.Serialization.StringSerializableAdapter;

class StringSerializableTest {

	static Gson gson;

    @BeforeAll
    static void setUp() {
        gson = new GsonBuilder()
                .registerTypeAdapter(Name.class, new StringSerializableAdapter<>(Name::of))
                .registerTypeAdapter(Description.class, new StringSerializableAdapter<>(Description::of))
                .create();
    }

    @Test
    void deserializeName() {
    	
        
    }
    
    @Test
    void deserializeDescription() {
    	
        
      
    }

    @Test
    void serializeName() {
        // organizar
        String nameString = "Jorge";
        Name name = Name.of(nameString);

        //actuar
        String actual = gson.toJson(name);

        //comprueban
        String expected = String.format("\"%s\"", name.getValue());
        assertEquals(actual, expected);
        
       
    }
    
    @Test
    void serializeDescription() {
        
        
        // organizar
        String descriptionString = "Esto es una descripcion";
        Description description = Description.of(descriptionString);

        //actuar
        String actual = gson.toJson(description);

        //comprueban
        String expected = String.format("\"%s\"", description.getValue());
        assertEquals(actual, expected);
    }
}


