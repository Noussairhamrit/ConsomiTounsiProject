package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Livreur;
import tn.esprit.spring.service.ILivreurService;

@RestController
public class LivreurRestController {
	@Autowired
	ILivreurService iLivreurService;

	// http://localhost:8081/SpringMVC/servlet/ajouterLivreur
	@PostMapping("/ajouterLivreur")
	@ResponseBody
	public Livreur ajouterLivreur(@RequestBody Livreur livreur) {
		iLivreurService.ajouterLivreur(livreur);
		return livreur;

	}
	// http://localhost:8081/SpringMVC/servlet/deleteLivreur/{userId}

	@DeleteMapping("/deleteLivreur/{userId}")
	@ResponseBody
	public void deleteLivreur(@PathVariable("userId") Long userId) {
		iLivreurService.deleteLivreur(userId);
	}

	// http://localhost:8081/SpringMVC/servlet/mettreAjourLivreurBydispo/{userId}
	@PutMapping("/mettreAjourLivreurBydispo/{userId}/{newd}")
	@ResponseBody
	public void mettreAjourLivreurBydispo(@PathVariable("newd") boolean dispo_liv, @PathVariable("userId") Long userId) {
		iLivreurService.mettreAjourLivreurBydispo(userId, dispo_liv);
	}

	// http://localhost:8081/SpringMVC/servlet/mettreAjourLivreurBycharge/{userId}
	@PutMapping("/mettreAjourLivreurBycharge/{userId}/{newc}")
	@ResponseBody
	public void mettreAjourLivreurBycharge(@PathVariable("userId") Long userId,@PathVariable("newc") int chargeT_liv) {
		iLivreurService.mettreAjourLivreurBycharge(userId,chargeT_liv);
	}
	
	// http://localhost:8081/SpringMVC/servlet/retriveLivreur
		 @GetMapping("/retriveLivreur/{userId}")
		 @ResponseBody
		 public Livreur retriveLivreur(@PathVariable("userId")Long userId){
			 return iLivreurService.retriveLivreur(userId);
}
}
