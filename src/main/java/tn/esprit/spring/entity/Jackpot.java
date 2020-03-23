package tn.esprit.spring.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime date_S;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime date_F;
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
	public LocalDateTime getDate_S() {
		return date_S;
	}
	public void setDate_S(LocalDateTime date_S) {
		this.date_S = date_S;
	}
	public LocalDateTime getDate_F() {
		return date_F;
	}
	public void setDate_F(LocalDateTime date_F) {
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
	public Jackpot(int jpId, JackpotGoal but, LocalDateTime date_S, LocalDateTime date_F, Long jpSum, Event event) {
		super();
		this.jpId = jpId;
		this.but = but;
		this.date_S = date_S;
		this.date_F = date_F;
		this.jpSum = jpSum;
		this.event = event;
	}
	

}
