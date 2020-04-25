package tn.esprit.spring.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.service.ClientServiceIMP;

@RestController
public class ClientController {
	private Logger logger= LoggerFactory.getLogger(ClientController.class);
	@Autowired
	ClientServiceIMP client_service;
	
	
	  @GetMapping(value = "getclient")
	   
	  public List<Client> findOne() 
	  {
			return client_service.findOne();
		}
    
	  @PostMapping(value="ajouterclient")
	  @ResponseBody
	  public Client save(@RequestBody Client u){
		  client_service.save(u);
		  return u;
	  }
	  @GetMapping(value = "getclient_pt_100/{nbpt}")
	  public List<String> findClient_pt_100(@PathVariable ("nbpt")int nbpt){
		  return client_service.findClient_pt_100(nbpt);
	  }
	  @GetMapping(value = "cl/{nbpt}")
	  public Client client_gangant(@PathVariable ("nbpt")int nbpt) {
		  return client_service.client_gangant(nbpt);
	  }
	  @GetMapping(value = "Produit_par_cat1/{nom}")
	  public List <String> Produit_par_cat(@PathVariable("nom") String nom ){
		  return client_service.Produit_par_cat(nom);
		  
	  }
	  @GetMapping(value = "produit_gangant/{nbpt}")
	  public Produit produit_gangant(@PathVariable ("nbpt")int nbpt) throws MailException, MessagingException{
	
			return  client_service.produit_gangant(nbpt);
	
	  }
	  @RequestMapping("/sendmail")
	  public String sendmail(){
		  try{
		  client_service.sendmail();
		  }catch(MailException e){
			  logger.info("errorrrrrrrrr"+e.getMessage());
		  }
		  return "mail envoyer";
	  }
	  
}
