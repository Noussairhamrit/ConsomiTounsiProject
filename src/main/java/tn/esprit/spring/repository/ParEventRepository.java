package tn.esprit.spring.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;




import tn.esprit.spring.entity.ParEvent;

public interface ParEventRepository extends JpaRepository<ParEvent, Integer>{
	
//	@Query("Select "
//			+ "DISTINCT par from Parevent par "
//			+ "join par.event dps "
//			+ "join event.event ev "
//			+ "where ev=:event")
//    public List<ParEvent> getAllParByEvent(@Param("event") Event event);

	@Query("SELECT count(*) FROM ParEvent")
    public int countpar();
	
	
}
