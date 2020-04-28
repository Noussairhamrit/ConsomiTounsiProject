package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tn.esprit.spring.repository.PieChartRepository;
import tn.esprit.spring.entity.Livreur;
@Controller
public class PieChartController {
	@Autowired
	PieChartRepository pieChartRepository;

	@RequestMapping("/piechart")
	public ResponseEntity<?> getPiechart() {
		List<Livreur> livreurs = pieChartRepository.findAll();
		return new ResponseEntity<>(livreurs, HttpStatus.OK);

	}
}
 