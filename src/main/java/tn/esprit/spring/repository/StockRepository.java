package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import tn.esprit.spring.entity.Stock;

public interface StockRepository extends CrudRepository<Stock , Integer> {
	
	@Query(value = "SELECT * FROM Stock WHERE quantity_stock=?1", nativeQuery = true)
    public List<Stock> ShowStockbyQuantity( int stockQuantity);
	
	@Query(value="SELECT * FROM Stock WHERE name_stock=?1", nativeQuery = true)
	public List<Stock> ShowStockbyName(String stockName );
	
	@Query(value="SELECT * FROM Stock WHERE Quantity_Stock =0", nativeQuery = true)
	public List<Stock> OutOfStockDetector();
	
	@Query(value= "SELECT COUNT(Entry_Date) FROM Stock")
	public List<Stock> SleepingStockDetector();

}
