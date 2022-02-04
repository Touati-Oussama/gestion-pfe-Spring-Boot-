package gestion.pfe.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



import gestion.pfe.entities.Etudiant;
import gestion.pfe.entities.SFE;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

	
	@Query("select e from Etudiant e join SFE s on s.etudiant = e where s.sujet = ?1")
	Etudiant findBySfe(String msg);
}
