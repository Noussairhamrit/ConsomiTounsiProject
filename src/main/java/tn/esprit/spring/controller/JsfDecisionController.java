package tn.esprit.spring.controller;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.mail.MessagingException;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Decision;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.TypeDecision;
import tn.esprit.spring.repository.DecisionRepository;
import tn.esprit.spring.repository.ReclamationRepository;
import tn.esprit.spring.service.DecisionServiceImpl;
import tn.esprit.spring.service.IDecisionService;

@Scope(value = "session")
@Controller(value = "DecisionController")
@ELBeanName(value = "DecisionController")
public class JsfDecisionController {
	@Autowired
	DecisionRepository decisionRepository;
	
	@Autowired
	ReclamationRepository reclamationRepository;
	
	@Autowired
	IDecisionService iDecisionService;
	@Autowired
	DecisionServiceImpl decisionServiceImpl;
	
	
	private int id_deci;
	
	private TypeDecision typedecision;

	public int getId_deci() {
		return id_deci;
	}

	public void setId_deci(int id_deci) {
		this.id_deci = id_deci;
	}

	public TypeDecision getTypedecision() {
		return typedecision;
	}

	public void setTypedecision(TypeDecision typedecision) {
		this.typedecision = typedecision;
	}
	
	public String addDecision() {
		iDecisionService.ajouterDecision(new Decision());
		return "null";
	}
	
	String a;

	private String getCountryFromJSF(FacesContext context) {
		Map<String, String> parameters = context.getExternalContext().getRequestParameterMap();
		return parameters.get("idD");
	}

	public int outcome() {
		FacesContext context = FacesContext.getCurrentInstance();
		a = getCountryFromJSF(context);
		System.out.println("((((((((((((((((("+a);
		return Integer.parseInt(a);

	}
	
	
	public void affecterDecision1AReclamation(int id_deci,int id_recl)throws MailException, MessagingException{
		
		decisionServiceImpl.affecterDecision1AReclamation(id_deci,id_recl);
		//System.out.println("yyyy");
	}
}
