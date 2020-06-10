package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import tn.esprit.spring.entity.Product.Produit;



@Entity
@Table(name="Stock")

public class Stock implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "Id_Stock")
	private int IdStock;
	@Column(name = "Name_Stock")
	private String NameStock;
	@Column(name = "Quantity_Stock")
	private int QuantityStock;
	@Column(name = "Fournisseur")
	private String Fournisseur;
	@Column(name= "Entry_Date")
	private Date Entry_Date;
	
	@OneToMany(mappedBy="stock")
	private List<Produit> produit;
	
	@OneToMany(mappedBy="stockP")
	private List<Provider> provider;

	public int getIdStock() {
		return IdStock;
	}

	public void setIdStock(int idStock) {
		IdStock = idStock;
	}

	public String getNameStock() {
		return NameStock;
	}

	public void setNameStock(String nameStock) {
		NameStock = nameStock;
	}

	public int getQuantityStock() {
		return QuantityStock;
	}

	public void setQuantityStock(int quantityStock) {
		QuantityStock = quantityStock;
	}

	public List<Produit> getProduit() {
		return produit;
	}

	public void setProduit(List<Produit> produit) {
		this.produit = produit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFournisseur() {
		return Fournisseur;
	}

	public void setFournisseur(String fournisseur) {
		Fournisseur = fournisseur;
	}

	public Date getEntry_Date() {
		return Entry_Date;
	}

	public void setEntry_Date(Date entry_Date) {
		Entry_Date = entry_Date;
	}
	
	
	
	

}
