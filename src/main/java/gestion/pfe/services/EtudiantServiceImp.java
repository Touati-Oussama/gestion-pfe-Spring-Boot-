package gestion.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.pfe.entities.Etudiant;
import gestion.pfe.repos.EtudiantRepository;

@Service
public class EtudiantServiceImp implements EtudiantService{

	@Autowired
	EtudiantRepository etudiantRepository;

	@Override
	public Etudiant saveEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		return etudiantRepository.save(e);
	}

	@Override
	public Etudiant updateEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		return etudiantRepository.save(e);
	}

	@Override
	public void deleteEtudiant(Etudiant e) {
		etudiantRepository.delete(e);
		
	}

	@Override
	public List<Etudiant> getAllEtudiants() {
		// TODO Auto-generated method stub
		return etudiantRepository.findAll();
	}

	@Override
	public void deleteEtudiantById(int id) {
		etudiantRepository.deleteById(id);
	}

	@Override
	public Etudiant getEtudiant(int id) {
		// TODO Auto-generated method stub
		return etudiantRepository.findById(id).get();
	}

	@Override
	public Etudiant findBySfe(String msg) {
		return etudiantRepository.findBySfe(msg);
	}
	
}

	

