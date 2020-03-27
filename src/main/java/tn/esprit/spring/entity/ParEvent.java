package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ParEvent")
public class ParEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RESERVATION_ID")
	private int pareventId;
	@Temporal(TemporalType.DATE)
	private Date pareventDate;
	@ManyToMany(mappedBy="Reservation", cascade = CascadeType.ALL)
	private Set<Event> events;
	
	
	
	public int getPareventId() {
		return pareventId;
	}



	public void setPareventId(int pareventId) {
		this.pareventId = pareventId;
	}



	public Date getPareventDate() {
		return pareventDate;
	}



	public void setPareventDate(Date pareventDate) {
		this.pareventDate = pareventDate;
	}



	public Set<Event> getEvents() {
		return events;
	}



	public void setEvents(Set<Event> events) {
		this.events = events;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
