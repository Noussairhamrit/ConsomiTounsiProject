package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Event")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EVENT_ID")
	private Integer eventId;
	@Column(name = "EVENT_TITLE")
	private String eventTitle;
	@Column(name = "EVENT_TYPE")
	private String eventTYPE;
	@Temporal(TemporalType.DATE)
	private Date eventDate;
	@Column(name = "EVENT_PICTURE")
	private String eventPicture;
	
	@OneToOne(mappedBy="event")
	private Jackpot jackpot;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<ParEvent> Reservation;
	
	
	
	public Jackpot getJackpot() {
		return jackpot;
	}

	public void setJackpot(Jackpot jackpot) {
		this.jackpot = jackpot;
	}



	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
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

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
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

	public Event(Integer eventId, String eventTitle, String eventTYPE, Date eventDate, String eventPicture,
			Jackpot jackpot, List<ParEvent> reservation) {
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

	public List<ParEvent> getReservation() {
		return Reservation;
	}

	public void setReservation(List<ParEvent> reservation) {
		Reservation = reservation;
	}

}
