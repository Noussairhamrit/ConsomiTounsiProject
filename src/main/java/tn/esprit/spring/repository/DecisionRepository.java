package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Decision;

public interface DecisionRepository extends CrudRepository<Decision,Integer> {

}
