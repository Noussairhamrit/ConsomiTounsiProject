package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Factures;
import tn.esprit.spring.entity.Provider;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.service.IProviderSerivce;
import tn.esprit.spring.service.IStockSerivce;

@RestController
public class ProviderRestController {
	@Autowired
	IProviderSerivce iProviderService;
	
	// http://localhost:8081/SpringMVC/servlet/ajouterProvider
	@PostMapping("/ajouterProvider")
	@ResponseBody
	public Provider ajouterProvider(@RequestBody Provider provider) {
		iProviderService.ajouterProvider(provider);
		return provider;
	}
	
	
	// http://localhost:8081/SpringMVC/servlet/deleteProvider/{IDProvider}
	 @DeleteMapping("/deleteProvider/{IdProvider}") 
	 @ResponseBody
	public void deleteProvider(@PathVariable("IdProvider")int IdProvider){
		 iProviderService.deleteProvider(IdProvider);
	 }
	 

	 
	 
		// http://localhost:8081/SpringMVC/servlet/ShowProvider
	 @GetMapping(value = "ShowProvider") 
	  public List<Provider> ShowProvider(){
	return iProviderService.ShowProvider();
	 }

	 
	 

}
