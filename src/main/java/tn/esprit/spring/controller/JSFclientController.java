package tn.esprit.spring.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Product.Produit;
import tn.esprit.spring.service.ClientServiceIMP;

@Scope(value = "session")
@Controller(value = "ClientController" )
@ELBeanName(value = "ClientController")
public class JSFclientController {
	@Autowired
	ClientServiceIMP ClientService;
	private Client client;
	private Long userId;
	private String userName;
	private String encrytedPassword;
	private String nom;
	private String prenom;
	private long cin;
	private String address;
	private long num_tel;
	private String email;
	private boolean enabled;
	private Integer ptmerci;
	
	
	
	public Client addClient(){
	return	ClientService.save(new Client( userName, encrytedPassword, nom, prenom, cin, address, num_tel, email));
	}
	 public Client getPassword(String email)throws MailException, MessagingException{
		  return ClientService.getPassword(email);
	  }
	 public List<Client> allClient(){
		 return ClientService.findOne();
	 }
	 public void actif(long id){
		 ClientService.actif(id);
			}
			public void block(long id){
				ClientService.block(id);
				}
			public Produit produit_gangant(Integer ptmerci) throws MailException, MessagingException {
				System.out.println("gooooooooooooooo   "+ptmerci);
				return ClientService.produit_gangant(ptmerci);
			}
	 
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEncrytedPassword() {
		return encrytedPassword;
	}
	public void setEncrytedPassword(String encrytedPassword) {
		this.encrytedPassword = encrytedPassword;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Integer getPtmerci() {
		return ptmerci;
	}
	public void setPtmerci(Integer ptmerci) {
		this.ptmerci = ptmerci;
	}
	
	
	
	 
}
