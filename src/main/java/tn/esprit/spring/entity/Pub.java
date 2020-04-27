package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="publication")
public class Pub implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private byte[]image;
	private String title;
	private String description;
	private Date date;
	CatPub catPub;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Pub")
	private Set<CommentPub> commentPub;
	private Integer rating;
	private Integer views;
	public Pub() {
		
	}

	public Pub(Long id, byte[] image, String title, String description, Date date, CatPub catPub,
			Set<CommentPub> commentPub, Integer rating, Integer views) {
		super();
		this.id = id;
		this.image = image;
		this.title = title;
		this.description = description;
		this.date = date;
		this.catPub = catPub;
		this.commentPub = commentPub;
		this.rating = rating;
		this.views = views;
	}

	public Set<CommentPub> getCommentPub() {
		return commentPub;
	}
	public void setCommentPub(Set<CommentPub> commentPub) {
		this.commentPub = commentPub;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public CatPub getCatPub() {
		return catPub;
	}
	public void setCatPub(CatPub catPub) {
		this.catPub = catPub;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	
	 
}