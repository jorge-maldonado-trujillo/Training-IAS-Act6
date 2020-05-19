package Actividad4.Serialization;

import java.lang.reflect.Type;
import java.util.function.Function;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;

public class StringSerializableAdapter <T extends StringSerializable> implements GsonAdapter<T>{
	
	private final Function<String, T> factory;
	
	 public StringSerializableAdapter(Function<String, T> factory) {
	        this.factory = factory;
	    }

	@Override
	public JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext context) {
		String value = src.valueOf();
        return new JsonPrimitive(value);
	}

	@Override
	public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		String value = json.getAsString();
        return factory.apply(value);
	}

}
