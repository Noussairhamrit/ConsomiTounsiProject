package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Ray;
import tn.esprit.spring.service.IRaySerivce;

@RestController
public class RayRestController {
	@Autowired
	IRaySerivce iRayService;
	
	// http://localhost:8081/SpringMVC/servlet/ajouterRay
	@PostMapping("/ajouterRay")
	@ResponseBody
	public Ray ajouterStock(@RequestBody Ray ray) {
		iRayService.ajouterRay(ray);
		return ray;
	}
	
	
	// http://localhost:8081/SpringMVC/servlet/deleteRay/{RAYID}
	 @DeleteMapping("/deleteRay/{RAYID}") 
	 @ResponseBody
	public void deleteRay(@PathVariable("RayId")int RayId){
		 iRayService.deleteRay(RayId);
	 }
	 
//	// http://localhost:8081/SpringMVC/servlet/UpdateRay/{RayId}/{newray}
//		 @PutMapping("/mettreAjourStock/{id}/{newetat}") 
//		 @ResponseBody
//		 public void mettreAjourStock(@PathVariable("newetat") String etat, @PathVariable("id") int IdStock){
//			 iStockService.mettreAjourLivraison(IdStock, etat);
//		 }

}
