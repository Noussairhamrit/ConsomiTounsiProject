package tn.esprit.spring.controller;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.spring.entity.Livreur;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.repository.ReclamationRepository;
import tn.esprit.spring.service.IReclamationService;

@Scope(value = "session")
@Controller(value = "reclamationController")
@ELBeanName(value = "reclamationController")
public class JsfReclamation {
	@Autowired
	ReclamationRepository reclamationRepository;
	@Autowired
	IReclamationService iReclamationService;
	private int id_recl;

	public int getId_recl() {
		return id_recl;
	}

	public void setId_recl(int id_recl) {
		this.id_recl = id_recl;
	}

	public String getDescription_Recl() {
		return description_Recl;
	}

	public void setDescription_Recl(String description_Recl) {
		this.description_Recl = description_Recl;
	}

	private String description_Recl;

	public Reclamation ajouterReclamation(Reclamation reclamation) {
		iReclamationService.ajouterReclamation(reclamation);
		return reclamation;
	}

	public String addReclamation(){
		iReclamationService.ajouterReclamation(new Reclamation(description_Recl));
		return "null";
	}
}
