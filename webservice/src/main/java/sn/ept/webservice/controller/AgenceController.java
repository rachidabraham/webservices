package sn.ept.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.ept.webservice.model.Agence;
import sn.ept.webservice.service.AgenceServiceImpl;

@RestController
@RequestMapping("/customer")
public class AgenceController {

	AgenceServiceImpl agenceService;

	@Autowired
	public  AgenceController(AgenceServiceImpl agenceService) {
		// TODO Auto-generated constructor stub
		this.agenceService = agenceService;
	}

	@GetMapping(value = "/agences")
	public List<Agence> getAllAgences() {
		return agenceService.getAllAgences();
	}

	@GetMapping(value = "/agences/{nom}")
	public Agence getAgenceById(@PathVariable("nom") String nom) throws Exception {
		Agence agence = agenceService.findByName(nom)
				.orElseThrow(() -> new Exception("Agence" + nom + " is Not Found!"));
		return agence;
	}

	@PostMapping(value = "/agences")
	public Agence addAgence(@RequestBody Agence agence) {
		return agenceService.save(agence);
	}

	@PutMapping(value = "/agences/{nom}")
	public Agence updateAgence(@PathVariable("nom")String nom, @RequestBody Agence newage) throws Exception {
		Agence agence = agenceService.findByName(nom)
				.orElseThrow(() -> new Exception("Agence " + nom + " is Not Found!"));
		agence.setNom(newage.getNom());
		agence.setAdresse(newage.getAdresse());
		agence.setTelephone(newage.getTelephone());
		return agenceService.save(agence);
	}

	/*
	@DeleteMapping(value = "/agences/{nom}")
	public String deleteStudent(@PathVariable("nom") String nom) throws Exception {
		Agence agence = agenceService.findByName(nom)
				.orElseThrow(() -> new Exception("Student " + nom + " is Not Found!"));
		agenceService.deleteById(agence.getCode());
		return "Agence :" + nom + " is deleted";
	}
	*/
}
