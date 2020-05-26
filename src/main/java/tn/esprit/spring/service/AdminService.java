package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Admin;
import tn.esprit.spring.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	AdminRepository adminrepository;

	public Admin authenticate(String login, String password) {

		return adminrepository.getAdminByUser_nameAndPassword(login, password);
	}

}
