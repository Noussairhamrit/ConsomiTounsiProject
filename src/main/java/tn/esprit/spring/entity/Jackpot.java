package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Jackpot")
public class Jackpot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "JP_ID")
	private int jpId;
	@Enumerated(EnumType.STRING)
	JackpotGoal but;
	@Temporal(TemporalType.DATE)
	private Date date_S;

	@Temporal(TemporalType.DATE)
	private Date date_F;
	@Column(name = "JP_SUM")
	Long jpSum;

	@OneToOne
	private Event event;

	public int getJpId() {
		return jpId;
	}

	public void setJpId(int jpId) {
		this.jpId = jpId;
	}

	public Date getDate_S() {
		return date_S;
	}

	public void setDate_S(Date date_S) {
		this.date_S = date_S;
	}

	public Date getDate_F() {
		return date_F;
	}

	public void setDate_F(Date date_F) {
		this.date_F = date_F;
	}

	public Long getJpSum() {
		return jpSum;
	}

	public void setJpSum(Long jpSum) {
		this.jpSum = jpSum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Jackpot(int jpId, JackpotGoal but, Date date_S, Date date_F, Long jpSum, Event event) {
		super();
		this.jpId = jpId;
		this.but = but;
		this.date_S = date_S;
		this.date_F = date_F;
		this.jpSum = jpSum;
		this.event = event;
	}

	


	public JackpotGoal getBut() {
		return but;
	}

	public void setBut(JackpotGoal but) {
		this.but = but;
	}

	

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Jackpot() {
		super();
	}

	@Override
	public String toString() {
		return "Jackpot [jpId=" + jpId + ", but=" + but + ", date_S=" + date_S + ", date_F=" + date_F + ", jpSum="
				+ jpSum + ", event=" + event + "]";
	}

}
