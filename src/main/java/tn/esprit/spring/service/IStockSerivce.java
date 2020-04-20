package tn.esprit.spring.service;

import tn.esprit.spring.entity.Stock;

public interface IStockSerivce {
	
	public int ajouterStock(Stock stock);
	public void deleteStock(int IdStock);
	public void UpdateStock(int IdStock,String NameStock, String QuantityStock);
	
	

}
