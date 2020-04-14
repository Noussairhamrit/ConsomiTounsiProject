package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.service.IReclamationService;

@RestController
public class ReclamationRestController {
	@Autowired
	IReclamationService iReclamationService;
	
	// http://localhost:8081/SpringMVC/servlet/ajouterReclamation
	@PostMapping("/ajouterReclamation")
	@ResponseBody
	public Reclamation ajouterReclamation(@RequestBody Reclamation reclamation) {
		iReclamationService.ajouterReclamation(reclamation);
		return reclamation;
		}
	
	// http://localhost:8081/SpringMVC/servlet/deleteReclamation/{id_recl}
		 @DeleteMapping("/deleteReclamation/{id_recl}") 
		 @ResponseBody
		public void deleteReclamation(@PathVariable("id_recl")int id_recl){
			 iReclamationService.deleteReclamation(id_recl);
		 }
		// http://localhost:8081/SpringMVC/servlet/mettreAjourReclamation/{id_livra}/{newlivraison}
		 @PutMapping("/mettreAjourReclamation/{id}/{newdesc}") 
		 @ResponseBody
		 public void mettreAjourReclamation(@PathVariable("newdesc") String description_Recl, @PathVariable("id") int id_recl){
			 iReclamationService.mettreAjourReclamation(id_recl, description_Recl);
		 }
		// http://localhost:8081/SpringMVC/servlet/retriveReclamation
		 @GetMapping("/retriveReclamation/{id_recl}")
		 @ResponseBody
		 public Reclamation retriveReclamation(@PathVariable("id_recl")int id_recl){
			 return iReclamationService.retriveReclamation(id_recl);
		 }
}
