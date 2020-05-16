package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Panier;
import tn.esprit.spring.entity.lignecommandeproduit;
@Repository
public interface PanierRepository extends JpaRepository<Panier , Integer> {
	
	@Query(value = "SELECT  NEW tn.esprit.spring.entity.lignecommandeproduit(l.id,p.nom,l.quantite,p.prix,l.quantite*p.prix) FROM Panier l join l.commande c  join l.produit p   WHERE c.client.id=:idc and c.status='en cours'")
	public List<lignecommandeproduit> panier_en_cour_ParIdclient(@Param("idc")long i);
	@Query(value = "SELECT  NEW tn.esprit.spring.entity.lignecommandeproduit(p.nom,l.quantite,p.prix,l.quantite*p.prix) FROM Panier l join l.commande c  join l.produit p   WHERE c.client.id=:idc and c.status='Comfirmer'")
	public List<lignecommandeproduit> panier_confirmer_ParIdclient(@Param("idc")long i);
	@Query(value = "SELECT * FROM Panier l JOIN commande c on l.id_commande=c.id_commande  WHERE l.id_produit=?1 AND c.client_user_id=?2 AND l.status='en cours' and c.id_commande !=?3 ", nativeQuery = true)
	public Panier findPanier(int idProduit,Long idClient,int idCommande);
	@Query(value = "SELECT * FROM Panier l JOIN commande c on l.id_commande=c.id_commande  WHERE c.id_commande=?1 ", nativeQuery = true)
	public List <Panier> findPanier_par_commande(int idCommande);
	@Query(value = "SELECT * FROM Panier l JOIN commande c on l.id_commande=c.id_commande  WHERE l.id_produit=?1 AND c.client_user_id=?2 AND c.status='en cours'", nativeQuery = true)
	public Panier findPanier(int idProduit,Long idClient);
	@Query(value = "SELECT * FROM Panier l JOIN commande c on l.id_commande=c.id_commande  WHERE  c.client_user_id=?1 ", nativeQuery = true)
	public List<Panier> findPanier_by_id_client(Long idClient);
	
	

}
