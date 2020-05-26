package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import tn.esprit.spring.repository.StoreManagerRepository;
import tn.esprit.spring.entity.StoreManger;


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
