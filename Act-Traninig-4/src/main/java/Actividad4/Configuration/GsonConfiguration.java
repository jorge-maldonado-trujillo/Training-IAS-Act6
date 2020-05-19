package Actividad4.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Actividad4.Product.Domain.BasePrice;
import Actividad4.Product.Domain.Description;
import Actividad4.Product.Domain.InventoryQuantity;
import Actividad4.Product.Domain.Name;
import Actividad4.Product.Domain.ProductId;
import Actividad4.Product.Domain.TaxRate;
import Actividad4.Serialization.BigDecimalSerializableAdapter;
import Actividad4.Serialization.IntegerSerializableAdapter;
import Actividad4.Serialization.LongSerializableAdapter;
import Actividad4.Serialization.StringSerializableAdapter;

@Configuration
public class GsonConfiguration {
	@Bean
	public Gson gson() {

		return new GsonBuilder()
				.registerTypeAdapter(ProductId.class, new LongSerializableAdapter<>(ProductId::of))
				.registerTypeAdapter(Name.class, new StringSerializableAdapter<>(Name::of))
				.registerTypeAdapter(Description.class, new StringSerializableAdapter<>(Description::of))
				.registerTypeAdapter(BasePrice.class, new BigDecimalSerializableAdapter<>(BasePrice::of))
				.registerTypeAdapter(TaxRate.class,new BigDecimalSerializableAdapter<>(TaxRate::of))
				.registerTypeAdapter(InventoryQuantity.class,new IntegerSerializableAdapter<>(InventoryQuantity::of))
				
				.create();
	
	}

}
