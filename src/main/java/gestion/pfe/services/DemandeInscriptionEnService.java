package gestion.pfe.services;

import java.util.List;

import gestion.pfe.entities.DemandeInscriptionEn;

public interface DemandeInscriptionEnService {

	DemandeInscriptionEn saveDemandeInscriptionEn(DemandeInscriptionEn e);
	DemandeInscriptionEn updateDemandeInscriptionEn(DemandeInscriptionEn e);
	void deleteDemandeInscriptionEn(DemandeInscriptionEn e);
	void deleteDemandeInscriptionEnById(int id);
	DemandeInscriptionEn getDemandeInscriptionEn(int id);
	List<DemandeInscriptionEn> getAllDemandeInscriptionEns();
}
