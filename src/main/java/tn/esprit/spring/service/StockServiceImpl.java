package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.Livraison;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.StockRepository;

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
	
//	@Override
//	public void UpdateStock(int IdStock,String etat) {
//		Stock stock = stockRepository.findById(IdStock).get();
//		//stock.setEtat_livra(etat_livra);
//		stockRepository.save(stock);
//	}

	

}
