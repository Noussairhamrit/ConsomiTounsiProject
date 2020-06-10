package tn.esprit.spring.controller.Ads;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Ads.Publicite;
import tn.esprit.spring.entity.Product.Produit;
import tn.esprit.spring.service.Ads.PubliciteSercice;

@RestController
public class RestControlPublicite {
	
	@Autowired
	PubliciteSercice publiciteser;
	
	// http://localhost:8081/ajouterPub
		//{"idPub":1,"name":"djou", "canal":630L, "dateStart""2020-03-01":, "dateEnd":"2020-03-03", "target":1L,"view":61947885L,"cost":30L,"image":"slm","vedio":"aala khir"}
	
	@PostMapping("/ajouterPub")
	@ResponseBody
	public Publicite ajouterPublicite(@RequestBody Publicite publicite) {
		publiciteser.ajouterPublicite(publicite);
		return publicite;
	}
	
	
	
	 // URL : http://localhost:8081/SpringMVC/servlet/deletePublicite/1
    @DeleteMapping("/deletePublicite/{idpub}") 
	@ResponseBody 
	public void deletePublicite(@PathVariable("idpub")int pubId) {
    	publiciteser.deletePublicite(pubId);
		
	}
    
    
 // URL : http://localhost:8081/SpringMVC/servlet/getAllPublicites
 		@GetMapping(value = "/getAllPublicites")
 	    @ResponseBody
 		public List<Publicite> getAllPublicites() {
 			
 			return publiciteser.getAllPublicites();
 		}
 		
 		

}
