package gestion.pfe.services;

import java.util.List;

import gestion.pfe.entities.DemandeInscription;



public interface DemandeInscriptionService {

	DemandeInscription saveDemandeInscription(DemandeInscription e);
	DemandeInscription updateDemandeInscription(DemandeInscription e);
	void deleteDemandeInscription(DemandeInscription e);
	void deleteDemandeInscriptionById(int id);
	DemandeInscription getDemandeInscription(int id);
	List<DemandeInscription> getAllDemandeInscriptions();

}
