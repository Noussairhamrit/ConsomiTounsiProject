package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
//@Table(
//	    uniqueConstraints=
//	        @UniqueConstraint(columnNames={ "User_Id","Prod_Id"})
//	)
public class UsersViews implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3090977258317652334L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int views=0;
	@ManyToOne
	private AppUser user;
	
	@ManyToOne
	private Publicite publicite;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getViews() {
		return views;
	}

	public void setViews() {
		this.views = this.views+1;
	}

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}

	public Publicite getPublicite() {
		return publicite;
	}

	public void setPublicite(Publicite publicite) {
		this.publicite = publicite;
	}

	public UsersViews() {
		super();
		
	}

	public UsersViews(int views, AppUser user, Publicite publicite) {
		super();
		this.views = views;
		this.user = user;
		this.publicite = publicite;
	}

	@Override
	public String toString() {
		return "UsersViews [id=" + id + ", views=" + views + ", user=" + user + ", publicite=" + publicite + "]";
	}
	
	
	
	
	
	
	

}
