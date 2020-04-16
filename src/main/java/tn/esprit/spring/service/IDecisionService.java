package tn.esprit.spring.service;

import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.spring.entity.Decision;

public interface IDecisionService {
	public int ajouterDecision(@RequestBody Decision decision) ;
	public void deleteDecision(int id_deci);
	public Decision retriveDecision(int id_deci);
	public void affecterDecisionAReclamation(int id_deci,int id_recl);
}
