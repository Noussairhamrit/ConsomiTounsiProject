package tn.esprit.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Categorie;
import tn.esprit.spring.entity.SousCategories;
import tn.esprit.spring.service.CategorieService;

@RestController
public class RestControlCategorie {
	
	@Autowired
	CategorieService catservice;
	
	
	// Ajouter Categorie : http://localhost:8081/SpringMVC/servlet/addCategorie
		//{"id":2,"nom":"Vetement","description":"nouveau collection"}

		@PostMapping("/addCategorie")
		@ResponseBody
	public long addCategorie(@RequestBody Categorie categorie) {
			catservice.addCategorie(categorie);
			return categorie.getIdCat();
	}
		
		
		// Ajouter SousCategorie : http://localhost:8081/SpringMVC/servlet/addSousCat
				//{"IdSousCat":6,"snom":"t_Shirt","sdescription":"Couleur noir"}

	    @PostMapping("/addSousCat")
	    @ResponseBody
		public long addSousCat(@RequestBody SousCategories souscategories) {
			catservice.addSousCat(souscategories);
			return souscategories.getIdSousCat();

		}
	    
	 // http://localhost:8081/SpringMVC/servlet/affectSousCatToCat/2/1
	    @PutMapping(value = "/affectSousCatToCat/{idscat}/{idcat}") 
	    public void affectSousCatToCat(@PathVariable("idscat")long scatId,@PathVariable("idcat") long catId) {
	    	catservice.affectSousCatToCat(scatId, catId);
			
		}
	    
	 // http://localhost:8081/SpringMVC/servlet/getAllSousCategoriesNamesByCategory/1
	    @GetMapping(value = "getAllSousCategoriesNamesByCategory/{idcat}")
	    @ResponseBody
	    public List<String> getAllSousCategoriesNamesByCategory(@PathVariable("idcat") long catId) {
	    	return catservice.getAllSousCategoriesNamesByCategory(catId);
	    }
	    
	    // URL : http://localhost:8081/SpringMVC/servlet/deleteCategorieste/3
	    @DeleteMapping("/deleteCategorie/{idcat}") 
		@ResponseBody
	    public void deleteCategorie(@PathVariable("idcat")long catId) {
	    	catservice.deleteCategorie(catId);
			
		}
	    
	 // URL : http://localhost:8081/SpringMVC/servlet/deleteSousCategorie/3
	    @DeleteMapping("/deleteSousCategorie/{idScat}") 
		@ResponseBody
		public void deleteSousCategorie(@PathVariable("idScat")long scatId) {
	    	catservice.deleteSousCategorie(scatId);
			
		}
	    
	    //http://localhost:8081/SpringMVC/servlet/chercherCategorie/1
	        @GetMapping(value = "chercherCategorie/{idcat}")
	        @ResponseBody
	    public Categorie chercherCategorie(@PathVariable("idcat")long catId) {
	    	return catservice.chercherCategorie(catId);
		}
	        //http://localhost:8081/SpringMVC/servlet/chercherSousCategorie/1
	        @GetMapping(value = "chercherSousCategorie/{idScat}")
	        @ResponseBody
	        public SousCategories chercherSousCategorie(@PathVariable("idScat")long scatId){
		    	return catservice.chercherSousCategorie(scatId);
			}
		


}
