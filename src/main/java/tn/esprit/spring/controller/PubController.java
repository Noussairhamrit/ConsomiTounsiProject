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

import tn.esprit.spring.entity.Pub;
import tn.esprit.spring.service.IPubService;

@RestController
public class PubController {
	@Autowired
	IPubService ipubservice ;
	
	
	@PostMapping("/addpub")
	@ResponseBody
	public Pub ajouterEmploye(@RequestBody Pub pub)
	{
		ipubservice.addPub(pub);
		return pub;
	}
	
	
	 @GetMapping("/retrieveallpubs") 
	 @ResponseBody
	 public List<Pub> getPubs()
	 { 
	 List<Pub> list = ipubservice.retrieveAllPub();
	return list; } 
	 
	    @DeleteMapping("/deletePubById/{idpub}") 
		@ResponseBody 
		public void deletePubById(@PathVariable("idpub")Long pubId)
		{
			ipubservice.deletePubById(pubId);
		} 
		
	    
	    @PutMapping(value = "/modifyRating/{id}/{newrate}") 
		@ResponseBody
		public void mettreAjourRatingByPubId(@PathVariable("newrate") Integer rating, @PathVariable("id") Long pubId) {
			ipubservice.mettreAjourRatingByPubId(rating, pubId);
			
		}
	    
	    // http://localhost:8081/SpringMVC/servlet/getPubById/1
	    @PutMapping(value = "getPubById/{idpub}")
	    @ResponseBody
		public Pub getPubById(@PathVariable("idpub") Long pubId) {
	    
			return ipubservice.getPubById(pubId);
		}

	    
		// URL : http://localhost:8081/SpringMVC/servlet/findAllMissionByEmployeJPQL/1
	    @GetMapping(value = "/topviews")
	    @ResponseBody
		public List<Pub> findAllMissionByEmployeJPQL() {

			return ipubservice.TopViewsJPQL();
		}
	    // URL : http://localhost:8081/SpringMVC/servlet/deleteBadJPQL
	    @DeleteMapping("/deletePubsWithNoInteractionJPQL") 
		@ResponseBody
		public void deleteBadJPQL() {
			ipubservice.deletePubsWithNoInteractionJPQL();		
		}
}
