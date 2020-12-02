package sn.ept.webservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.ept.webservice.model.Agence;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Integer> {

	// Query method
	Optional<Agence> findByName(String nom);
	
	//Optional<Agence> deleteById(String nom);
}
