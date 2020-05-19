package Actividad4.common;

import java.util.EmptyStackException;
import java.util.Objects;

public class preconditions {
	
	public static void checkNotNull(Object reference) {
		if(Objects.isNull(reference)) {
			throw new NullPointerException();
		}
	}
	
	public static void checkArgument(boolean argument) {
		if(!argument) {
			throw new IllegalArgumentException();
		}
	}
	
	public static void checkArgumentVa(Object argument) {
		if(argument.toString().isEmpty()) {
			throw new EmptyStackException();
			//throw new IllegalArgumentException();
		}
	}

}
