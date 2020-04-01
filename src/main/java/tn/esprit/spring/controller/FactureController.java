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
	
	  // URL : http://localhost:8081/SpringMVC/servlet/getAllfactures_by_Commande/1
	   @GetMapping(value = "getAllfactures_by_Commande/{idcmd}")
	  
	   public  List<Factures> getAllfactures_by_Commande(@PathVariable("idcmd")int idcmd) {
			return factureservice.getAllfactures_by_Commande(idcmd);
		}
	   // URL : http://localhost:8081/SpringMVC/servlet/getfactures_by_ID/1
	   @GetMapping(value = "getfactures_by_ID/{idemp}")
	   
	   public Optional<Factures> getfactures_by_ID(@PathVariable("idemp")int id_facture) {
			return factureservice.getfactures_by_ID(id_facture);
		}
	// URL : http://localhost:8081/SpringMVC/servlet/affecterCommande_A_Facture
	   @PutMapping(value = "affecterCommande_A_Facture/{idf}/{idc}")
	  
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
	  
	   public List<Factures> getAllfactures(){
		   return factureservice.getAllfactures();
		   
	   }
	// URL : http://localhost:8081/SpringMVC/servlet/supprimerFacture
	   @DeleteMapping(value = "supprimerFacture/{id_facture}")
	   
		public void supprimerFacture(@PathVariable("id_facture")int id_facture){
		   factureservice.supprimerFacture(id_facture);
	   }
	// URL : http://localhost:8081/SpringMVC/servlet/getAllfactures_by_PayementType_En_ligne
	   @GetMapping(value = "getAllfactures_by_PayementType/{payementType}")
	   
		public List<Factures> getAllfactures_by_PayementType(@PathVariable("payementType")String payementType){
		   return factureservice.getAllfactures_by_PayementType(payementType);
		   
	   }
	
	// URL : http://localhost:8081/SpringMVC/servlet/getAllfactures_by_Payementstate
	   @GetMapping(value = "getAllfactures_by_Payementstate/{payementstate}")
	   
		public List<Factures> getAllfactures_by_Payementstate(@PathVariable("payementstate")String payementstate){
		   return factureservice.getAllfactures_by_Payementstate(payementstate);
			
		}
	
	// URL : http://localhost:8081/SpringMVC/servlet/get_payment_type_by_factureID

	   @GetMapping(value = "get_payment_type_by_factureID/{id}")
	  

	   public String  get_payment_type_by_factureID(@PathVariable("id")int id_facture) {
		 return  factureservice.get_payment_type_by_factureID(id_facture);
		   
	   }

}
