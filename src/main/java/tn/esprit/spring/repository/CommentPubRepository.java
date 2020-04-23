package tn.esprit.spring.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import tn.esprit.spring.entity.CommentPub;
import tn.esprit.spring.entity.Pub;
public interface CommentPubRepository extends CrudRepository<CommentPub, Long> {
    @Modifying
    @Transactional
    @Query("DELETE from CommentPub c where c.description='***'")
    public void deleteBadJPQL();


}
