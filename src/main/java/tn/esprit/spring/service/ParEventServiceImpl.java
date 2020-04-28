package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.ParEvent;
import tn.esprit.spring.repository.EventRepository;
import tn.esprit.spring.repository.ParEventRepository;



@Service
public class ParEventServiceImpl implements ParEventService {

	@Autowired
	ParEventRepository pareventRepository;
	@Autowired
	EventRepository eventRepository;

	//private static final Logger L = LogManager.getLogger(JackpotServiceImpl.class);
	
	
	
	@Transactional	
	public void affecterParticipantAEvent(int pareventId, int eventId) {
		Event eventManagedEntity = eventRepository.findById(eventId).get();
		ParEvent pareventManagedEntity = pareventRepository.findById(pareventId).get();

		if(eventManagedEntity.getReservation() == null){

			List<ParEvent> Reservation = new ArrayList<>();
			Reservation.add(pareventManagedEntity);
			eventManagedEntity.setReservation(Reservation);
		}else{

			eventManagedEntity.getReservation().add(pareventManagedEntity);

		}

	}
	
	@Transactional
	public void desaffecterParticipantDEvenement(int pareventId, int eventId)
	{
		Event event = eventRepository.findById(eventId).get();

		int pareventNb = event.getReservation().size();
		for(int index = 0; index < pareventNb; index++){
			if(event.getReservation().get(index).getPareventId() == pareventId){
				event.getReservation().remove(index);
				break;//a revoir
			}
		}
	}
	
	public int getNombreParticipantJPQL() {
		return pareventRepository.countpar();
	}
	
}