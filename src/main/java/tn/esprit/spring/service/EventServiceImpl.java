package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Jackpot;
import tn.esprit.spring.repository.EventRepository;
import tn.esprit.spring.repository.JackpotRepository;
@Service
public class EventServiceImpl implements EventService {

	
@Autowired
EventRepository eventRepository;
JackpotRepository jackpotRepository;


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
public void deleteEvent(int eventId) {
	eventRepository.deleteById(eventId);
	
}
@Override
public Event retrieveEvent(int eventId) {
	
	Event e = eventRepository.findById(eventId).get();
	return e;
	
}
@Override
public List<Event>EventByTitle(int eventTitle) {
	return eventRepository.EventByTitle(eventTitle);
	
}



//@Transactional	
//public void affecterEventAJackpot(int eventId, int jpId) {
//	Jackpot jackpotManagedEntity = jackpotRepository.findById(jpId).get();
//	Event eventManagedEntity = eventRepository.findById(eventId).get();
//
//	if(jackpotManagedEntity.getEvent() == null){
//
//		List<Event> event = new ArrayList<>();
//		event.add(eventManagedEntity);
//		jackpotManagedEntity.setEvent(event);
//	}else{
//
//		jackpotManagedEntity.getEvent().add(eventManagedEntity);
//
//	}
//
//}
//						
//@Transactional
//public void desaffecterEventDJackpot(int eventId, int jpId)
//{
//	Jackpot jackpot = jackpotRepository.findById(jpId).get();
//
//	int eventNb = jackpot.getEvent().size();
//	for(int index = 0; index < eventNb; index++){
//		if(jackpot.getEvent().get(index).getEventId() == eventId){
//			jackpot.getEvent().remove(index);
//			break;//a revoir
//		}
//	}
//}









//@Override
//public Event retrieveEventByTitle(String eventTitle) {
//	return eventRepository.retrieveEventByTitle(eventTitle);
//}






}


