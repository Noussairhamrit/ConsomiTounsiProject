package tn.esprit.spring.controller;

import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import tn.esprit.spring.entity.Livreur;
import tn.esprit.spring.repository.LivreurRepository;
import tn.esprit.spring.service.ILivreurService;

@Scope(value = "session")
@Controller(value = "livreurController")
@ELBeanName(value = "livreurController")
public class JsfLivreurController {
	@Autowired
	ILivreurService iLivreurService;
	@Autowired
	LivreurRepository livreurRepository;

	private Long userId;
	private String nom;
	private String prenom;
	private long cin;
	private String address;
	private long num_tel;
	private String email;
	private String encrytedPassword;
	private String userName;
	private String moy_trans_liv;
	private boolean dispo_liv;
	private int chargeT_liv;
	private int salaire_liv;
	private Livreur livreur;
	private Long livreurIdToBeUpdated;
	private List<Livreur> livreurs;
	public Long getLivreurIdToBeUpdated() {
		return livreurIdToBeUpdated;
	}

	public void setLivreurIdToBeUpdated(Long livreurIdToBeUpdated) {
		this.livreurIdToBeUpdated = livreurIdToBeUpdated;
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

	public int getChargeT_liv() {
		return chargeT_liv;
	}

	public void setChargeT_liv(int chargeT_liv) {
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
		iLivreurService.ajouterLivreur(new Livreur(prenom,nom,encrytedPassword,email ,cin,num_tel,address,moy_trans_liv, dispo_liv, salaire_liv, chargeT_liv));
		return "null";
	}

	public void deleteLivreur(Long userId) {
		iLivreurService.deleteLivreur(userId);
	}

	public void mettreAjourLivreurBydispo(boolean dispo_liv, Long userId) {
		iLivreurService.mettreAjourLivreurBydispo(userId, dispo_liv);
	}

	public void mettreAjourLivreurBycharge(Long userId, int chargeT_liv) {
		iLivreurService.mettreAjourLivreurBycharge(userId, chargeT_liv);
	}

	public Livreur retriveLivreur(Long userId) {
		return iLivreurService.retriveLivreur(userId);
	}

	public List<Livreur> getAlllivreurs() {
		livreurs = iLivreurService.getAlllivreurs();
		return livreurs;
	}
	/*public String displayLivreur(Livreur liv){
	
		this.setPrenom(liv.getPrenom());
		this.setNom(liv.getNom());
		this.setCin(liv.getCin());
		this.setEmail(liv.getEmail());
		this.setNum_tel(liv.getNum_tel());
		this.setAddress(liv.getAddress());
		this.setMoy_trans_liv(liv.getMoy_trans_liv());
		this.setSalaire_liv(liv.getSalaire_liv());
		this.setDispo_liv(liv.isDispo_liv());
		this.setChargeT_liv(liv.getChargeT_liv());
		this.setLivreurIdToBeUpdated(liv.getUserId());
		
		return "null";
	}*/

	public List<Livreur> getLivreurs() {
		return livreurs;
	}

	public void setLivreurs(List<Livreur> livreurs) {
		this.livreurs = livreurs;
	}
}
