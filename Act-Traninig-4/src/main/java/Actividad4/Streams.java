package Actividad4;






import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;


public class Streams {

	public Streams() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Pizza> pizzaList = Arrays.asList(
                new Pizza("Básica", Size.SMALL, 600),
                new Pizza("Familiar", Size.LARGE, 1800),
                new Pizza("Vegetariana", Size.LARGE, 860),
                new Pizza("Solo queso", Size.MEDIUM, 1000),
                new Pizza("Hawaiana", Size.SMALL, 1200),
                new Pizza("Extra carnes", Size.LARGE, 2100),
                new Pizza("Pollo", Size.SMALL, 900),
                new Pizza("Pollo + tocineta", Size.MEDIUM, 1500),
                new Pizza("Pollo + Jamon", Size.MEDIUM, 1300)
        );
		
		 /*
	     * 1. Obtener todas las pizzas de tamaño "MEDIUM"
	     */
		List<Pizza> resultTamaño = pizzaList.stream()
				.filter(pizza -> pizza.size==Size.MEDIUM)
				.collect(Collectors.toList());
		System.out.println("Pizzas con tamaño medio = " +resultTamaño);
		/*
	     * 2. Obtener todas las pizzas que las calorias esten entre 700 y 1500
	     */
		List<Pizza> resultCalorias = pizzaList.stream()
				.filter(pizza -> pizza.calories >= 700 && pizza.calories <= 1500)
				.collect(Collectors.toList());
		System.out.println("Pizzas entre 700 y 1500 Calorias = "+resultCalorias);
		/*
	     * 3. Obtener las 3 pizzas con más calorias
	     */
		List<Pizza> resultCaloriasMayor = pizzaList.stream()
				.sorted(Comparator.comparingInt(Pizza::getCalories)
				.reversed())
				.collect(Collectors.toList()).subList(0,3);
		System.out.println("3 pizzas con mas calorias = "+ resultCaloriasMayor);
		
	     /*
	     * 4. Obtener las 2 pizzas con menos calorias
	     */
		List<Pizza> resultCaloriasMenor = pizzaList.stream()
				.sorted(Comparator.comparingInt(Pizza::getCalories))
				.collect(Collectors.toList()).subList(0,2);
		System.out.println("2 Pizzas con menos calorias = "+resultCaloriasMenor);
	    /*
	     * 5. Del numeral 2 obtener las 2 pizzas con mas calorias
	     */
		List<Pizza> resultCaloriasPunto2 = pizzaList.stream()
				.filter(pizza -> pizza.calories >= 700 && pizza.calories <= 1500)
				.sorted(Comparator.comparingInt(Pizza::getCalories)
				.reversed())
				.collect(Collectors.toList()).subList(0,2);
		System.out.println("Pizzas entre 700 y 1500 Calorias y 2 pizzas con mas calorias =  "+resultCaloriasPunto2);
	    /*
	     * 5. Agrupar las pizzas por tamaño
	     */
		 Map<String, List<Pizza>> resultAgruparPizzaTamaño = pizzaList.stream()
				.collect(Collectors.groupingBy(pizza -> pizza.size.toString()));
		System.out.println("Pizzas agrupadas por tamaño =  "+resultAgruparPizzaTamaño);
		
	    /*
	     * 6. Agrupar las pizzas por los siguientes grupos: 
	     * de 0 a 1000 calorias
	     * de 1001 a 2000 calorias
	     * de 2001 a 3000 calorias
	     */
		List<Pizza> resultAgruparPizzaRangoCalorico1 = pizzaList.stream()
				.filter(pizza -> pizza.calories >= 0 && pizza.calories <= 1000)
				.collect(Collectors.toList());
		List<Pizza> resultAgruparPizzaRangoCalorico2 = pizzaList.stream()
				.filter(pizza -> pizza.calories >= 1001 && pizza.calories <= 2000)
				.collect(Collectors.toList());
		List<Pizza> resultAgruparPizzaRangoCalorico3 = pizzaList.stream()
				.filter(pizza -> pizza.calories >= 2001 && pizza.calories <= 3000)
				.collect(Collectors.toList());
		
		List pizzaListCalorias = Arrays.asList(
				resultAgruparPizzaRangoCalorico1,
				resultAgruparPizzaRangoCalorico2,
				resultAgruparPizzaRangoCalorico3
		);
		System.out.println("Pizzas Agrupadas por Calorias de mil en mil = "+pizzaListCalorias);
		}

	  public enum Size {
	      SMALL,
	      MEDIUM,
	      LARGE
	  }

	  public static class Pizza {
	      private final String name;
	      private final Size size;
	      private final Integer calories;

	      public Pizza(String name, Size size, Integer calories) {
	          this.name = name;
	          this.size = size;
	          this.calories = calories;
	      }

	      public Size getSize() {
	          return size;
	      }

	      public String getName() {
	          return name;
	      }

	      public Integer getCalories() {
	          return calories;
	      }

	      @Override
	      public String toString() {
	          return String.format("Pizza{%s, %s, %s}", name, size, calories);
	      }
	  }
	}


