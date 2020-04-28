package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Jackpot;
import tn.esprit.spring.service.JackpotService;

@RestController
public class JackpotRestController {
	@Autowired
	JackpotService js;

	@GetMapping("/retrieve-all-jackpots")
	@ResponseBody
	public List<Jackpot> getJackpots() {
		List<Jackpot> list = js.retrieveAllJackpots();
		return list;
	}

	// Ajouter Event : http://localhost:8080/SpringMVC/servlet/add-jackpot
	@PostMapping("/add-jackpot")
	@ResponseBody
	public Jackpot addJackpot(@RequestBody Jackpot j) {
		Jackpot jackpot = js.addJackpot(j);
		return jackpot;
	}

	// http://localhost:8081/SpringMVC/servlet/update-jackpot
	@PutMapping("/update-jackpot")
	@ResponseBody
	public Jackpot updateJackpot(@RequestBody Jackpot j) {
		return js.updateJackpot(j);
	}

	// http://localhost:8081/SpringMVC/servlet/remove-event/{jackpot-id}
	@DeleteMapping("/delete-jackpot/{jackpot-id}")
	@ResponseBody
	public void deleteJackpot(@PathVariable("jackpot-id") int jpId) {
		js.deleteJackpot(jpId);
	}

	// http://localhost:8081/SpringMVC/servlet/retrieve-jackpot/{jackpot-id}
	@GetMapping("/retrieve-jackpot/{jackpot-id}")
	@ResponseBody
	public Jackpot retrieveJackpot(@PathVariable("jackpot-id") int jpId) {
		return js.retrieveJackpot(jpId);
	}

}
