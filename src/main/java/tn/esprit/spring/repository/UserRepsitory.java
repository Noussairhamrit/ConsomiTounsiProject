package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;


import tn.esprit.spring.entity.AppUser;
import tn.esprit.spring.entity.Product.StoreManger;



public interface UserRepsitory extends CrudRepository<StoreManger,Long>{

}
