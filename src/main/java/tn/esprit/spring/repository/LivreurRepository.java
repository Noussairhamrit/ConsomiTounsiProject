package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.entity.Livreur;

public interface LivreurRepository extends JpaRepository<Livreur,Long> {
	
	@Query(value = "SELECT * FROM Livreur WHERE dispo_liv = 1", nativeQuery = true)
	public List<Livreur> GetLivreurDispo();
	
	

}
