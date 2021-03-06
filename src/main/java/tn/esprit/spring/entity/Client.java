package tn.esprit.spring.entity;

import javax.persistence.Entity;

@Entity
public class Client extends AppUser {
	private long num_carte_fidelity ;
	private String interet;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getInteret() {
		 return interet;
	}


	public void setInteret(String interet) {
		this.interet = interet;
	}


	public Client( String userName, String encrytedPassword, String nom, String prenom,
			long cin, String address, long num_tel, String email) {
		super( userName, encrytedPassword, nom, prenom, cin, address, num_tel, email);
	}


	public Client(Long userId, String userName, String encrytedPassword, boolean enabled, String nom, String prenom,
			long cin, String address, long num_tel, String email, long num_carte_fidelity, String interet) {
		super(userId, userName, encrytedPassword, enabled, nom, prenom, cin, address, num_tel, email);
		this.num_carte_fidelity = num_carte_fidelity;
		this.interet = interet;
	}


	public Client(long num_carte_fidelity,Long userId, String userName, String encrytedPassword, boolean enabled, String nom, String prenom,
			long cin, String address, long num_tel, String email) {
		super(userId,userName,encrytedPassword, enabled,nom,prenom,cin, address,num_tel,email);
		this.num_carte_fidelity = num_carte_fidelity;
	}


	public long getNum_carte_fidelity() {
		return num_carte_fidelity;
	}

	public void setNum_carte_fidelity(long num_carte_fidelity) {
		this.num_carte_fidelity = num_carte_fidelity;
	}
	
	

}
