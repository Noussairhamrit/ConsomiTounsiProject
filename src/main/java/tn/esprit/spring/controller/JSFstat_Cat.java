package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import tn.esprit.spring.entity.*;
import tn.esprit.spring.service.ClientServiceIMP;

@Scope(value = "session")
@Controller(value = "Statistique")
@ELBeanName(value = "Statistique")
@Join(path = "/stat", to = "/template/templateAdmin/stat_vent_cat.jsf")

public class JSFstat_Cat {
	@Autowired
	ClientServiceIMP clientservice;
	private List<CategorieStat> cs;
	public List<CategorieStat> getCs() {
		return cs;
	}
	public void setCs(List<CategorieStat> cs) {
		this.cs = cs;
	}
	public List<CategorieStat> NumCategorie2()
	{
		return clientservice.NumCategorie2();
	}
	public void cat(){
		List<CategorieStat> c = clientservice.NumCategorie2();
		cs= new ArrayList<CategorieStat>();
		for(CategorieStat c1 : c)
		{
			cs.add(new CategorieStat(c1.getN(),c1.getNomCategorie()));
			System.out.println("kkkkk"+c1.getN());
			System.out.println("yyyyyyyy"+c1.getNomCategorie());

		}
}
}
