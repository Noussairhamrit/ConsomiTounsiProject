package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.Event;
@Repository
public interface EventRepository extends CrudRepository<Event,Integer> {

	//Event retrieveEventByTitle(String eventTitle);
	@Query(value = "SELECT * FROM Event WHERE event_title=?1", nativeQuery = true)
	public List<Event> EventByTitle(int eventTitle);
	
	
	

	//Event retrieveEventByTitle(String eventTitle);
}
