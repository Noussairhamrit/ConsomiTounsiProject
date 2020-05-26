package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name = "Publicite")
public class Publicite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Pub_Id")
	private int idPub;
	@Column(name = "Pub_name")
	private String name;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_Start")
	private Date dateStart;
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_End")
	private Date dateEnd;
	@Column(name = "Nbre_target")
	private int target=0;
	@Column(name = "Nbre_view")
	private int view=0;
	@Column(name = "Pub_Cost")
	private long cost;
	@Column(name = "image")
	private String image;
	@Column(name = "vedio")
	private String vedio;
	@Enumerated(EnumType.STRING)
	private Canal canal;
	
	
	
	@OneToMany(mappedBy="publicite",cascade=CascadeType.REMOVE)
	@JsonIgnore
	private List <UsersViews> tUsersViews;
	
	
/////Actor
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private StoreManger gerant;
	
	@OneToMany(mappedBy="publicite")
	private List<Cible> cibles;
	
	@NotNull
	@ManyToOne
	private  Produit product;
	
	public int getIdPub() {
		return idPub;
	}
	public void setIdPub(int idPub) {
		this.idPub = idPub;
	}
	public long getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public StoreManger getGerant() {
		return gerant;
	}
	public void setGerant(StoreManger gerant) {
		this.gerant = gerant;
	}
	public List<Cible> getCibles() {
		return cibles;
	}
	public void setCibles(List<Cible> cibles) {
		this.cibles = cibles;
	}
	public int getId() {
		return idPub;
	}
	public void setId(int id) {
		this.idPub = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public long getView() {
		return view;
	}
	public void setView() {
		this.view =this.view+1;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getVedio() {
		return vedio;
	}
	public void setVedio(String vedio) {
		this.vedio = vedio;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Publicite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Publicite(int idPub, String name, Date dateStart, Date dateEnd, int target, int view, long cost,
			String image, String vedio, Canal canal, List<UsersViews> tUsersViews, StoreManger gerant,
			List<Cible> cibles, @NotNull Produit product) {
		super();
		this.idPub = idPub;
		this.name = name;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.target = target;
		this.view = view;
		this.cost = cost;
		this.image = image;
		this.vedio = vedio;
		this.canal = canal;
		this.tUsersViews = tUsersViews;
		this.gerant = gerant;
		this.cibles = cibles;
		this.product = product;
	}
	@Override
	public String toString() {
		return "Publicite [id=" + idPub + ", name=" + name + ", canal=" + canal + ", dateStart=" + dateStart + ", dateEnd="
				+ dateEnd + ", target=" + target + ", view=" + view + ", cost=" + cost + ", image=" + image + ", vedio="
				+ vedio + "]";
	}
	
	
	 @PrePersist
	    public void onPrePersist() {
	        this.dateStart = new Date();
	        this.dateEnd = new Date();
	    }
	
	
	
	
	
	

}
