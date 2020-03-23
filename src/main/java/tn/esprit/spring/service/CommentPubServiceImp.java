package tn.esprit.spring.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		
		commentpubRepository.save(comment);
		return comment.getId();

	}
	
	public void affecterCommentAPub(Long commentpubId, Long pubId) {
		CommentPub comment = commentpubRepository.findById(commentpubId).get();
		Pub pub = pubRepository.findById(pubId).get();
		comment.setPub(pub);
		commentpubRepository.save(comment);
		
	}
	
}
