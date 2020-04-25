package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

}
