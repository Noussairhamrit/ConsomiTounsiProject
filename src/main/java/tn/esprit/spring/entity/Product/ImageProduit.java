package tn.esprit.spring.entity.Product;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties
public class ImageProduit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String Image;
	
	@JsonIgnore
	@ManyToOne
	private Produit Idproduit;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public Produit getIdproduit() {
		return Idproduit;
	}

	public void setIdproduit(Produit idproduit) {
		Idproduit = idproduit;
	}

	public ImageProduit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImageProduit(Long id, String image, Produit idproduit) {
		super();
		Id = id;
		Image = image;
		Idproduit = idproduit;
	}

	public ImageProduit(String image) {
		super();
		Image = image;
	}
	
	
	
	

}
