package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.ImageProduit;

public interface ImageProduitRepository extends JpaRepository<ImageProduit, Long> {

}
