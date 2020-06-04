package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Provider;
import tn.esprit.spring.entity.Stock;

public interface ProviderRepository extends CrudRepository<Provider , Integer> {
	


}
