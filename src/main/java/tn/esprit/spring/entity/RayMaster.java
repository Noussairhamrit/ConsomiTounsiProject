package tn.esprit.spring.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class RayMaster extends AppUser  {
	private double salaire_R_Master;
	
	
	@OneToMany(mappedBy="raymaster")
	private List<Ray> ray_m;

}
