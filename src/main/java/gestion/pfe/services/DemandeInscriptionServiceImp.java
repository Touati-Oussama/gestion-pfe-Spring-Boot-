package gestion.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.pfe.entities.DemandeInscription;
import gestion.pfe.repos.DemandeInscriptionRepository;

@Service
public class DemandeInscriptionServiceImp implements DemandeInscriptionService{

	@Autowired
	DemandeInscriptionRepository demandeInscriptionRepository;
	
	@Override
	public DemandeInscription saveDemandeInscription(DemandeInscription e) {
		// TODO Auto-generated method stub
		return demandeInscriptionRepository.save(e);
	}

	@Override
	public DemandeInscription updateDemandeInscription(DemandeInscription e) {
		// TODO Auto-generated method stub
		return demandeInscriptionRepository.save(e);
	}

	@Override
	public void deleteDemandeInscription(DemandeInscription e) {
		demandeInscriptionRepository.delete(e);
		
	}

	@Override
	public List<DemandeInscription> getAllDemandeInscriptions() {
		// TODO Auto-generated method stub
		return demandeInscriptionRepository.findAll();
	}

	@Override
	public void deleteDemandeInscriptionById(int id) {
		demandeInscriptionRepository.deleteById(id);
	}

	@Override
	public DemandeInscription getDemandeInscription(int id) {
		// TODO Auto-generated method stub
		return demandeInscriptionRepository.findById(id).get();
	}

}
