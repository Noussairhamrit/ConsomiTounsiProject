package tn.esprit.spring.repository.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entity.AppUser;
import tn.esprit.spring.entity.Product.StoreManger;


public interface StoreManagerRepository extends JpaRepository<StoreManger, Long > {

}
