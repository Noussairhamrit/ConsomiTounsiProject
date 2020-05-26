package tn.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.AppUser;
import tn.esprit.spring.entity.Publicite;
import tn.esprit.spring.entity.UsersViews;

public interface UserViewsRepository extends JpaRepository< UsersViews,Long> {
//	@Query("select up from UsersViews up "
//			+ " where up.user=:user and "
//			+ "up.product =:product" )
//	Optional <UsersViews> getUserViews(@Param("user")AppUser user,@Param("product")Publicite publicite);
//	
//	List<UsersViews>findAllByUserAndProduct(AppUser user,Publicite product);

}
