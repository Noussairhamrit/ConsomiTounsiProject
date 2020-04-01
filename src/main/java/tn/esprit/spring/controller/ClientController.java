package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.AppUser;


import tn.esprit.spring.service.ClientServiceIMP;
import tn.esprit.spring.service.UserDetailsServiceImpl;

@RestController
public class ClientController {
	@Autowired
	ClientServiceIMP client_service;
	
	
	  @GetMapping(value = "getclient")
	   
	  public List<Client> findOne() 
	  {
			return client_service.findOne();
		}
    
	  @PostMapping(value="ajouterclient")
	  @ResponseBody
	  public Client save(@RequestBody Client u){
		  client_service.save(u);
		  return u;
	  }
}
