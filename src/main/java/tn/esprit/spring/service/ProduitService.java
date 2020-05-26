package tn.esprit.spring.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import tn.esprit.spring.entity.Produit;

public interface ProduitService {
	
	public int ajouterProduit(Produit produit);
	public Produit AjoutProduit(String ProduitJson, long scatId, List<MultipartFile> file) throws JsonMappingException, JsonProcessingException, IOException;
	public void deleteProduitById(int produitId);
	public List<Produit> getAllProduits();
	public String chercherNomProduitById(int produitId);
	public void mettreAjourQuantiteProduit(long quantite, int produitId);
	public void affecterProduitASCategorie(int produitId, long scatId);
	public void GerantAddProduit(long userId, int produitId);
	public int calculetNombreProduitJPQL();
	public Produit findOne(int id);
	public List<Produit> findProduitBySCategorie(long scatId);
	//public List<Produit> findProduitCategorie(long catId);
	public Iterable<Produit> findAll();
	public Produit updateProduct(Produit product,Long barCode);
	public Produit getOne(int id);
	public Long getProductBybarCode(int idprod);
	public boolean existsById(int id);

}
