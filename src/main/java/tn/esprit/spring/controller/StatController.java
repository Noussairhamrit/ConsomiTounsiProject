package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.repository.LivreurRepository;
import tn.esprit.spring.service.LivreurServiceImpl;
import tn.esprit.spring.entity.Livreur;
import tn.esprit.spring.entity.Stat;

@Scope(value = "session")
@Controller(value = "StatController")
@ELBeanName(value = "StatController")
public class StatController {
	@Autowired
	LivreurRepository livreurRepository;
	@Autowired
	LivreurServiceImpl livreurService;


	private List<Stat> top10;
	

	public List<Stat> getTop10() {
		return top10;
	}

	public void setTop10(List<Stat> top10) {
		this.top10 = top10;
	}

	public void StatTop10liv(){
		top10= new ArrayList<>();
		List<Long> Liste10Liv = new ArrayList<>();
		Liste10Liv=livreurRepository.Top10nbLivreur();
		Livreur DeliveryM = new Livreur();
		for(Long i :Liste10Liv)
		{
			DeliveryM = livreurRepository.findById(i).get();
			top10.add(new Stat(DeliveryM.getChargeT_liv(),DeliveryM.getUserName()));
			
			System.out.println(DeliveryM.getChargeT_liv());
			System.out.println(DeliveryM.getUserName());
			
		}
}
}
