package tn.esprit.spring.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class lignecommandeproduit implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int idp;
	private String nomProduit;
	private int quantity;
	private long price;
	private long total;
private String name ;
	private LocalDate date;
	private float montant;

	public int getIdp() {
		return idp;
	}
	public void setIdp(int idp) {
		this.idp = idp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	

	public double getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public lignecommandeproduit(int quantity, long price) {
		super();
		this.quantity = quantity;
		this.price = price;
	
	}
	public lignecommandeproduit() {
	
	}
	public lignecommandeproduit( String nomProduit,int quantity, long price,long total) {
		super();
		this.nomProduit = nomProduit;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
		
		
	}
	
	public lignecommandeproduit(int id, String nomProduit,int quantity, long price,long total) {
		super();
		this.nomProduit = nomProduit;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
		this.id = id;
		
	}
	public lignecommandeproduit(int id,int idp, String nomProduit,int quantity, long price,long total) {
		super();
		this.nomProduit = nomProduit;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
		this.id = id;
		this.idp = idp;
		
	}


	
	

	public lignecommandeproduit(LocalDate date, float montant) {
		this.date = date;
		this.montant = montant;
	}
	public lignecommandeproduit( LocalDate date,String nomProduit,int quantity, long price,long total,String name) {
		super();
		this.date = date;
		this.nomProduit = nomProduit;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
		this.name=name;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	

}
