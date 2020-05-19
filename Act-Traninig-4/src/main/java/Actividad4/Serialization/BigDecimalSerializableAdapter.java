package Actividad4.Serialization;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.function.Function;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;

public class BigDecimalSerializableAdapter <T extends BigDecimalSerializable> implements GsonAdapter<T> {
	private final Function<BigDecimal, T> factory;
	
	public BigDecimalSerializableAdapter(Function<BigDecimal, T> factory) {
		this.factory = factory;
	}

	@Override
	public JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext context) {
		BigDecimal value = src.valueOf();
		return new JsonPrimitive(value);
	}

	@Override
	public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		BigDecimal value = json.getAsBigDecimal();
		return factory.apply(value);
	}

}
