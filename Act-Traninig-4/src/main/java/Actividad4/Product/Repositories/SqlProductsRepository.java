package Actividad4.Product.Repositories;



import java.sql.PreparedStatement;
import java.util.List;
import java.sql.Statement;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import Actividad4.Product.Domain.BasePrice;
import Actividad4.Product.Domain.Description;
import Actividad4.Product.Domain.InventoryQuantity;
import Actividad4.Product.Domain.Name;
import Actividad4.Product.Domain.Product;
import Actividad4.Product.Domain.ProductId;
import Actividad4.Product.Domain.ProductOperation;
import Actividad4.Product.Domain.ProductOperationFailure;
import Actividad4.Product.Domain.ProductOperationRequest;
import Actividad4.Product.Domain.ProductOperationSuccess;
import Actividad4.Product.Domain.ProductStatus;
import Actividad4.Product.Domain.TaxRate;
import Actividad4.Product.Exceptions.ProductDoesNotExists;




@Repository
public class SqlProductsRepository implements ProductsRepository{
	
	 private final JdbcTemplate jdbcTemplate;


	    public SqlProductsRepository(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }
	    private final RowMapper<ProductOperationRequest> rowMapper = (resultSet, i) -> {
	        Name name =Name.of(resultSet.getString( "NOMBRE"));
	        Description description = Description.of(resultSet.getString( "DESCRIPCION"));
	        BasePrice basePrice = BasePrice.of(resultSet.getBigDecimal("PRECIOBASE"));
	        TaxRate taxRate = TaxRate.of(resultSet.getBigDecimal("TASAIMPUESTOS"));
	        ProductStatus productStatus = ProductStatus.valueOf(resultSet.getString("ESTADO"));
	        InventoryQuantity inventoryQuantity = InventoryQuantity.of(resultSet.getInt("CANTINVE"));
	        
	        return ProductOperationRequest.of(name, description, basePrice,taxRate,productStatus,inventoryQuantity);
	    };
	
	@Override
	public ProductOperation insertOne(ProductOperationRequest productOperationRequest) {
		
		String SQL = "INSERT INTO PRODUCTOS (NOMBRE,DESCRIPCION,PRECIOBASE,TASAIMPUESTOS,ESTADO,CANTINVE) VALUES (?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		 PreparedStatementCreator psc = connection -> {
	            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
	            ps.setString(1, productOperationRequest.getName().getValue());
	            ps.setString(2, productOperationRequest.getDescription().getValue());
	            ps.setBigDecimal(3,productOperationRequest.getBasePrice().getValue());
	            ps.setBigDecimal(4,productOperationRequest.getTaxRate().getValue());
	            ps.setString(5, productOperationRequest.getProductStatus().toString());
	            ps.setInt(6, productOperationRequest.getInventoryQuantity().getValue());
	            return ps;
	        };
	        jdbcTemplate.update(
	                psc,
	                keyHolder // --> {}, {1}
	        );
	      //  long key = keyHolder.getKey().longValue();
	         return ProductOperationSuccess.of(productOperationRequest);
	         
		
				
		
	}
	
	@Override
	public ProductOperation findById(Long id) {
		String SQL = "SELECT NOMBRE,DESCRIPCION,PRECIOBASE,TASAIMPUESTOS,ESTADO,CANTINVE FROM PRODUCTOS WHERE ID= ?";
		Object[] objects = {id};
		
		try {
			ProductOperationRequest productOperation = jdbcTemplate.queryForObject(SQL, objects, rowMapper);
            return ProductOperationSuccess.of(productOperation);
        } catch (EmptyResultDataAccessException e) {
            return ProductOperationFailure.of(ProductDoesNotExists.of(id));
        }
		
		
	}
	

	@Override
	public List<Product> findAll(){
		String SQL = "SELECT * FROM PRODUCTOS ";
		RowMapper<Product> rowMapper = (resultSet, i) -> {
			ProductId id = ProductId.of(resultSet.getLong("ID"));
	        Name name =Name.of(resultSet.getString( "NOMBRE"));
	        Description description = Description.of(resultSet.getString( "DESCRIPCION"));
	        BasePrice basePrice = BasePrice.of(resultSet.getBigDecimal("PRECIOBASE"));
	        TaxRate taxRate = TaxRate.of(resultSet.getBigDecimal("TASAIMPUESTOS"));
	        ProductStatus productStatus = ProductStatus.valueOf(resultSet.getString("ESTADO"));
	        InventoryQuantity inventoryQuantity = InventoryQuantity.of(resultSet.getInt("CANTINVE"));
	        
	        return Product.of(id,name, description, basePrice,taxRate,productStatus,inventoryQuantity);
	    };
		
	    List<Product> productsList = jdbcTemplate.query(SQL,rowMapper);
        return productsList;
		
	}
	
	@Override
	public ProductOperation updateOne(Long id, ProductOperationRequest productOperationRequest){
		String SQL = "UPDATE PRODUCTOS SET NOMBRE = ? , DESCRIPCION= ? , PRECIOBASE = ? , TASAIMPUESTOS =? , ESTADO = ? , CANTINVE = ?  WHERE ID = ? ";
		KeyHolder keyHolder = new GeneratedKeyHolder(); // inicializada {}
        PreparedStatementCreator psc = connection -> {
            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,productOperationRequest.getName().getValue());
            ps.setString(2,productOperationRequest.getDescription().getValue());
            ps.setBigDecimal(3,productOperationRequest.getBasePrice().getValue());
            ps.setBigDecimal(4, productOperationRequest.getTaxRate().getValue());
            ps.setString(5,productOperationRequest.getProductStatus().toString());
            ps.setInt(6,productOperationRequest.getInventoryQuantity().getValue());
            ps.setLong(7, id);
            return ps;
        };
        int Update = jdbcTemplate.update(
        		psc, 
        		keyHolder // --> {}, {1}
        		);
        if (Update == 1) {
            return ProductOperationSuccess.of(productOperationRequest);
        } else {
            return ProductOperationFailure.of(ProductDoesNotExists.of(id));
        }
		
	}
	
	@Override
    public ProductOperation deleteOne(Long id) {
		 ProductOperationRequest valor = findById(id).value();
	        String SQL = "DELETE FROM PRODUCTOS WHERE ID = ?";
	        KeyHolder keyHolder = new GeneratedKeyHolder(); // inicializada {}
	        PreparedStatementCreator psc = connection -> {
	            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
	            ps.setLong(1, id);
	            return ps;
	        };
	        int resp = jdbcTemplate.update(
	                psc,
	                keyHolder // --> {}, {1}
	        );

	        if (resp == 1) {
	            return ProductOperationSuccess.of(valor);
	        } else {
	            return ProductOperationFailure.of(ProductDoesNotExists.of(id));

	        }

    }

}
