package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
	@Query("SELECT e FROM Admin e WHERE e.userName=:user_name and e.encrytedPassword=:password and e.enabled=:enabled")
	public Admin getAdminByUser_nameAndPassword(@Param("user_name") String login, @Param("password") String password, @Param("enabled") Boolean enabled);

}
