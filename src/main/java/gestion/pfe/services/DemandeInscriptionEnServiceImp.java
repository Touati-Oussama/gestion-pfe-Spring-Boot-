package gestion.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.pfe.entities.DemandeInscription;
import gestion.pfe.entities.DemandeInscriptionEn;
import gestion.pfe.repos.DemandeInscriptionEnRepository;
import gestion.pfe.repos.DemandeInscriptionRepository;

@Service
public class DemandeInscriptionEnServiceImp implements DemandeInscriptionEnService{

	@Autowired
	DemandeInscriptionEnRepository demandeInscriptionEnRepository;
	
	@Override
	public DemandeInscriptionEn saveDemandeInscriptionEn(DemandeInscriptionEn e) {
		// TODO Auto-generated method stub
		return demandeInscriptionEnRepository.save(e);
	}

	@Override
	public DemandeInscriptionEn updateDemandeInscriptionEn(DemandeInscriptionEn e) {
		// TODO Auto-generated method stub
		return demandeInscriptionEnRepository.save(e);
	}

	@Override
	public void deleteDemandeInscriptionEn(DemandeInscriptionEn e) {
		demandeInscriptionEnRepository.delete(e);
		
	}

	@Override
	public List<DemandeInscriptionEn> getAllDemandeInscriptionEns() {
		// TODO Auto-generated method stub
		return demandeInscriptionEnRepository.findAll();
	}

	@Override
	public void deleteDemandeInscriptionEnById(int id) {
		demandeInscriptionEnRepository.deleteById(id);
	}

	@Override
	public DemandeInscriptionEn getDemandeInscriptionEn(int id) {
		// TODO Auto-generated method stub
		return demandeInscriptionEnRepository.findById(id).get();
	}

}
