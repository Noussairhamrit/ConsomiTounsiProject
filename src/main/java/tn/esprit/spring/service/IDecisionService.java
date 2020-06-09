package tn.esprit.spring.service;

import javax.mail.MessagingException;

import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.spring.entity.Decision;

public interface IDecisionService {
	public int ajouterDecision(@RequestBody Decision decision) ;
	public void deleteDecision(int id_deci);
	public Decision retriveDecision(int id_deci);
	public void affecterDecisionAReclamation(int id_deci,int id_recl);
	//public void affecterDecision1AReclamation(int id_deci,int id_recl)throws MailException, MessagingException;
}
