package tn.esprit.spring.service;

import java.util.List;


import tn.esprit.spring.entity.Pub;


public interface IPubService {
	public Long addPub(Pub pub);
	List<Pub> retrieveAllPub();
	public void deletePubById(Long pubId);
	public void mettreAjourRatingByPubId(Integer rating, Long PubId );
}
