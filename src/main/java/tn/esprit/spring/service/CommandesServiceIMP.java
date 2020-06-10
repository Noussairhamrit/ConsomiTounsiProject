package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.entity.Etat_livra;
import tn.esprit.spring.entity.Eventcommande;
import tn.esprit.spring.entity.Factures;
import tn.esprit.spring.entity.Livraison;
import tn.esprit.spring.entity.Panier;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.CommandesRepository;
import tn.esprit.spring.repository.PanierRepository;

@Service
public class CommandesServiceIMP implements ICommandesService {
	@Autowired
	CommandesRepository commandesrepository;
	@Autowired
	ClientRepository clientrepository;
	@Autowired
	PanierRepository panierrepository;
	@Autowired
	FacturesServiceIMP factureservice;
	@Autowired
	LivraisonSerciceImpl LivraisonSercice;
	

	@Override
	public Commandes ajoutercommande(Commandes commande) {
		commande.setDate_commande(new Date());
		return commandesrepository.save(commande);
		 
	}

	@Override
	public void supprimercommande(int commande_id) {
		commandesrepository.deleteById(commande_id);

	}

	@Override
	public Optional<Commandes> getCommande_by_id(int commande_id) {

		return commandesrepository.findById(commande_id);
	}

	@Override
	public List<Commandes> get_all_commandes() {

		return (List<Commandes>) commandesrepository.findAll();
	}

	@Override
	public List<Commandes> CommandeparClient(int id_client) {
		return commandesrepository.CommandeparClient(id_client);
	}

	@Override
	public List<Commandes> Commandeparcode(long code) {

		return commandesrepository.Commandeparcode(code);
	}

	@Override
	public void PayerEnLigne(int idCommande) {
		commandesrepository.PayerEnLigne(idCommande);

	}

	@Override
	public void PayerPorteaPorte(int idCommande) {
		commandesrepository.PayerPorteaPorte(idCommande);
	}

	@Override
	public List<Commandes> CommandeparType(String type) {
		return commandesrepository.CommandeparType(type);
	}

	@Override
	public List<Commandes> CommandeparStatus(String status) {
		return commandesrepository.Commandeparstatus(status);
	}

	@Override
	public List<Commandes> Commandepar_PaymentState(String PaymentState) {
		
		return commandesrepository.Commandepar_PaymentState(PaymentState);
	}

	@Override
	public Commandes findOne(int id) {
		return commandesrepository.getOne(id);
		 
	}
	public Factures confirmer_commande(int idCommande,long iduser) {
		List<Panier> p =panierrepository.findPanier_par_commande(idCommande);
		Commandes c=commandesrepository.getOne(idCommande);
		Client client = clientrepository.getOne(iduser);
		c.setStatus("Comfirmer");
		double a=c.getPrixtotale();
		long pt = client.getNum_carte_fidelity();
		long r = Math.round(a / 10);
		client.setNum_carte_fidelity(pt + r);
		clientrepository.save(client);
		commandesrepository.save(c);
		for(Panier pp :p){
		pp.setStatus("vendu");
		panierrepository.save(pp)	;	
		}
		Factures facture=new Factures();
		facture.setDate_de_depart(new Date());
		int id_facture=factureservice.ajouterFacture(facture);
		factureservice.affecterCommande_A_Facture(id_facture, idCommande);
		Livraison livraison=new Livraison(); 
		livraison.setDest_livra(client.getAddress());
		livraison.setEtat_livra(Etat_livra.en_cours);
		livraison.setFrais_livra(10);
		livraison.setCommandes(c);
		LivraisonSercice.ajouterLivraison(livraison);
		return facture;
		
	}
	public Commandes commande_en_cour_Idclient(long idclient){
		return commandesrepository.CommandeencoursparClient(idclient);
	}
	public long pt_merci(int idCommande){
	
		Commandes c=commandesrepository.getOne(idCommande);
		
		
		double a=c.getPrixtotale();

		long r = Math.round(a / 10);
		return r;
	}
	public List<Eventcommande> NumCommadeParMOIS2(){
		return commandesrepository.NumCommadeParMOIS2();
	}

}