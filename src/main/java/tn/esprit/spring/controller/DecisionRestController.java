package tn.esprit.spring.controller;

import javax.mail.MessagingException;

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

import tn.esprit.spring.entity.Decision;
import tn.esprit.spring.service.IDecisionService;

@RestController
public class DecisionRestController {
	@Autowired
	IDecisionService iDecisionService;
	
	// http://localhost:8081/SpringMVC/servlet/ajouterDecision
		@PostMapping("/ajouterDecision")
		@ResponseBody
		public Decision ajouterDecision(@RequestBody Decision decision) {
			iDecisionService.ajouterDecision(decision);
			return decision;
			}
		// http://localhost:8081/SpringMVC/servlet/affecterDecisionAReclamation
//		   @PostMapping("/affecterDecisionA1Reclamation/{id_deci}/{id_recl}") 
//		   @ResponseBody
//			public void  affecterDecision1AReclamation(@PathVariable("id_deci")int id_deci, @PathVariable("id_recl")int id_recl)throws MailException, MessagingException
//			{
//			   iDecisionService.affecterDecision1AReclamation(id_deci, id_recl);
//			}
		  // public void affecterDecision1AReclamation(int id_deci,int id_recl)throws MailException, MessagingException{
		   
		// http://localhost:8081/SpringMVC/servlet/deleteDecision/{id_deci}
			 @DeleteMapping("/deleteDecision/{id_deci}") 
			 @ResponseBody
			public void deleteDecision(@PathVariable("id_deci")int id_deci){
				 iDecisionService.deleteDecision(id_deci);
			 }
			// http://localhost:8081/SpringMVC/servlet/retriveDecision
			 @GetMapping("/retriveDecision/{id_deci}")
			 @ResponseBody
			 public Decision retriveDecision(@PathVariable("id_deci")int id_deci){
				 return iDecisionService.retriveDecision(id_deci);
			 }
}
