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

import sn.ept.webservice.model.Compte;
import sn.ept.webservice.service.CompteServiceImpl;

@RestController
@RequestMapping("/wsapi")
public class CompteController {

	CompteServiceImpl compteService;

	@Autowired
	public CompteController(CompteServiceImpl compteService) {
		this.compteService = compteService;
	}

	@GetMapping(value = "/comptes")
	public List<Compte> getAllComptes() {
		return compteService.getAllComptes();
	}

	@GetMapping(value = "/comptes/{id}")
	public Compte getCompteById(@PathVariable("id") int id) throws Exception {
		Compte compte = compteService.findByCustomerId(id)
				.orElseThrow(() -> new Exception("Compte Not Found!"));
		return compte;
	}

	@PostMapping(value = "/comptes")
	public Compte addCompte(@RequestBody Compte compte) {
		return compteService.save(compte);
	}

	@PutMapping(value = "/comptes/{id}")
	public Compte updateCompte(@PathVariable("id") int id, @RequestBody Compte newcpt) throws Exception {
		Compte compte = compteService.findByCustomerId(id)
				.orElseThrow(() -> new Exception("Compte Not Found!"));
		compte.setSolde(newcpt.getSolde());
		compte.setDecouvert(newcpt.getDecouvert());
		return compteService.save(compte);
	}

	@DeleteMapping(value = "/comptes/{id}")
	public String deleteStudent(@PathVariable("id") int id) throws Exception {
		Compte compte = compteService.findByCustomerId(id)
				.orElseThrow(() -> new Exception("Compte Not Found!"));
		compteService.deleteById(compte.getId());
		return "Student with ID :" + id + " is deleted";
	}
}
