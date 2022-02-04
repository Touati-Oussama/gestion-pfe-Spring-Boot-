package gestion.pfe.services;

import java.util.List;

import gestion.pfe.entities.Commentaire;
import gestion.pfe.entities.SFE;
import gestion.pfe.models.DemandeEnDTO;
import gestion.pfe.models.sfeModel;

public interface SfeService {

	
	SFE saveSFE(SFE e);
	SFE updateSFE(SFE e);
	void deleteSFE(SFE e);
	void deleteSFEById(int id);
	SFE getSFE(int id);
	sfeModel getSFEById(int id);
	List<DemandeEnDTO> getAllSFEsByEng(int id);
	SFE findByNCET(int ncet);
	List <Commentaire> getCommentaires(int id);
	DemandeEnDTO getAllSFEsByEtudiant(int id);
	List <sfeModel> getAll();
}
