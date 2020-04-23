package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Pub;


public interface PubRepository extends CrudRepository<Pub, Long> {
	@Query(value="select *  from publication  order by views desc limit 3",nativeQuery=true)
	public List<Pub> TopViewsJPQL();



	  @Modifying
	    @Transactional
	    @Query(value="Delete  from publication  where DATEDIFF(CURRENT_TIMESTAMP ,publication.date  )>=15 AND publication.rating=0",nativeQuery=true)
	    public void deletePubsWithNoInteractionJPQL();
	  
	  
	    @Modifying
	    @Transactional
	    @Query("DELETE from Pub p where p.rating=0")
	    public void deleteAutoJPQL();
}
