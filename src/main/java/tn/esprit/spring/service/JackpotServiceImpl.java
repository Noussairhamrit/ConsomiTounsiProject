package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Jackpot;

import tn.esprit.spring.repository.JackpotRepository;

@Service
public class JackpotServiceImpl implements JackpotService {

	@Autowired
	JackpotRepository jackpotRepository;

	private static final Logger L = LogManager.getLogger(JackpotServiceImpl.class);

	@Override
	public List<Jackpot> retrieveAllJackpots() {
		List<Jackpot> jackpots = (List<Jackpot>) jackpotRepository.findAll();
		for (Jackpot jackpot : jackpots) {
			L.info("jackpot +++ : " + jackpot);
		}
		return jackpots;
	}

	@Override
	public Jackpot addJackpot(Jackpot j) {
		return jackpotRepository.save(j);

	}

	@Override
	public Jackpot updateJackpot(Jackpot j) {
		return jackpotRepository.save(j);

	}

	@Override
	public void deleteJackpot(int jpId) {
		jackpotRepository.deleteById(jpId);

	}

	@Override
	public Jackpot retrieveJackpot(int jpId) {
		Jackpot j;
		j = jackpotRepository.findById(jpId).get();
		return j;
	}

}
