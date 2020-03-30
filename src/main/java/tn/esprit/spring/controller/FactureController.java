package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Factures;
import tn.esprit.spring.service.IFacturesService; 

@RestController
public class FactureController {
	@Autowired
	IFacturesService factureservice;
	
	
	
	// URL : http://localhost:8081/SpringMVC/servlet/ajouterFacture
	//{"id": 1,"montant": 223,"date_de_depart": "2021-03-03T00:00:00.000+0000","type": "bbbb","commande":1}
	@PostMapping("/ajouterFacture")
	@ResponseBody
	public Factures ajouteFacture(@RequestBody Factures facture)
	{
		factureservice.ajouterFacture(facture);
		return facture;	
		}
	
	  // URL : http://localhost:8081/SpringMVC/servlet/getfactures_by_ID/1
	   @GetMapping(value = "getfactures_by_ID/{idemp}")
	   @ResponseBody
	   public Optional<Factures> getfactures_by_ID(@PathVariable("idemp")int id_facture) {
			return factureservice.getfactures_by_ID(id_facture);
		}
	// URL : http://localhost:8081/SpringMVC/servlet/affecterCommande_A_Facture
	   @PostMapping(value = "affecterCommande_A_Facture/{idf}/{idc}")
	   @ResponseBody
		public void affecterCommande_A_Facture(@PathVariable("idf")int id_facture,@PathVariable("idc")int id_commande){
		   factureservice.affecterCommande_A_Facture(id_facture, id_commande);
	   }
	   
	// URL : http://localhost:8081/SpringMVC/servlet/modifier_type_facture
	   @PutMapping(value = "modifier_type_facture/{idf}/{type}")
	   @ResponseBody
		public void modifier_type_facture(@PathVariable("type")String type,@PathVariable("idf")int id_facture){
		   factureservice.modifier_type_facture(type, id_facture);
			 
		}
	// URL : http://localhost:8081/SpringMVC/servlet/getAllfactures
	   @GetMapping(value = "getAllfactures")
	   @ResponseBody
	   public List<Factures> getAllfactures(){
		   return factureservice.getAllfactures();
		   
	   }
	// URL : http://localhost:8081/SpringMVC/servlet/supprimerFacture
	   @DeleteMapping(value = "supprimerFacture")
	   @ResponseBody
		public void supprimerFacture(int id_facture){
		   factureservice.supprimerFacture(id_facture);
	   }
	// URL : http://localhost:8081/SpringMVC/servlet/getAllfactures_by_PayementType_En_ligne
	   @GetMapping(value = "getAllfactures_by_PayementType_En_ligne")
	   @ResponseBody
		public List<Factures> getAllfactures_by_PayementType_En_ligne(){
		   return factureservice.getAllfactures_by_PayementType_En_ligne();
		   
	   }
	// URL : http://localhost:8081/SpringMVC/servlet/getAllfactures_by_PayementType_Prote_A_Prote
	   @GetMapping(value = "getAllfactures_by_PayementType_Prote_A_Prote")
	   @ResponseBody
	   public List<Factures> getAllfactures_by_PayementType_Prote_A_Prote(){
		   return factureservice.getAllfactures_by_PayementType_Prote_A_Prote();
		   
	   }
	// URL : http://localhost:8081/SpringMVC/servlet/getAllfactures_by_Payementstate_true
	   @GetMapping(value = "getAllfactures_by_Payementstate_true")
	   @ResponseBody
		public List<Factures> getAllfactures_by_Payementstate_true(){
		   return factureservice.getAllfactures_by_Payementstate_true();
			
		}
	// URL : http://localhost:8081/SpringMVC/servlet/getAllfactures_by_Payementstate_false
	   @GetMapping(value = "getAllfactures_by_Payementstate_false")
	   @ResponseBody
		public List<Factures> getAllfactures_by_Payementstate_false(){
		   return factureservice.getAllfactures_by_Payementstate_false();
			
		}
	// URL : http://localhost:8081/SpringMVC/servlet/get_payment_type_by_factureID
	  @GetMapping(value = "get_payment_type_by_factureID/{id}")
	   @ResponseBody
	   public String  get_payment_type_by_factureID(@PathVariable("id")int id_facture) {
		 return  factureservice.get_payment_type_by_factureID(id_facture);
		   
	   }

}
