package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Event;

public interface EventService {

	Event addEvent(Event e);

	List<Event> retrieveAllEvents();

	Event updateEvent(Event e);

	void deleteEvent(int id);

	

	Event retrieveEvent(int string);

	List<Event> EventByTitle(int eventTitle);

//	public void affecterEventAJackpot(int eventId, int jpId);
//	public void desaffecterEventDJackpot(int eventId, int jpId);


	

//	Event retrieveEventByTitle(String eventTitle);

}
