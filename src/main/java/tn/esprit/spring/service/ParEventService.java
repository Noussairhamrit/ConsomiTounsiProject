package tn.esprit.spring.service;

public interface ParEventService {
	public void affecterParticipantAEvent(int pareventId, int eventId);
	public void desaffecterParticipantDEvenement(int pareventId, int eventId);
	public int getNombreParticipantJPQL();
}
