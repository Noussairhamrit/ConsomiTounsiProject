package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Pub;
import tn.esprit.spring.service.IPubService;

@Controller
public class IControllerPubImp {
	@Autowired
	IPubService ipubservice ;
	
	public Long addPub(Pub pub) {
		ipubservice.addPub(pub);
		return pub.getId();

	}
}
