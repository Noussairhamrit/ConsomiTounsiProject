package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.entity.Factures;

public interface IFacturesService {
	public int ajouterFacture(Factures facture);
	public void supprimerFacture(int id_facture);
	public void affecterCommande_A_Facture(int id_facture,int id_commande);
	public List<Factures> getAllfactures();
	public List<Factures> getfactures_by_ID(int id_facture);
	public List<Factures> getAllfactures_by_Commande(Commandes cmd);
	public List<Factures> getAllfactures_by_PayementType_En_ligne(String type_payment);
	public List<Factures> getAllfactures_by_PayementType_Prote_A_Prote(String type_payment);
	public List<Factures> getAllfactures_by_Payementstate_true(String satate);
	public List<Factures> getAllfactures_by_Payementstate_false(String satate);
	public List<Factures> getfactures_by_Datedepart(Date date_dep);
	public void modifier_type_facture(String type,int id_facture);
	
	

}
