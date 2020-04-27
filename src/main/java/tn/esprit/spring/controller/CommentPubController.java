package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.CommentPub;
import tn.esprit.spring.service.ICommentPubService;
import tn.esprit.spring.service.IPubService;


@RestController
public class CommentPubController {
	@Autowired
	IPubService ipubservice ;
	@Autowired
	ICommentPubService icommentservice ; 
	
	
	@PostMapping("/addComment")
	@ResponseBody
	public Long addComment(@RequestBody CommentPub comment) {
		icommentservice.addComment(comment);
		return comment.getId();
	}

	// http://localhost:8081/SpringMVC/servlet/affecterCommentAPub/4/4
	@PutMapping(value = "/affecterCommentAPub/{idcomment}/{idpub}") 
	public void affecterCommentAPub(@PathVariable("idcomment") Long commentpubId, @PathVariable("idpub") Long pubId) {
		icommentservice.affecterCommentAPub(commentpubId, pubId);

	}
	
	 @DeleteMapping("/deleteCommentById/{idcomment}") 
		@ResponseBody 
		public void deleteCommentById(@PathVariable("idcomment")Long commentId)
		{
			icommentservice.deleteCommentById(commentId);
		} 
		
	 @PutMapping(value = "/modifyComment/{id}/{newcomment}") 
		@ResponseBody
		public void mettreAjourCommentByCommentId(@PathVariable("newcomment") String description, @PathVariable("id") Long commentId) {
			icommentservice.mettreAjourCommentByCommentId(description, commentId);
			
		}
	 
	 @PutMapping(value = "/like/{id}") 
		@ResponseBody
		public void LikeByCommentId( @PathVariable("id") Long commentId) {
			icommentservice.LikeByCommentId(commentId);
			
		}
	 
	 @PutMapping(value = "/nodislike/{id}") 
		@ResponseBody
		public void NoDislikeByCommentId( @PathVariable("id") Long commentId) {
			icommentservice.NoDislikeByCommentId(commentId);
			
		}
	 
	 @PutMapping(value = "/nolike/{id}") 
		@ResponseBody
		public void NoLikeByCommentId( @PathVariable("id") Long commentId) {
			icommentservice.NoLikeByCommentId(commentId);
			
		}
	 
	 @PutMapping(value = "/dislike/{id}") 
		@ResponseBody
		public void DislikeByCommentId( @PathVariable("id") Long commentId) {
			icommentservice.DislikeByCommentId(commentId);
			
		}
	 
	 
	 
	 
	    // URL : http://localhost:8081/SpringMVC/servlet/deleteBadJPQL
	    @DeleteMapping("/deleteBadJPQL") 
		@ResponseBody
		public void deleteBadJPQL() {
			icommentservice.deleteBadJPQL();
			
		}
		@PostMapping("/addCommentg")
		@ResponseBody
		public Long addCommentWithoutBadWords(@RequestBody CommentPub comment) {
			icommentservice.addComment(comment);
			icommentservice.deleteBadJPQL();
			return null ;
			
		}
	
}
