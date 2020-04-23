package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Decision;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.repository.DecisionRepository;
import tn.esprit.spring.repository.ReclamationRepository;

@Service
public class DecisionServiceImpl implements IDecisionService {
	@Autowired
	DecisionRepository decisionRepository;
	@Autowired
	ReclamationRepository reclamationRepository ;
	
	public int ajouterDecision(Decision decision) {
		decisionRepository.save(decision);
		
		return decision.getId_deci();
	}

	@Override
	public void deleteDecision(int id_deci) {
		decisionRepository.deleteById(id_deci);
	}
	
	@Override
	public Decision retriveDecision(int id_deci){
		return decisionRepository.findById(id_deci).orElse(null);
	}
	
	@Override
	public void affecterDecisionAReclamation(int id_deci,int id_recl){
		Reclamation reclamationManagedEntity = reclamationRepository.findById(id_recl).get();
		Decision decisionManagedEntity = decisionRepository.findById(id_deci).get();
		
		decisionManagedEntity.setReclamation(reclamationManagedEntity);
		decisionRepository.save(decisionManagedEntity);
		
	}
}
