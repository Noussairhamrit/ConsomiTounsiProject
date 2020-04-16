package tn.esprit.spring.service;

import tn.esprit.spring.entity.Reclamation;

public interface IReclamationService {
	public int ajouterReclamation(Reclamation reclamation);
	public void deleteReclamation(int id_recl);
	public void mettreAjourReclamation(int id_recl,String description_Recl);
	public Reclamation retriveReclamation(int id_recl);
}
