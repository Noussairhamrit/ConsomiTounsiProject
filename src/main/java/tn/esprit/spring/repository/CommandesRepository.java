package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Commandes;

public interface CommandesRepository extends CrudRepository<Commandes, Integer> {

}
