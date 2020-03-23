package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.User;

public interface EventService {

	Event addEvent(Event e);

	List<Event> retrieveAllEvents();

	Event updateEvent(Event e);

	void deleteEvent(String id);

	

	Event retrieveEvent(String id);

}
