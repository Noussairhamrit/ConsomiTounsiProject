package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Livreur;

public interface ILivreurService {
	public Long ajouterLivreur(Livreur livreur);
	public void deleteLivreur(Long userId);
	public void mettreAjourLivreurBydispo(Long userId,boolean dispo_liv);
	public void mettreAjourLivreurBycharge(Long userId,int chargeT_liv);
	public List<Livreur> retrieveAllLivreurs();
	public Livreur retriveLivreur(Long userId);

}
