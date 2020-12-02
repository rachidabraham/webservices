package sn.ept.webservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.ept.webservice.model.Compte;
import sn.ept.webservice.repository.CompteRepository;

@Service
public class CompteServiceImpl implements ICompte {

	CompteRepository compteRepository;

	@Autowired
	public CompteServiceImpl(CompteRepository compteRepository) {
		// TODO Auto-generated constructor stub
		this.compteRepository = compteRepository;
	}

	@Override
	public Compte createCompte(Compte compte) {
		// TODO Auto-generated method stub
		return compteRepository.save(compte);
	}

	@Override
	public List<Compte> getAllComptes() {
		// TODO Auto-generated method stub
		return compteRepository.findAll();
	}

	@Override
	public Optional<Compte> findByCustomerId(int customer_id) {
		// TODO Auto-generated method stub
		return compteRepository.findById(customer_id);
	}

	@Override
	public Compte save(Compte compte) {
		// TODO Auto-generated method stub
		return compteRepository.save(compte);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		compteRepository.deleteById(id);
	}

}
