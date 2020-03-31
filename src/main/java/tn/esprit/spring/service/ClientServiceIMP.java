package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.AppUser;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.repository.ClientRepository;
@Service
public class ClientServiceIMP {
	@Autowired
	ClientRepository clientrepository;
	
	public List<Client> findOne(){
		return clientrepository.findAll();
		}
		public Client save(Client u) {
			return clientrepository.save(u);
		}
}
