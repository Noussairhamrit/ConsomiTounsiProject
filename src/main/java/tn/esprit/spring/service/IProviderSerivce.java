package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Provider;


public interface IProviderSerivce {
	
	public int ajouterProvider(Provider prov);
	public void deleteProvider(int IdProvider);
	public void UpdateProvider(int IdProvider,String pro_name,String Domain,String email, int gsm);
	public List<Provider> ShowProvider();
//	public List<Stock> ShowStock();
//	public List<Stock> ShowStockbyName(String NameStock);
//	public List<Stock> ShowStockbyQuantity(int QuantityStock);
//	public List<Stock> OutOfStockDetector();
//	public List<Stock> SleepingStockDetector();
	
	
	

}
