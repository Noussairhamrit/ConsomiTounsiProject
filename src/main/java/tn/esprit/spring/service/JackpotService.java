package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Jackpot;

public interface JackpotService {

	Jackpot addJackpot(Jackpot j);

	Jackpot updateJackpot(Jackpot j);

	void deleteJackpot(int jpId);

	Jackpot retrieveJackpot(int jpId);

	List<Jackpot> retrieveAllJackpots();

}
