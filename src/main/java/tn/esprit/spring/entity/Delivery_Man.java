package tn.esprit.spring.entity;

import javax.persistence.Entity;

@Entity
public class Delivery_Man extends AppUser{
	private String Moyenne_de_transport;
	private boolean disponibilite_D_Man;
	private Long performence_D_Man;
	private double Salaire_D_Man;

}
