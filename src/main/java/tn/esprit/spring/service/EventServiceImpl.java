package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Event;
import tn.esprit.spring.repository.EventRepository;
@Service
public class EventServiceImpl implements EventService {

	
@Autowired
EventRepository eventRepository;


private static final Logger L=LogManager.getLogger(EventServiceImpl.class);

@Override
public  List<Event>retrieveAllEvents(){
	List<Event> events=(List<Event>) eventRepository.findAll();
	for(Event event:events){
	L.info("event +++ : "+ event);}
	return events;
}

@Override
public Event addEvent(Event e){
	return eventRepository.save(e);
	
}

@Override
public Event updateEvent(Event e){
	return eventRepository.save(e);
	
}

@Override
public void deleteEvent(String eventId) {
	eventRepository.deleteById(Long.parseLong(eventId));
	
}
@Override
public Event retrieveEvent(String eventId) {
	Event e;
	e=eventRepository.findById(Long.parseLong(eventId)).orElse(null);
	return e;
	
}
//@Override
//public Event retrieveEventByTitle(String eventTitle) {
//	return eventRepository.retrieveEventByTitle(eventTitle);
//}

}