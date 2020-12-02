package sn.ept.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.ept.webservice.model.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {

}