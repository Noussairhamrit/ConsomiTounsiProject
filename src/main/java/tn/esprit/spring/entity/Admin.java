package tn.esprit.spring.entity;

import javax.persistence.Entity;

@Entity
public class Admin extends AppUser {
	private long Num_Serie_ADMIN;
	
	

	public long getNum_Serie_ADMIN() {
		return Num_Serie_ADMIN;
	}



	public void setNum_Serie_ADMIN(long num_Serie_ADMIN) {
		Num_Serie_ADMIN = num_Serie_ADMIN;
	}



	public Admin() {
		super();
		
	}



	public Admin(Long userId, String userName, String encrytedPassword, boolean enabled, String nom, String prenom,
			long cin, String address, long num_tel, String email, long num_Serie_ADMIN) {
		super(userId, userName, encrytedPassword, enabled, nom, prenom, cin, address, num_tel, email);
		Num_Serie_ADMIN = num_Serie_ADMIN;
	}

}
  