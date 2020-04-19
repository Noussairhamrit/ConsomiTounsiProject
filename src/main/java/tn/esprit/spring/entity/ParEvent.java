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
	@Column(name = "PAREVENT_NAME")
	private String parname;
	@Column(name = "PAREVENT_MAIL")
	private String parmail;
	@ManyToMany(mappedBy="Reservation", cascade = CascadeType.ALL)
	private List<Event> events;
	
	
	
	public String getParname() {
		return parname;
	}



	public void setParname(String parname) {
		this.parname = parname;
	}



	public String getParmail() {
		return parmail;
	}



	public void setParmail(String parmail) {
		this.parmail = parmail;
	}



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



	public List<Event> getEvents() {
		return events;
	}



	public void setEvents(List<Event> events) {
		this.events = events;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public ParEvent(int pareventId, Date pareventDate, String parname, String parmail, List<Event> events) {
		super();
		this.pareventId = pareventId;
		this.pareventDate = pareventDate;
		this.parname = parname;
		this.parmail = parmail;
		this.events = events;
	}



	@Override
	public String toString() {
		return "ParEvent [pareventId=" + pareventId + ", pareventDate=" + pareventDate + ", parname=" + parname
				+ ", parmail=" + parmail + ", events=" + events + "]";
	}



	public ParEvent() {
		super();
		// TODO Auto-generated constructor stub
	}



	



}
