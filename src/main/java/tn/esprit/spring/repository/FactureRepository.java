package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.entity.Factures;
import tn.esprit.spring.entity.Payment_TYPE;

public interface FactureRepository extends CrudRepository<Factures,Integer>{
	
	@Query("Select "
			+ " f from Factures f "
			+ " join f.commande c "
			+ " where c=:cmd ")
    public List<Factures> getAllfactures_by_Commande(@Param("cmd") Commandes cmd);
	
	@Query("Select "
			+ " f from Factures f "
			+ " join f.commande c "
			+ " where c.payment_type=:payment_type ")
	public List<Factures> getAllfactures_by_PayementType_En_ligne( );
	
	@Query("Select "
			+ " f from Factures f "
			+ " join f.commande c "
			+ " where c.payment_type=:Prote_A_Prote")
	public List<Factures> getAllfactures_by_PayementType_Prote_A_Prote(@Param("Prote_A_Prote") String Prote_A_Prote);
	
	@Query("Select "
			+ " f from Factures f "
			+ " join f.commande c "
			+ " where c.Payment_state=:true")
	public List<Factures> getAllfactures_by_Payementstate_true(@Param("true") String truue);
	
	@Query("Select "
			+ " f from Factures f "
			+ " join f.commande c "
			+ " where c.Payment_state=:false")
	public List<Factures> getAllfactures_by_Payementstate_false(@Param("false") String ff);
	
	 @Query("select c.payment_type from Commandes c join c.facture e where e.id=:factureID")
	    public String  get_payment_type_by_factureID(@Param("factureID")int factureID);
	    

}
