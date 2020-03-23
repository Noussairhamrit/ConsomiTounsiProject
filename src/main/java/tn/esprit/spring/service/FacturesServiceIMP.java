package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.entity.Factures;
import tn.esprit.spring.repository.CommandesRepository;
import tn.esprit.spring.repository.FactureRepository;

public class FacturesServiceIMP implements IFacturesService{
	@Autowired
	FactureRepository factureRepository; 
	@Autowired
	CommandesRepository commandesRepository;

	@Override
	public int ajouterFacture(Factures facture) {
		factureRepository.save(facture);
		return facture.getId();
	}

	@Override
	public void supprimerFacture(int id_facture) {
		factureRepository.deleteById(id_facture);
		
	}

	@Override
	public void affecterCommande_A_Facture(int id_facture, int id_commande) {
		Factures f =factureRepository.findById( id_facture).get();
		Commandes c =commandesRepository.findById(id_commande).get();
		f.setCommande(c);
		factureRepository.save(f);
		
	}

	@Override
	public List<Factures> getAllfactures() {
		return (List<Factures>)factureRepository.findAll();
	}

	@Override
	public List<Factures> getAllfactures_by_Commande(Commandes cmd) {
		return factureRepository.getAllfactures_by_Commande(cmd);
	}

	@Override
	public List<Factures> getAllfactures_by_PayementType_En_ligne(String type_payment) {
		String  En_ligne="En_ligne";
		type_payment=En_ligne;
		return factureRepository.getAllfactures_by_PayementType_En_ligne(type_payment);
	}
	@Override
	public List<Factures> getAllfactures_by_PayementType_Prote_A_Prote(String type_payment) {
		String  Prote_A_Prote="Prote_A_Prote";
		type_payment=Prote_A_Prote;
		return factureRepository.getAllfactures_by_PayementType_Prote_A_Prote(type_payment);
	}

	@Override
	public List<Factures> getAllfactures_by_Payementstate_true(String state) {
		state="true";
		return factureRepository.getAllfactures_by_Payementstate_true(state);
	}
	@Override
	public List<Factures> getAllfactures_by_Payementstate_false(String state) {
		state="false";
		return factureRepository.getAllfactures_by_Payementstate_false(state);
	}

	@Override
	public List<Factures> getfactures_by_Datedepart(Date date_dep) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Factures> getfactures_by_ID(int id_facture) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifier_type_facture(String type, int id_facture) {
		// TODO Auto-generated method stub
		
	}

	

}
