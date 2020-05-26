package tn.esprit.spring;

import org.junit.Test;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import tn.esprit.spring.entity.Categorie;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.SousCategories;
import tn.esprit.spring.service.CategorieService;
import tn.esprit.spring.service.ProduitService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsomiTounsiApplicationTests {
     
	@Autowired
	ProduitService pr;
	@Autowired
	CategorieService cat;

//@Test
	//public void contextLoads() {
		//Produit p= new Produit("bahr",1450L,"djou",60L,500L,6197894556L,1400L,1500, null);
	//	Produit t= new Produit("camera", 890L, "une bonne camera", 54L, 4L, 7894565230145L, 948L, 789, "img");
		//Categorie c= new Categorie("Pc", "un produit de kairouan");
		//SousCategories s=new SousCategories(2L, "sac", "rouge");
		//pr.ajouterProduit(p);
		//cat.addSousCat(s);
		//cat.affectSousCatToCat(1L, 1L);;
		//pr.affecterProduitASCategorie(1, 2L);
		//pr.ajouterProduit(p);


//}
}
