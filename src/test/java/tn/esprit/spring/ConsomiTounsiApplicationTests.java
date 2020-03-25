package tn.esprit.spring;



import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.service.ProduitService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsomiTounsiApplicationTests {
     
	@Autowired
	ProduitService pr;
	@Test
	public void contextLoads() {
		Produit p= new Produit("pc",1450L,"bonne etat",60L,500L,6197894556L,"img",1400L,1500L);
		p.setNom("pc");
		pr.ajouterProduit(p);
	}

}
