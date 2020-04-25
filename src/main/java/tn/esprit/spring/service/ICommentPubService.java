package tn.esprit.spring.service;

import tn.esprit.spring.entity.CommentPub;

public interface ICommentPubService {
	public Long addComment(CommentPub comment);
	public void affecterCommentAPub(Long commentpubId, Long pubId);
	public void deleteCommentById(Long commentId);
	public void mettreAjourCommentByCommentId(String description, Long CommentId );
	public void LikeByCommentId(Long CommentId );
	public void DislikeByCommentId(Long CommentId );
	public void NoLikeByCommentId(Long CommentId );
	public void NoDislikeByCommentId(Long CommentId );
	public void deleteBadJPQL();
}
