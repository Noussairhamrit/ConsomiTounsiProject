package tn.esprit.spring.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.entity.Panier;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.CommandesRepository;
import tn.esprit.spring.repository.PanierRepository;
import tn.esprit.spring.repository.ProduitRepository;

@CrossOrigin("*")
@RestController
public class CommandeController {
	@Autowired
	private ProduitRepository produitrepository;
	@Autowired
	private CommandesRepository commandesrepository;
	@Autowired
	private ClientRepository clientrepository;
	@Autowired
	private PanierRepository panierrepository;
	// URL : http://localhost:8081/SpringMVC/servlet/commande
	 @PostMapping("/commande")
	    public Commandes saveCommandes(@RequestBody CommandeForm commandeForm){
		 
		 Client client=new Client(); 
		
	        client.setNom(commandeForm.getClient().getNom());
	        client.setEncrytedPassword(commandeForm.getClient().getEncrytedPassword());
	        client.setEmail(commandeForm.getClient().getEmail());
	        client.setAddress(commandeForm.getClient().getAddress());
	        client.setNum_tel(commandeForm.getClient().getNum_tel());
	        client.setUserName(commandeForm.getClient().getUserName());
	        client=clientrepository.save(client);
	        System.out.println(client.getUserId());
	        
	        Commandes commande=new Commandes();
	        double total=0;
	        for(CommandeProduct p:commandeForm.getProducts()){
	        	Panier panier=new Panier();
	        	panier.setCommande(commande);
	        	Produit produit=produitrepository.findById(p.getId()).get();
	        	panier.setProduit(produit);
	        	panier.setPrix(produit.getPrix());
	        	panier.setQuantite(p.getQuantity());
	        	panierrepository.save(panier);
	        	total+=p.getQuantity()*produit.getPrix();
	        }
	        
	        commande.setClient(client);
	        commande.setDate_commande(new Date());
	        commande.setPayment_state(false);
	        commande.setPayment_type(null);
	        commande=commandesrepository.save(commande);
	        commande.setPrixtotale(total);
	        return commandesrepository.save(commande);
		 
	 }
	
}
