package tn.esprit.spring.service;

import java.util.List;

import org.springframework.mail.MailException;

import tn.esprit.spring.entity.Admin;
import tn.esprit.spring.entity.Livreur;

public interface ILivreurService {
	public Long ajouterLivreur(Livreur livreur);
	public void deleteLivreur(Long userId);
	public void mettreAjourLivreurBydispo(Long userId,boolean dispo_liv);
	public void mettreAjourLivreurBycharge(Long userId,Integer chargeT_liv);
	//public List<Livreur> retrieveAllLivreurs();
	public Livreur retriveLivreur(Long userId);
	public List<Livreur> GetLivreurDispo();
	public List<Livreur> getAlllivreurs();
	public Livreur authenticate(String login, String password,Boolean enabled);
	public Long liv();
	public void Prime();
	
	
}
