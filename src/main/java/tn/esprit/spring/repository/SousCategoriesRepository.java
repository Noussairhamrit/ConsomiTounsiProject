package tn.esprit.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.SousCategories;

public interface SousCategoriesRepository extends JpaRepository<SousCategories,Long> {
	
	

	
}