package tn.esprit.spring.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Event")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EVENT_ID")
	private int eventId;
	@Column(name = "EVENT_TITLE")
	private String eventTitle;
	@Column(name = "EVENT_TYPE")
	private String eventTYPE;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime eventDate;
	@Column(name = "EVENT_PICTURE")
	private String eventPicture;
	
	@OneToOne(mappedBy="event")
	private Jackpot jackpot;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<ParEvent> Reservation;
	public Jackpot getJackpot() {
		return jackpot;
	}

	public void setJackpot(Jackpot jackpot) {
		this.jackpot = jackpot;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	

	public String getEventTYPE() {
		return eventTYPE;
	}

	public void setEventTYPE(String eventTYPE) {
		this.eventTYPE = eventTYPE;
	}

	public LocalDateTime getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDateTime eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventPicture() {
		return eventPicture;
	}

	public void setEventPicture(String eventPicture) {
		this.eventPicture = eventPicture;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Event(int eventId, String eventTitle, String eventTYPE, LocalDateTime eventDate, String eventPicture,
			Jackpot jackpot, Set<ParEvent> reservation) {
		super();
		this.eventId = eventId;
		this.eventTitle = eventTitle;
		this.eventTYPE = eventTYPE;
		this.eventDate = eventDate;
		this.eventPicture = eventPicture;
		this.jackpot = jackpot;
		Reservation = reservation;
	}

	public Event() {
	}
	
	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventTitle=" + eventTitle + ", eventTYPE=" + eventTYPE + ", eventDate="
				+ eventDate + ", eventPicture=" + eventPicture + ", jackpot=" + jackpot + ", Reservation=" + Reservation
				+ "]";
	}

}
