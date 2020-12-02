package sn.ept.webservice.service;

import java.util.List;
import java.util.Optional;

import sn.ept.webservice.model.Compte;

public interface ICompte {
	Compte createCompte(Compte compte);

	List<Compte> getAllComptes();

	Optional<Compte> findByCustomerId(int customer_id);

	Compte save(Compte compte);

	void deleteById(int id);
}
