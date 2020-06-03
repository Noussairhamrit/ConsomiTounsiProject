package tn.esprit.spring.entity;

import java.util.Date;

public class Eventcommande {
private int id;
	
	private long title;
	
	private Date start;
	
	private Date end ;
	
	

	public Eventcommande() {
		super();
	}

	public Eventcommande(int id, long title, Date start) {
		super();
		this.id = id;
		this.title = title;
		this.start = start;
	}
	

	public Eventcommande(int id, long title, Date start, Date end) {
		super();
		this.id = id;
		this.title = title;
		this.start = start;
		this.end = end;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getTitle() {
		return title;
	}

	public void setTitle(long title) {
		this.title = title;
	}


	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

}
