package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Admin;
import tn.esprit.spring.entity.Commandes;
import tn.esprit.spring.entity.Livreur;

public interface LivreurRepository extends JpaRepository<Livreur, Long> {
	@Query(value = "SELECT * FROM Livreur", nativeQuery = true)
	public List<Livreur> GetLivreur();

	@Query(value = "SELECT * FROM Livreur WHERE dispo_liv = 1", nativeQuery = true)
	public List<Livreur> GetLivreurDispo();

	@Query("SELECT e FROM Livreur e  WHERE e.userName=:user_name and e.encrytedPassword=:password and e.enabled=:enabled")
	public Livreur getLivreurByUser_nameAndPassword(@Param("user_name") String login,
			@Param("password") String password, @Param("enabled") Boolean enabled);

	@Query(value = "SELECT * FROM Livraison WHERE livreur_user_id=?1", nativeQuery = true)
	public List<Commandes> CommandeparClient(int id);

	@Query(value = "SELECT user_id FROM Livreur ORDER BY chargeT_liv DESC LIMIT 5", nativeQuery = true)
	public List<Long> Top10nbLivreur();

	@Query(value = "SELECT user_id,user_name,charget_liv FROM livreur WHERE charget_liv = (SELECT MAX(charget_liv) FROM livreur)", nativeQuery = true)
	public Long BestLivreur();
}
