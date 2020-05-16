package tn.esprit.spring.service;

import java.util.List;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.entity.Pub;

import tn.esprit.spring.repository.PubRepository;
@Service
public class PubServiceImp implements IPubService {

@Autowired
PubRepository pubRepository;

private static final Logger L =LogManager.getLogger(PubServiceImp.class);


@Override
public List<Pub> retrieveAllPub()
{
List<Pub> pubs = (List<Pub>) pubRepository.findAll();
for (Pub pub : pubs)
	{L.info("pub +++ :" + pub);
	}
return pubs;	
}

public Long addPub(Pub pub) {
	pub.setRating(1);
	pub.setViews(1);
	pubRepository.save(pub);
	return pub.getId();

}
@Transactional
public void deletePubById(Long pubId) {
	pubRepository.delete(pubRepository.findById(pubId).get());
}
public void mettreAjourRatingByPubId(Integer rating, Long PubId ) {
	Pub pub = pubRepository.findById(PubId).get();
	Integer i = 1 ;
	Integer	j =pub.getRating()+rating;
	i++ ;
	Integer x=j/i;
	pub.setRating(x);
	pubRepository.save(pub);

}
public Pub getPubById(Long pubId) {
	Pub pub = pubRepository.findById(pubId).get();
	pub.setViews((pub.getViews())+1);
	pubRepository.save(pub);
	return pub;
}


public List<Pub> TopViewsJPQL() {
	return pubRepository.TopViewsJPQL();
}

@Override
public void deletePubsWithNoInteractionJPQL() {
	pubRepository.deletePubsWithNoInteractionJPQL();
	
}
// @Scheduled(cron = "0/15 * * * * *")
public void deleteAutoJPQL(){
	pubRepository.deleteAutoJPQL();
	System.out.println("done");
}

}
