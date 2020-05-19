package Actividad4.Serialization;

import java.lang.reflect.Type;
import java.util.function.Function;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;

public class IntegerSerializableAdapter <T extends IntegerSerializable> implements GsonAdapter<T> {
	
	private final Function<Integer, T> factory;
	
	public IntegerSerializableAdapter(Function<Integer, T> factory) {
		this.factory = factory;
	}

	@Override
	public JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext context) {
		Integer value = src.valueOf();
		return new JsonPrimitive(value);
	}

	

	@Override
	public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		Integer value = json.getAsInt();
		return factory.apply(value);
	}

}
