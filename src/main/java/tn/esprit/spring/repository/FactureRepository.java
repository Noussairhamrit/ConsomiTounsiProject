package tn.esprit.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.entity.Factures;
import tn.esprit.spring.entity.Payment_TYPE;

public interface FactureRepository extends JpaRepository<Factures,Integer>{
	
	@Query(value = "SELECT * FROM Factures WHERE commande_id_commande=?1", nativeQuery = true)
    public List<Factures> getAllfactures_by_Commande( int cmd);
	
	@Query(value="SELECT * FROM Factures f JOIN commande c on f.commande_id_commande=c.id_commande WHERE c.payment_type=?1", nativeQuery = true)
	public List<Factures> getAllfactures_by_PayementType(String payementType );
	
	
	@Query(value="SELECT * FROM Factures f JOIN commande c on f.commande_id_commande=c.id_commande WHERE c.Payment_state=?1", nativeQuery = true)
	
	public List<Factures> getAllfactures_by_Payementstate(String payementstate);
	
	
	 @Query("select c.payment_type from Commandes c join c.facture e where e.id=:factureID")
	    public String  get_payment_type_by_factureID(@Param("factureID")int factureID);
	 ////na9it il prix totale n7otou fil montant
		@Query(value = "UPDATE Factures c set c.commande_id_commande=?1  where c.id_facture=?2", nativeQuery = true)
		@Modifying
		@Transactional
	 public void affecterCommande_A_Facture(int id_commande,int id_facture) ;
	    

}
