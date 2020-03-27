package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.entity.Factures;
import tn.esprit.spring.repository.CommandesRepository;
import tn.esprit.spring.repository.FactureRepository;
@Service
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
		f.setMontant(c.getPrixtotale());
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
	public List<Factures> getAllfactures_by_Payementstate_true() {
		String state="true";
		return factureRepository.getAllfactures_by_Payementstate_true(state);
	}
	@Override
	public List<Factures> getAllfactures_by_Payementstate_false() {
		String state="false";
		return factureRepository.getAllfactures_by_Payementstate_false(state);
	}

	@Override
	public List<Factures> getfactures_by_Datedepart(Date date_dep) {
		
		return null;
	}

	

	@Override
	public void modifier_type_facture(String type, int id_facture) {
	Factures f=	factureRepository.findById(id_facture).get();
	f.setType(type);
		factureRepository.save(f);
	}

	@Override
	public Optional<Factures> getfactures_by_ID(int id_facture) {
		return factureRepository.findById(id_facture);
	}

	@Override
	public List<Factures> getAllfactures_by_PayementType_En_ligne() {
	
		//En_ligne="En_ligne";
		return factureRepository.getAllfactures_by_PayementType_En_ligne();
				
	}

	@Override
	public List<Factures> getAllfactures_by_PayementType_Prote_A_Prote() {

		String type_payment="Prote_A_Prote";
		return factureRepository.getAllfactures_by_PayementType_Prote_A_Prote(type_payment);
	}

	@Override
	public String  get_payment_type_by_factureID(int id_facture) {
		
		 return factureRepository.get_payment_type_by_factureID(id_facture);
	}

	

}
