package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Event;
import tn.esprit.spring.service.EventService;

@RestController
public class EventRestController {
@Autowired
EventService es;

@GetMapping("/retrieve-all-events")
@ResponseBody
public List<Event> getEvents() {
List<Event> list= es.retrieveAllEvents();
return list;
}



// Ajouter Event : http://localhost:8080/SpringMVC/servlet/add-event
@PostMapping("/add-event")
@ResponseBody
public Event addEvent(@RequestBody Event e) {
Event event= es.addEvent(e);
return event;
}



// http://localhost:8081/SpringMVC/servlet/update-event
@PutMapping("/update-event")
@ResponseBody
public Event updateEvent(@RequestBody Event e) {
	return es.updateEvent(e);
}

// http://localhost:8081/SpringMVC/servlet/remove-event/{event-id}
@DeleteMapping("/delete-event/{event-id}")
@ResponseBody
public void deleteEvent(@PathVariable("event-id") String eventId) {
es.deleteEvent(eventId);
}

// http://localhost:8081/SpringMVC/servlet/retrieve-event/{event-id}
@GetMapping("/retrieve-event/{event-id}")
@ResponseBody
public Event retrieveEvent(@PathVariable("event-id") String eventId) {
return es.retrieveEvent(eventId);
}


//@GetMapping("/retrieve-event-title/{event-title}")
//public ResponseEntity <Event> retrieveEventByTitle(@PathVariable("eventTitle") String eventTitle) {
//    Event event =  es.retrieveEventByTitle(eventTitle);
//   
//    return new ResponseEntity<Event>(event, HttpStatus.FOUND);
//
//}


}
