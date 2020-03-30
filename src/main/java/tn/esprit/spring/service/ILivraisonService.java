package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Livraison;

public interface ILivraisonService {
	public int ajouterLivraison(Livraison livraison);
	public void deleteLivraison(int id);
	public void mettreAjourLivraison (int id_livra,String etat_livra);
	public List<Livraison> retrieveAllLivraisons();
	public Livraison retriveLivraison(int id_livra);
}
