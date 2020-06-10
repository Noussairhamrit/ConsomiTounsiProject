package tn.esprit.spring.controller.Product;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entity.Product.Produit;
import tn.esprit.spring.service.Product.ProduitService;

@Scope (value = "session")
@Component (value = "productList")
@ELBeanName(value = "productList")
@Join(path = "/", to = "/product-list.jsf")
public class ProductListController {

	private List<Produit> products;
	
	@Autowired
	ProduitService produitser;
	
	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		produitser.loadData();
		
	}

	

}
