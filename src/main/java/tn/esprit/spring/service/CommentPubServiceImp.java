package tn.esprit.spring.service;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.CommentPub;
import tn.esprit.spring.entity.Pub;
import tn.esprit.spring.repository.CommentPubRepository;
import tn.esprit.spring.repository.PubRepository;
@Service
public class CommentPubServiceImp implements ICommentPubService {
	@Autowired
	PubRepository pubRepository;
	@Autowired
	CommentPubRepository commentpubRepository;
	
	

	public Long addComment(CommentPub comment) {
		String badwords[] = new String[] { 
				  "bad", "words", "bads" };
		String commentWords[] = comment.getDescription().split(" ");
		
		 for(String a : commentWords){
			 for(String b : badwords){
			 
		if (b.contains(a))
		{
			comment.setDescription("***");
			comment.setLikes(0);
			comment.setDislike(0);
			comment.setDate(new Date());
			
		}
		else
		{
			comment.setLikes(0);
			comment.setDislike(0);
			comment.setDate(new Date());
			commentpubRepository.save(comment);
			
					}}}

		 return comment.getId();
	}
	
	public void affecterCommentAPub(Long commentpubId, Long pubId) {
		CommentPub comment = commentpubRepository.findById(commentpubId).get();
		Pub pub = pubRepository.findById(pubId).get();
		comment.setPub(pub);
		commentpubRepository.save(comment);
		
	}
	@Transactional
	public void deleteCommentById(Long commentId) {
		commentpubRepository.delete(commentpubRepository.findById(commentId).get());
	}
	
	public void mettreAjourCommentByCommentId(String description, Long CommentId ) {
		CommentPub comment = commentpubRepository.findById(CommentId).get();
		comment.setDescription(description);
		commentpubRepository.save(comment);

	}
	public void LikeByCommentId(Long CommentId ) {
		CommentPub comment = commentpubRepository.findById(CommentId).get();
		Integer x= comment.getLikes();
		comment.setLikes(x+1);
		commentpubRepository.save(comment);

	}
	
	public void DislikeByCommentId(Long CommentId ) {
		CommentPub comment = commentpubRepository.findById(CommentId).get();
		Integer x= comment.getDislike();
		comment.setDislike(x+1);
		commentpubRepository.save(comment);

	}
	
	public void NoLikeByCommentId(Long CommentId ) {
		CommentPub comment = commentpubRepository.findById(CommentId).get();
		Integer x= comment.getLikes();
		comment.setLikes(x-1);
		commentpubRepository.save(comment);

	}
	
	public void NoDislikeByCommentId(Long CommentId ) {
		CommentPub comment = commentpubRepository.findById(CommentId).get();
		Integer x= comment.getDislike();
		comment.setDislike(x-1);
		commentpubRepository.save(comment);

	}
	
	public void deleteBadJPQL() {
        commentpubRepository.deleteBadJPQL();
	}
	
}
