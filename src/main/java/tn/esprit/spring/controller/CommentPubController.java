package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
}
