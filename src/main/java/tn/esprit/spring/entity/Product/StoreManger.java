package tn.esprit.spring.entity.Product;


import javax.persistence.Entity;

import tn.esprit.spring.entity.AppUser;





@Entity 
public class StoreManger extends AppUser{
	private double StoreManger_salary;

	public double getStoreManger_salary() {
		return StoreManger_salary;
	}

	public void setStoreManger_salary(double storeManger_salary) {
		StoreManger_salary = storeManger_salary;
	}

	public StoreManger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StoreManger(Long userId, String userName, String encrytedPassword, boolean enabled, String nom,
			String prenom, long cin, String address, long num_tel, String email) {
		super(userId, userName, encrytedPassword, enabled, nom, prenom, cin, address, num_tel, email);
		// TODO Auto-generated constructor stub
	}

	public StoreManger(double storeManger_salary) {
		super();
		StoreManger_salary = storeManger_salary;
	}

	@Override
	public String toString() {
		return "StoreManger [StoreManger_salary=" + StoreManger_salary + "]";
	}
	
	
	
	
}
