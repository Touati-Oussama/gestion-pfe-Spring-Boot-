package gestion.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.pfe.entities.Enseignant;
import gestion.pfe.repos.EnseignantRepository;

@Service
public class EnseignantServiceImp implements EnseignantService{

	@Autowired
	EnseignantRepository enseignantRepository;

	@Override
	public Enseignant saveEnseignant(Enseignant e) {
		// TODO Auto-generated method stub
		return enseignantRepository.save(e);
	}

	@Override
	public Enseignant updateEnseignant(Enseignant e) {
		// TODO Auto-generated method stub
		return enseignantRepository.save(e);
	}

	@Override
	public void deleteEnseignant(Enseignant e) {
		enseignantRepository.delete(e);
		
	}

	@Override
	public List<Enseignant> getAllEnseignants() {
		// TODO Auto-generated method stub
		return enseignantRepository.findAll();
	}

	@Override
	public void deleteEnseignantById(int id) {
		enseignantRepository.deleteById(id);
	}

	@Override
	public Enseignant getEnseignant(int id) {
		// TODO Auto-generated method stub
		return enseignantRepository.getByNCEN(id);
	}
}
