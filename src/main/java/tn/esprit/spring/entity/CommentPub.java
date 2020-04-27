package tn.esprit.spring.entity;

import java.io.Serializable;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="commentPub")
public class CommentPub implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private Date date;
	private Integer likes ; 
	private Integer dislike ;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	Pub Pub;

	
	
	public CommentPub() {

	}
	public CommentPub(Long id, String description, Date date, Integer likes, Integer dislike,
			tn.esprit.spring.entity.Pub pub) {
		super();
		this.id = id;
		this.description = description;
		this.date = date;
		this.likes = likes;
		this.dislike = dislike;
		Pub = pub;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Pub getPub() {
		return Pub;
	}
	public void setPub(Pub pub) {
		Pub = pub;
	}


	public Integer getDislike() {
		return dislike;
	}
	public void setDislike(Integer dislike) {
		this.dislike = dislike;
	}

	public Integer getLikes() {
		return likes;
	}
	public void setLikes(Integer likes) {
		this.likes = likes;
	}

}
