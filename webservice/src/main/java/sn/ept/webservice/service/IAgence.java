package sn.ept.webservice.service;

import java.util.List;
import java.util.Optional;

import sn.ept.webservice.model.Agence;


public interface IAgence {
	Agence createAgence(Agence agence);

	List<Agence> getAllAgences();

	Optional<Agence> findByName(String nom);

	Agence save(Agence compte);

	void deleteById(String id);
}
