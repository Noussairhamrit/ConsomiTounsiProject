package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Jackpot;
@Repository
public interface JackpotRepository extends CrudRepository<Jackpot, Integer> {

}
