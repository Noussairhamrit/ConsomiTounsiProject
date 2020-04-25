package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import tn.esprit.spring.entity.Jackpot;

import tn.esprit.spring.service.JackpotServiceImpl;

@Controller
public class JackpotControl {
	@Autowired
	JackpotServiceImpl js;
	
	@RequestMapping(value = "//", method= RequestMethod.GET)
	public String jackpots(Jackpot jackpot, Model model) {
	model.addAttribute("jackpot", new Jackpot());
	model.addAttribute("jackpots", js.retrieveAllJackpots());
	return"jackpots";
	}
}
