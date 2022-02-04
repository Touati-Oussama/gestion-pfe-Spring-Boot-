package gestion.pfe.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import gestion.pfe.entities.Enseignant;

public interface EnseignantRepository extends JpaRepository<Enseignant, Integer> {

	/*@Query("select e from Etudiant e join SFE s on s.etudiant = e where s.sujet = ?1")*/
	Enseignant getByNCEN(int ncen);
}
