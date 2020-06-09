package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tn.esprit.spring.entity.Livreur;
import tn.esprit.spring.repository.LivraisonRepository;
import tn.esprit.spring.repository.LivreurRepository;
import tn.esprit.spring.service.ILivreurService;
import tn.esprit.spring.service.LivraisonSerciceImpl;
import tn.esprit.spring.service.LivreurServiceImpl;


@Scope(value = "session")
@Controller(value = "livreurController")
@ELBeanName(value = "livreurController")
public class JsfLivreurController {
	@Autowired
	ILivreurService iLivreurService;
	@Autowired
	LivreurRepository livreurRepository;
	@Autowired
	LivraisonSerciceImpl LivraisonSercice;
	@Autowired
	LivreurServiceImpl LivreurSercice;


	private Long userId;
	private String nom;
	private String prenom;
	private int idc;
	private long cin;
	private String address;
	private long num_tel;
	private String email;
	private String encrytedPassword;
	private String userName;
	private String moy_trans_liv;
	private boolean dispo_liv;
	private Integer chargeT_liv;
	private int salaire_liv;
	private Livreur livreur;
	private Long livreurIdToBeUpdated;
	private List<Livreur> livreurs;
	private JavaMailSender javaMailSender;

	public Long getLivreurIdToBeUpdated() {
		return livreurIdToBeUpdated;
	}

	public void setLivreurIdToBeUpdated(Long livreurIdToBeUpdated) {
		this.livreurIdToBeUpdated = livreurIdToBeUpdated;
	}

	public List<Livreur> GetLivreurDispo() {
		return iLivreurService.GetLivreurDispo();
	}

	String a;

	private String getCountryFromJSF(FacesContext context) {
		Map<String, String> parameters = context.getExternalContext().getRequestParameterMap();
		return parameters.get("idc");
	}

	public int outcome() {
		FacesContext context = FacesContext.getCurrentInstance();
		a = getCountryFromJSF(context);
		System.out.println("(((((((((((((((((" + a);
		return Integer.parseInt(a);

	}

	public void affecterLivraisonALivreur(int idc, Long userId) {
		idc = outcome();
		LivraisonSercice.affecterLivraisonALivreur(idc, userId);
	}

	public int getIdc() {
		return idc;
	}

	public void setIdc(int idc) {
		this.idc = idc;
	}

	public Livreur getLivreur() {
		return livreur;
	}

	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEncrytedPassword() {
		return encrytedPassword;
	}

	public void setEncrytedPassword(String encrytedPassword) {
		this.encrytedPassword = encrytedPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMoy_trans_liv() {
		return moy_trans_liv;
	}

	public void setMoy_trans_liv(String moy_trans_liv) {
		this.moy_trans_liv = moy_trans_liv;
	}

	public boolean isDispo_liv() {
		return dispo_liv;
	}

	public void setDispo_liv(boolean dispo_liv) {
		this.dispo_liv = dispo_liv;
	}

	public Integer getChargeT_liv() {
		return chargeT_liv;
	}

	public void setChargeT_liv(Integer chargeT_liv) {
		this.chargeT_liv = chargeT_liv;
	}

	public int getSalaire_liv() {
		return salaire_liv;
	}

	public void setSalaire_liv(int salaire_liv) {
		this.salaire_liv = salaire_liv;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public long getCin() {
		return cin;
	}

	public void setCin(long cin) {
		this.cin = cin;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getNum_tel() {
		return num_tel;
	}

	public void setNum_tel(long num_tel) {
		this.num_tel = num_tel;
	}

	public String getEmail() {
		return email;
	}

	public Livreur getLiv() {
		return livreur;
	}

	public void setLiv(Livreur livreur) {
		this.livreur = livreur;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Livreur ajouterLivreur(Livreur livreur) {
		iLivreurService.ajouterLivreur(livreur);
		return livreur;

	}

	public String addlivreur() {
		iLivreurService.ajouterLivreur(new Livreur(prenom, nom, userName, encrytedPassword, email, cin, num_tel,
				address, moy_trans_liv, dispo_liv, salaire_liv, chargeT_liv));
		return "null";
	}

	public void deleteLivreur(Long userId) {
		iLivreurService.deleteLivreur(userId);
	}

	public void mettreAjourLivreurBydispo(boolean dispo_liv, Long userId) {
		iLivreurService.mettreAjourLivreurBydispo(userId, dispo_liv);
	}

	public void mettreAjourLivreurBycharge(Long userId, Integer chargeT_liv) {
		iLivreurService.mettreAjourLivreurBycharge(userId, chargeT_liv);
	}

	public Livreur retriveLivreur(Long userId) {
		return iLivreurService.retriveLivreur(userId);
	}

	public List<Livreur> getAlllivreurs() {
		livreurs = iLivreurService.getAlllivreurs();
		return livreurs;
	}
	

	public List<Livreur> getLivreurs() {
		return livreurs;
	}

	public void setLivreurs(List<Livreur> livreurs) {
		this.livreurs = livreurs;
	}

	@RequestMapping("/piechartdata")
	public ResponseEntity<?> getDataForPiechart() {
		List<Livreur> livreurs = livreurRepository.findAll();
		return new ResponseEntity<>(livreurs, HttpStatus.OK);
	}
	
	public void Prime() {
		LivreurSercice.Prime();
	}
	
	
	
	
	
//	@Scheduled(cron="*/10*****")
//	public void Prime() {
//		Livreur Delivery = new Livreur();
//		Long n;
//		
//		n = livreurRepository.BestLivreur();
//		Delivery = livreurRepository.findById(n).get();
//		
//		SimpleMailMessage mail = new SimpleMailMessage();
//		mail.setTo(Delivery.getEmail());
//		
//		mail.setFrom("consommi.toounsi.619@gmail.com");
//		mail.setSubject("Delivery");
//		mail.setText("You have a delivery to " );
//		
//		javaMailSender.send(mail);
//		
//		
//		List<Livreur> ListeLiv = new ArrayList<>();
//		ListeLiv=iLivreurService.getAlllivreurs();
//		for(Livreur i :ListeLiv){
//			i.setChargeT_liv(0);
//		}
//		
//
//	}
}
