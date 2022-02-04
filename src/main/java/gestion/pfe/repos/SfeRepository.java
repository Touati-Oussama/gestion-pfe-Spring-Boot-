package gestion.pfe.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gestion.pfe.entities.Commentaire;
import gestion.pfe.entities.DemandeEncadrement;
import gestion.pfe.entities.Etudiant;
import gestion.pfe.entities.SFE;

public interface SfeRepository extends JpaRepository<SFE, Integer>{

	@Query("select s from Etudiant e join SFE s on s.etudiant = e where e.NCET = ?1")
	SFE findByNCET(int ncet);
	
	
	@Query("Select c from Commentaire c join SFE s on c.sfe = s where s.id = ?1")
	List <Commentaire> getCommentaires(int id);
	
	@Query("SELECT s from SFE s where s.encadreur.id=:id")
	List<SFE> getAllSFEsByEng(@Param("id") int id);
	
	@Query("SELECT s from SFE s where s.etudiant.id=:id")
	SFE getAllSFEsByEtudiant(@Param("id") int id);

}
