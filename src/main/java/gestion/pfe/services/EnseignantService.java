package gestion.pfe.services;

import java.util.List;

import gestion.pfe.entities.Enseignant;

public interface EnseignantService {

	Enseignant saveEnseignant(Enseignant e);
	Enseignant updateEnseignant(Enseignant e);
	void deleteEnseignant(Enseignant e);
	void deleteEnseignantById(int id);
	Enseignant getEnseignant(int id);
	List<Enseignant> getAllEnseignants();
}
