package tn.esprit.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Commandes;

public interface CommandesRepository extends JpaRepository<Commandes, Integer> {

	@Query(value = "SELECT * FROM Commande WHERE payment_type=?1", nativeQuery = true)
	public List<Commandes> CommandeparType(String string);

	@Query(value = "SELECT * FROM Commande WHERE status=?1", nativeQuery = true)
	public List<Commandes> Commandeparstatus(String string);
	
	@Query(value = "SELECT * FROM Commande WHERE Payment_state=?1", nativeQuery = true)
	public List<Commandes> Commandepar_PaymentState(String string);

	@Query(value = "SELECT * FROM Commande WHERE client_user_id=?1", nativeQuery = true)
	public List<Commandes> CommandeparClient(int id);

	@Query(value = "UPDATE Commande c set c.status='payee',c.payment_type='en ligne'where c.id_commande=?1", nativeQuery = true)
	@Modifying
	@Transactional
	public void PayerEnLigne(@Param("id") int idCommande);

	@Query(value = "UPDATE Commande c set c.status='en livraison',c.payment_type='a domcilie'where c.id_commande=?1", nativeQuery = true)
	@Modifying
	@Transactional
	public void PayerPorteaPorte(@Param("id") int idCommande);

	@Query(value = "SELECT NEW tn.esprit.spring.entity.Commandes(c.id,c.date_commande,c.prixtotale,c.status)FROM Panier l join  l.commande c join l.produit p WHERE p.barreCode=:code")
	public List<Commandes> Commandeparcode(@Param("code") long code);
	
	@Query(value = "SELECT * FROM commande WHERE client_user_id=?1 and status='en cours'", nativeQuery = true)
	public Commandes CommandeencoursparClient(long iduser);

}
