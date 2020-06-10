package tn.esprit.spring.controller.Product;

import java.util.ArrayList;
import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;
import tn.esprit.spring.repository.Product.CategorieRepository;
import tn.esprit.spring.entity.Livreur;
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
	@Autowired
	CategorieRepository CategorieRepository;
	
	private Long id;
	private String nomCategorie;
	private String descriptionCat;
	private String nomSCategorie;
	private String descriptionSousCat;
	private Categorie categorie;
	private SousCategories ssCategorie;
	private List <String> listNomScateg;
	
	
	public String addCat() {
		catservice.addCategorie(new Categorie(nomCategorie,descriptionCat));
		return "null";
	}
	
	
	public String addSCat() {
		catservice.addSousCat(new SousCategories(nomSCategorie,descriptionSousCat));
		return "null";
	}
	
	
	
	
	public List<String> getAllSCategorie(){
		List<String> nomSCategorie=new ArrayList<>();
		for (SousCategories ssc:catservice.findAll()){
			nomSCategorie.add(ssc.getSnom());
		}
		return nomSCategorie;
		
	}

	public List<SousCategories> getAllSCategories() {
		return catservice.findAll();
	}
	
	public List<Categorie> findAllCat() {
		return catservice.findAllCategorie();
	}
	
	public List<String> getAllCategorieName(){
		List<String> nomCategorie=new ArrayList<>();
		for (Categorie c:catservice.findAllCategorie()){
			nomCategorie.add(c.getNom());
		}
		return nomCategorie;
	}
	
	 public void onCountryChange() {
	        if(nomCategorie !=null && !nomCategorie.equals(""))
	        	listNomScateg = getAllSCategorieName();
	        else
	        	listNomScateg = new ArrayList<String>(); ;
	        	
	        
	    }
	
	 public List<String> getAllSCategorieName(){
			List<String> nomSCategorie=new ArrayList<>();
			Categorie categorie=CategorieRepository.findCategorieByName(nomCategorie);	
				for (SousCategories sc:catservice.findSCategorieByCategorie(categorie.getIdCat())){
				nomSCategorie.add(sc.getSnom());
			}
			return nomSCategorie;
		}
	
	public List<String> getListNomScateg() {
		return listNomScateg;
	}

	public void setListNomScateg(List<String> listNomScateg) {
		this.listNomScateg = listNomScateg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public CategorieService getCatservice() {
		return catservice;
	}

	public void setCatservice(CategorieService catservice) {
		this.catservice = catservice;
	}

	
	public String getNomSCategorie() {
		return nomSCategorie;
	}

	public void setNomSCategorie(String nomSCategorie) {
		this.nomSCategorie = nomSCategorie;
	}

	public SousCategories getSsCategorie() {
		return ssCategorie;
	}

	public void setSsCategorie(SousCategories ssCategorie) {
		this.ssCategorie = ssCategorie;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}




	public CategorieRepository getCategorieRepository() {
		return CategorieRepository;
	}




	public void setCategorieRepository(CategorieRepository categorieRepository) {
		CategorieRepository = categorieRepository;
	}




	public String getDescriptionCat() {
		return descriptionCat;
	}




	public void setDescriptionCat(String descriptionCat) {
		this.descriptionCat = descriptionCat;
	}


	public String getDescriptionSousCat() {
		return descriptionSousCat;
	}


	public void setDescriptionSousCat(String descriptionSousCat) {
		this.descriptionSousCat = descriptionSousCat;
	}
	
	

}
