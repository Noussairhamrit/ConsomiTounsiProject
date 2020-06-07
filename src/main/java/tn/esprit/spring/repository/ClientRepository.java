package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Admin;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Panier;
import tn.esprit.spring.entity.Product.Produit;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long > {
	@Query(value = "SELECT user_id FROM Client   WHERE  num_carte_fidelity >=?1 ", nativeQuery = true)
	public List<String> findClient_pt_100(int nbpt);
	@Query(value = "SELECT  l.prod_id FROM Produit l join sous_cat c on l.souscat_sous_cat_id=c.sous_cat_id join categories ca on c.categorie_cat_id=ca.cat_id   WHERE ca.cat_nom =?1 and l.prod_prix<500 ", nativeQuery = true)
	public List<String> Produit_par_cat(String nom );
	@Query("SELECT e FROM Client e WHERE e.userName=:user_name and e.encrytedPassword=:password and e.enabled=:enabled")
	public Client getClientByUser_nameAndPassword(@Param("user_name") String login, @Param("password") String password, @Param("enabled") Boolean enabled);
	@Query("SELECT e FROM Client e WHERE e.email=:email")
	public Client getPassword(@Param("email") String email);
}
//SELECT  prod_id,prod_desc,barre_code,image,prod_nom,prod_poid,prod_prix,prix_achat,prix_vente,prod_qount,ray_ray_id,souscat_sous_cat_id,stock_id_stock 
//l.prod_id,l.prod_desc,l.barre_code,l.image,l.prod_nom,l.prod_poid,l.prod_prix,l.prix_achat,l.prix_vente,l.prod_qount,l.souscat_sous_cat_id