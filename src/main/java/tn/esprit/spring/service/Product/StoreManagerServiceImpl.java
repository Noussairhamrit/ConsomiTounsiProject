package tn.esprit.spring.service.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import tn.esprit.spring.entity.Product.StoreManger;
import tn.esprit.spring.repository.Product.StoreManagerRepository;


@Service
public class StoreManagerServiceImpl {
	
	@Autowired
	StoreManagerRepository gerantrep;
	
	
	public List<StoreManger> findOne(){
		return gerantrep.findAll();
		}
	
	public StoreManger save(StoreManger u) {
		return gerantrep.save(u);
	}

}
