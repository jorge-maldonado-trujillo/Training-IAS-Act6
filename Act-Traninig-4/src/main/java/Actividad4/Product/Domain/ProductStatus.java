package Actividad4.Product.Domain;

public enum ProductStatus {
	Borrador,
	Publicado;
	 ProductStatus() {
	    }

	    public static String fromHour (ProductStatus productStatus){
	        switch (productStatus){
	            case Borrador:
	                return "Borrador";
	            case Publicado:
	                return "Publicado";
	            default:
	                throw  new UnsupportedOperationException();
	        }
	    }
}
