package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Livreur;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.repository.ReclamationRepository;

@Service
public class ReclamationServiceImpl implements IReclamationService {
	@Autowired
	ReclamationRepository reclamationRepository;
	
	public Reclamation ajouterReclamation(Reclamation reclamation) {
		return reclamationRepository.save(reclamation);
		
	}
	
	@Override
	public void deleteReclamation(int id_recl) {
		reclamationRepository.deleteById(id_recl);
	}
	
	@Override
	public void mettreAjourReclamation(int id_recl,String description_Recl) {
		Reclamation reclamation = reclamationRepository.findById(id_recl).get();
		reclamation.setDescrip(description_Recl);
		reclamationRepository.save(reclamation);
	}
	@Override
	public Reclamation retriveReclamation(int id_recl){
		return 	reclamationRepository.findById((id_recl)).orElse(null);
	}
	@Override
	public List<Reclamation> getAlllReclamations() {
		return reclamationRepository.findAll();
	}
}
