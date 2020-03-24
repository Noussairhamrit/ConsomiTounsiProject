package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.List;



import tn.esprit.spring.entity.Client;

public class CommandeForm {
	private Client client=new Client();
	private List<CommandeProduct> products=new ArrayList<>();
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<CommandeProduct> getProducts() {
		return products;
	}
	public void setProducts(List<CommandeProduct> products) {
		this.products = products;
	}
	
	
	

}

class CommandeProduct{
    private int id;
    private int quantity;
    
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
    
    }
