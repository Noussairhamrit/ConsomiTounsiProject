package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.entity.Panier;

import tn.esprit.spring.entity.lignecommandeproduit;
import tn.esprit.spring.entity.Product.Produit;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.CommandesRepository;
import tn.esprit.spring.repository.PanierRepository;
import tn.esprit.spring.repository.Product.ProduitRepository;


@Service
public class PanierServiceIMP implements IPanierService {

	@Autowired
	PanierRepository panierRepository;
	@Autowired
	CommandesRepository commandesRepository;
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	ClientRepository clientRepository;

	public List<lignecommandeproduit> AjouterAuPanier(int idprod, long iduser, Panier lc) {
		List<lignecommandeproduit> List = panierRepository.panier_en_cour_ParIdclient(iduser);
		System.out.println("//////////////////////////////////////////////////////////" + List);
		Produit p = produitRepository.getOne(idprod);
		System.out.println("//////////////////////////////////////////////////////////" + p);
		Commandes c = commandesRepository.CommandeencoursparClient(iduser);
		System.out.println("//////////////////////////////////////////////////////////" + c);
		Panier l = panierRepository.findPanier(idprod, iduser);
		Client cl = clientRepository.getOne(iduser);

		if (List.isEmpty()) {
			float total = 0;
			Commandes c1 = new Commandes();
			c1.setClient(cl);

			c1.setDate_commande(new Date());
			c1.setStatus("en cours");
			c1.setPayment_type("en cours");
			// c1.setRemise("non");
			lc.setPrix(p.getPrix());
			c1.setPrixtotale(total);
			lc.setStatus("en cours");
			lc.setCommande(c1);
			lc.setProduit(p);
			System.out.println("//////////////////////////////////////////////////////////" + c1 + "//////" + p);
			panierRepository.save(lc);
			total = (float) (lc.getPrix() * lc.getQuantite());
			c1.setPrixtotale(total);
			commandesRepository.save(c1);
			remise( iduser);
		} else if ((c != null)) {

			if (l != null) {
				l.setQuantite(l.getQuantite() + lc.getQuantite());
				panierRepository.save(l);
			} else {
				lc.setCommande(c);
				lc.setPrix(p.getPrix());
				lc.setStatus("en cours");
				lc.setProduit(p);
				panierRepository.save(lc);
			}
			//Commandes c = commandesRepository.CommandeencoursparClient(iduser);
			Double a = PrixTotalCommande(iduser);
			//Client client = clientRepository.getOne(iduser);
			
			if (a >= 200 && a <= 499) {
				System.out.println("aaaaaaaa");
				c.setPrixtotale(a);
				c.setPoucentage("10 %");
				c.setPrix_after_remise(a - a * 0.1);
				commandesRepository.save(c);
				
			}
			else if (a >= 500 && a <= 999) {
				System.out.println("bbbbbbbba");
				c.setPrixtotale(a);
				c.setPoucentage("15 %");
				c.setPrix_after_remise(a - a * 0.15);
				commandesRepository.save(c);
			}
			else if (a > 1000) {
				c.setPrixtotale(a);
				c.setPoucentage("20 %");
				c.setPrix_after_remise(a - a * 0.2);
				System.out.println("dddddddd");
				commandesRepository.save(c);
			}
			else{
				System.out.println("cccccccc");
				c.setPrixtotale(a);
				c.setPoucentage("sans remise");
				c.setPrix_after_remise(a);
				commandesRepository.save(c);
			}
			

		}
		return panierRepository.panier_en_cour_ParIdclient(iduser);
	}

	public Double PrixTotalCommande(long iduser) {
		double sum = 0D;
		List<lignecommandeproduit> List = panierRepository.panier_en_cour_ParIdclient(iduser);
		for (lignecommandeproduit l : List) {
			sum += l.getTotal();
		}
		return sum;
	}
	public void remise(long iduser){
		Commandes c = commandesRepository.CommandeencoursparClient(iduser);
		Double a = PrixTotalCommande(iduser);
		Client client = clientRepository.getOne(iduser);
		
		if (a >= 200 && a <= 499) {
			c.setPrixtotale(a);
			c.setPoucentage("10 %");
			c.setPrix_after_remise(a - a * 0.1);
			commandesRepository.save(c);
			
		}
		else if (a >= 500 && a <= 999) {
			c.setPrixtotale(a);
			c.setPoucentage("15 %");
			c.setPrix_after_remise(a - a * 0.15);
			commandesRepository.save(c);
		}
		else if (a > 1000) {
			c.setPrixtotale(a);
			c.setPoucentage("20 %");
			c.setPrix_after_remise(a - a * 0.2);
			commandesRepository.save(c);
		}
		else{
			c.setPrixtotale(a);
			c.setPoucentage("sans remise");
			c.setPrix_after_remise(a);
			commandesRepository.save(c);
		}
		
	}

	public List<Panier> findPanier_by_id_client(long id_client) {
		return (List<Panier>) panierRepository.findPanier_by_id_client(id_client);
	}

	public Panier findPanier(int idProduit, Long idClient) {
		return panierRepository.findPanier(idProduit, idClient);
	}

	public Panier findPanier(int idProduit, Long idClient, int idCommande) {
		return panierRepository.findPanier(idProduit, idClient, idCommande);
	}

	public List<lignecommandeproduit> panierParIdclient(long id) {
		return panierRepository.panier_en_cour_ParIdclient(id);
	}
	public List<lignecommandeproduit> panierParIdclient_confirmer(long id) {
		return panierRepository.panier_confirmer_ParIdclient(id);
	}

	public Panier findOne(int id_panier) {
		return panierRepository.getOne(id_panier);
	}

	public List<Panier> findAll() {
		return panierRepository.findAll();
	}
	public List <Panier> findPanier_par_commande(int idCommande){
		return panierRepository.findPanier_par_commande(idCommande);
	}	 
	@Transactional
	public void supprimerpanier(int panierId,long iduser ){

	    panierRepository.deleteById(panierId);
	}
	@Transactional
	public void update_after_remove(int panierId,long iduser){

		 supprimerpanier(panierId,iduser);
		remise(iduser);
		 Commandes c = commandesRepository.CommandeencoursparClient(iduser);
		    if(c.getPrix_after_remise()<=0)
			{
				commandesRepository.delete(c);
			}
		
			 	
	   
		
	} 
	@Transactional
	 public void updateLigne(int  idL,int quantite,long iduser)
	 {
			Panier lc = panierRepository.getOne(idL);
			lc.setQuantite(quantite);
			panierRepository.save(lc);
			remise(iduser);
	 }
	@Transactional
	 public int numProduitPanier(Long iduser)
	 {
		return  panierRepository.numProduitPanier(iduser) ;
	 }

}
