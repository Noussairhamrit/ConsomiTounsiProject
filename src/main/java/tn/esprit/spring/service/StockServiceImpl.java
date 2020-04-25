package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.StockRepository;
@Service
public class StockServiceImpl implements IStockSerivce{
	@Autowired 
	StockRepository stockRepository;
	
	
	public int ajouterStock(Stock stock) {
		stockRepository.save(stock);
		return stock.getIdStock();
	}

	
	@Override
	public void deleteStock(int IdStock) {
		stockRepository.deleteById(IdStock);
	}
	
	@Override
	public void UpdateStock(int IdStock,String NameStock, int QuantityStock) {
		Stock stock = stockRepository.findById(IdStock).get();
		stock.setNameStock(NameStock);
		stock.setQuantityStock(QuantityStock);
		stockRepository.save(stock);
	}
	
	
	@Override
	public List<Stock> ShowStock() {
		return (List<Stock>)stockRepository.findAll();
	}
	
	@Override
	public List<Stock> ShowStockbyName(String NameStock){
		return (List<Stock>)stockRepository.ShowStockbyName(NameStock);
	}
	
	@Override
	public List<Stock> ShowStockbyQuantity(int QuantityStock){
		return (List<Stock>)stockRepository.ShowStockbyQuantity(QuantityStock);
	}
	
	@Override
	public List<Stock> OutOfStockDetector(){
		return(List<Stock>)stockRepository.OutOfStockDetector();
	}
	
	@Override
	public List<Stock> SleepingStockDetector(){
		return(List<Stock>)stockRepository.SleepingStockDetector();
	}
	

	

}
