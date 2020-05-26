package tn.esprit.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.AppUser;
import tn.esprit.spring.entity.Publicite;
import tn.esprit.spring.entity.UsersViews;
import tn.esprit.spring.repository.UserViewsRepository;

@Service
public class UsrerViewServiceImpl implements UserViewsService {

//	@Autowired
//	UserViewsRepository userViewsRepository;
//	
//	
////	public Optional<UsersViews> getUserViews(AppUser user, Publicite publicite) {
////		return  userViewsRepository.getUserViews(user, publicite);
////	}
//
//	
//	public UsersViews setUserViews(UsersViews userViews) {
//		userViews.setViews();
//		return userViewsRepository.saveAndFlush(userViews);
//	}

}
