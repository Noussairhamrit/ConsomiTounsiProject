package tn.esprit.spring.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Etat_livra;
import tn.esprit.spring.entity.Livraison;
import tn.esprit.spring.service.DecisionServiceImpl;
import tn.esprit.spring.service.ILivraisonService;

@RestController
public class LivraisonRestController {
	private Logger logger= LoggerFactory.getLogger(LivraisonRestController.class);
	@Autowired
	ILivraisonService iLivraisonService;
	@Autowired
	DecisionServiceImpl decisionServiceImpl;

	// http://localhost:8081/SpringMVC/servlet/ajouterLivraison
	@PostMapping("/ajouterLivraison")
	@ResponseBody
	public Livraison ajouterLivraison(@RequestBody Livraison livraison) {
		iLivraisonService.ajouterLivraison(livraison);
		return livraison;

	}
	// http://localhost:8081/SpringMVC/servlet/deleteLivraison/{id_livra}
	 @DeleteMapping("/deleteLivraison/{id_livra}") 
	 @ResponseBody
	public void deleteLivraison(@PathVariable("id_livra")int id_livra){
		 iLivraisonService.deleteLivraison(id_livra);
	 }
	// http://localhost:8081/SpringMVC/servlet/mettreAjourLivraison/{id}/{idL}/{newetat}
	 @PutMapping("/mettreAjourLivraison/{id}/{idL}/{newetat}") 
	 @ResponseBody
	 public String mettreAjourLivraison(@PathVariable("newetat") Etat_livra etat_livra, @PathVariable("id") int id_livra,@PathVariable("idL")Long userId){
		 iLivraisonService.mettreAjourLivraison(id_livra, etat_livra,userId);
		 return "updated";
	 }
	// http://localhost:8081/SpringMVC/servlet/retriveLivraison
	 @GetMapping("/retriveLivraison/{id_livra}")
	 @ResponseBody
	 public Livraison retriveLivraison(@PathVariable("id_livra")int id_livra){
		 return iLivraisonService.retriveLivraison(id_livra);
	 }
	 
	// http://localhost:8081/SpringMVC/servlet/affecterLivraisonALivreur
	   @PutMapping("/affecterLivraisonALivreur/{id_livra}/{userId}") 
	   @ResponseBody
		public String  affecterLivraisonALivreur(@PathVariable("id_livra")int id_livra, @PathVariable("userId")Long userId)
		{
		   
		   iLivraisonService.affecterLivraisonALivreur(id_livra,userId);
		
	   try{
		   iLivraisonService.Notificationlivreur();
		  }catch(MailException e){
			  logger.info("Error sending "+e.getMessage());
		  }
		  return "email envoyer";
		}

		// http://localhost:8081/SpringMVC/servlet/afficherleslivraison/{userId}
		@GetMapping("/afficherleslivraison/{userId}")
		@ResponseBody
		public List<Livraison> afficherleslivraison(@PathVariable("userId") Long userId) {
		    return iLivraisonService.afficherleslivraison(userId);
		}
		// http://localhost:8081/SpringMVC/servlet/affecterDecision1AReclamation/{id_deci}/{id_recl}
		 @PutMapping("/affecterDecision1AReclamation/{id_deci}/{id_recl}") 
		   @ResponseBody
		   public void affecterDecision1AReclamation(@PathVariable("id_deci") int id_deci,@PathVariable("id_recl") int id_recl)throws MailException, MessagingException{
			 decisionServiceImpl.affecterDecision1AReclamation(id_deci, id_recl);
		 }
		
}
