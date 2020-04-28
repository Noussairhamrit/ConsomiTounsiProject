package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Livreur;

@Repository
public interface PieChartRepository extends JpaRepository<Livreur,Long> {

}
