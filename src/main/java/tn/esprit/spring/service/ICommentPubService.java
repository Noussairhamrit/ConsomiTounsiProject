package tn.esprit.spring.service;

import tn.esprit.spring.entity.CommentPub;

public interface ICommentPubService {
	public Long addComment(CommentPub comment);
	public void affecterCommentAPub(Long commentpubId, Long pubId);
}
