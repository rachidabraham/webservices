package sn.ept.webservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.ept.webservice.model.Agence;
import sn.ept.webservice.repository.AgenceRepository;

@Service
public class AgenceServiceImpl implements IAgence {

	AgenceRepository agenceRepository;

	@Autowired
	public AgenceServiceImpl(AgenceRepository agenceRepository) {
		// TODO Auto-generated constructor stub
		this.agenceRepository = agenceRepository;
	}

	@Override
	public Agence createAgence(Agence agence) {
		// TODO Auto-generated method stub
		return agenceRepository.save(agence);
	}

	@Override
	public List<Agence> getAllAgences() {
		// TODO Auto-generated method stub
		return agenceRepository.findAll();
	}

	@Override
	public Optional<Agence> findByName(String nom) {
		// TODO Auto-generated method stub
		return agenceRepository.findByName(nom);
	}

	@Override
	public Agence save(Agence agence) {
		// TODO Auto-generated method stub
		return agenceRepository.save(agence);
	}

	/*
	@Override
	public void deleteById(String code) {
		// TODO Auto-generated method stub
		agenceRepository.deleteById(code);
	}*/

}
