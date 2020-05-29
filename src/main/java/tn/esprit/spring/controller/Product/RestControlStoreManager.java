package tn.esprit.spring.controller.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Product.StoreManger;
import tn.esprit.spring.service.Product.StoreManagerServiceImpl;

@RestController
public class RestControlStoreManager {

	@Autowired
	StoreManagerServiceImpl gerantser;
	
	
	 @GetMapping(value = "getGerant")
	public List<StoreManger> findOne(){
		return gerantser.findOne();
		}
	 
	 
	// {"userId":1,"userName":"djou","encrytedPassword":"djou123","nom":"jawher","prenom":"bahrouni","cin":11929603,"address":"haffouz","num_tel":51823592,"email":"jawher.bahrouni@esprit.tn"}
	 
	 @PostMapping(value="addGerant")
	  @ResponseBody
	 public StoreManger save(@RequestBody StoreManger u) {
			return gerantser.save(u);
		}
	
}
