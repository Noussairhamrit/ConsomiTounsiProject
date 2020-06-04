package tn.esprit.spring.controller.Product;

import java.util.ArrayList;
import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;
import tn.esprit.spring.entity.Product.Categorie;
import tn.esprit.spring.entity.Product.SousCategories;
import tn.esprit.spring.service.Product.CategorieService;


@Controller(value = "SouscategorieController")
@ELBeanName(value = "SouscategorieController")
@Getter
@Setter
public class JSFSousCategorie {
	@Autowired
	CategorieService catservice;
	
	private Long id;
	private String Snom;
	private Categorie categorie;
	
	public List<String> getAllSsousCategorie(){
		List<String> nomSouscategorie=new ArrayList<>();
		for (SousCategories ssc:catservice.findAll()){
			nomSouscategorie.add(ssc.getSnom());
		}
		return nomSouscategorie;
		
	}

	public List<SousCategories> findAll() {
		return catservice.findAll();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSnom() {
		return Snom;
	}

	public void setSnom(String snom) {
		Snom = snom;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	

}
