package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Reclamation;

public interface IReclamationService {
	public Reclamation ajouterReclamation(Reclamation reclamation);
	public void deleteReclamation(int id_recl);
	public void mettreAjourReclamation(int id_recl,String description_Recl);
	public Reclamation retriveReclamation(int id_recl);
	public List<Reclamation> getAlllReclamations();
}
