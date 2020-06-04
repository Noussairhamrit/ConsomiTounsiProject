package tn.esprit.spring.service;

import java.util.List;

import org.springframework.mail.MailException;

import tn.esprit.spring.entity.Etat_livra;
import tn.esprit.spring.entity.Livraison;

public interface ILivraisonService {
	public int ajouterLivraison(Livraison livraison);
	public void deleteLivraison(int id);
	public void mettreAjourLivraison (int id_livra,Etat_livra etat_livra,Long userId);
	public List<Livraison> retrieveAllLivraisons();
	public Livraison retriveLivraison(int id_livra);
	public void affecterLivraisonALivreur(int id_livra,Long userId);
	public List<Livraison> afficherleslivraison(Long userId);
	public void affecterCommandeALivraison(int id_livra,int id);
	public void Notificationlivreur() throws MailException;
}
