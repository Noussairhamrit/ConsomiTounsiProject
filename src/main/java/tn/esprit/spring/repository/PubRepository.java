package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Pub;


public interface PubRepository extends CrudRepository<Pub, Long> {

}
