package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entity.AppUser;
import tn.esprit.spring.entity.StoreManger;


public interface StoreManagerRepository extends JpaRepository<StoreManger, Long > {

}
