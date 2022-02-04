package gestion.pfe.services;

import java.util.List;



import gestion.pfe.entities.Etudiant;

public interface EtudiantService {

	Etudiant saveEtudiant(Etudiant e);
	Etudiant updateEtudiant(Etudiant e);
	void deleteEtudiant(Etudiant e);
	void deleteEtudiantById(int id);
	Etudiant getEtudiant(int id);
	List<Etudiant> getAllEtudiants();

	Etudiant findBySfe(String msg);
	/*
	List<Etudiant> findByNomEtudiant(String nom);
	List<Etudiant> findByNomEtudiantContains(String nom);
	List<Etudiant> findByCategorieIdCat(Long id);
	List<Etudiant> findByOrderByNomEtudiantAsc();
	*/

}
