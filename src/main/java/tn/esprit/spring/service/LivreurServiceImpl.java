package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Livreur;

import tn.esprit.spring.repository.LivreurRepository;
import javax.mail.MessagingException;


import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.MailException;

@Service
public class LivreurServiceImpl implements ILivreurService {
	
	@Autowired
	LivreurRepository livreurRepository;
	
	
	
	@Override
	public Long ajouterLivreur(Livreur livreur) {
		livreurRepository.save(livreur);
		return livreur.getUserId();
	}

	@Override
	public void deleteLivreur(Long userId) {
		livreurRepository.deleteById(userId);
	}

	@Override
	public void mettreAjourLivreurBydispo(Long userId, boolean dispo_liv) {
		Livreur livreur = livreurRepository.findById(userId).get();
		livreur.setDispo_liv(dispo_liv);

		livreurRepository.save(livreur);
	}

	@Override
	public void mettreAjourLivreurBycharge(Long userId, int chargeT_liv) {
		Livreur livreur = livreurRepository.findById(userId).get();

		livreur.setChargeT_liv(chargeT_liv);
		livreurRepository.save(livreur);
	}

	/*@Override
	public List<Livreur> retrieveAllLivreurs() {
		//Livreur liv = livreurRepository.findById(userId).get();
		if(livreurRepository.findById().get().isDispo_liv()==true){
			return (List<Livreur>) livreurRepository.findAll();
	}else 
		return null;
		}
		*/

	@Override
	public Livreur retriveLivreur(Long userId) {
		return livreurRepository.findById(userId).orElse(null);
		}
	//chercher les livreurs disponible
	@Override
	public List<Livreur> GetLivreurDispo() {
		return  livreurRepository.GetLivreurDispo() ;
		
		
		}
	
	@Override
	public List<Livreur> getAlllivreurs() {
		return livreurRepository.findAll() ;
	}
	
}