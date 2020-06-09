package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Admin;
import tn.esprit.spring.entity.Livreur;
import tn.esprit.spring.repository.AdminRepository;
import tn.esprit.spring.repository.LivreurRepository;
import javax.mail.MessagingException;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.mail.MailException;

@Service
public class LivreurServiceImpl implements ILivreurService {
	
	@Autowired
	LivreurRepository livreurRepository;
	
	@Autowired
	AdminRepository adminrepository;
	
	private JavaMailSender javaMailSender;
	@Autowired
	public LivreurServiceImpl  (JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
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

	@Transactional
	public void mettreAjourLivreurBycharge(Long userId, Integer chargeT_liv) {
		Livreur livreur = livreurRepository.getOne(userId);
		System.out.println(livreur);
		livreur.setChargeT_liv(chargeT_liv);
		System.out.println(chargeT_liv);
		System.out.println(livreur);
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
	public Long liv(){
		return  livreurRepository.BestLivreur() ;
		
		
		}
	
	@Override
	public List<Livreur> getAlllivreurs() {
		return livreurRepository.findAll() ;
	}
	
	@Override
	public Livreur authenticate(String login, String password,Boolean enabled) {
		 enabled=true;
			return livreurRepository.getLivreurByUser_nameAndPassword(login, password,enabled);
		}
	

	
	//@Scheduled(cron="*/10*****")
	@Override
	public void Prime() {
		//Livreur Delivery = new Livreur();
		Long n;
		
		n = livreurRepository.BestLivreur();
		
		Livreur Delivery = livreurRepository.findById(n).get();
		
		
		List<Livreur> ListeLiv = new ArrayList<>();
		ListeLiv=livreurRepository.GetLivreur();
		for(Livreur i :ListeLiv){
			
		i.setChargeT_liv(0);
		livreurRepository.save(i);
		}
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(Delivery.getEmail());
		System.out.println("kkkkkkkkkk "+Delivery.getEmail());
		
		mail.setFrom("consommi.toounsi.619@gmail.com");
		mail.setSubject("prime");
		mail.setText("Congratulation you are the delivery man of the month you have recived 500Dt bonus" );
		
		javaMailSender.send(mail);
		
	}
		
		
	
	
}