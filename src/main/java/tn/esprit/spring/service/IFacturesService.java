package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.entity.Factures;

public interface IFacturesService {
	public int ajouterFacture(Factures facture);
	public void supprimerFacture(int id_facture);
	public void affecterCommande_A_Facture(int id_facture,int id_commande);
	public List<Factures> getAllfactures();
	public Optional<Factures> getfactures_by_ID(int id_facture);
	public List<Factures> getAllfactures_by_Commande(int cmd);
	public List<Factures> getAllfactures_by_PayementType(String payementType);
	public List<Factures> getAllfactures_by_Payementstate(String payementstate);
	public List<Factures> getfactures_by_Datedepart(Date date_dep);
	public void modifier_type_facture(String type,int id_facture);
	public String  get_payment_type_by_factureID(int id_facture);	
	
	

}
