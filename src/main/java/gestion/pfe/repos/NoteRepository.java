package gestion.pfe.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gestion.pfe.entities.Note;
import gestion.pfe.entities.Soutenance;


public interface NoteRepository extends JpaRepository<Note, Integer> {

	@Query("SELECT n  from Note n join  Soutenance s on (n.soutenance = s) join SFE e on (s.sfe = e) join Etudiant et on (e.etudiant = et)  where et.NCET=:id")
	Note findByEtudId(@Param("id") int id);
	
	@Query("SELECT n  from Note n join  Soutenance s on (n.soutenance = s) where s.id=:id")
	Note findBySoutenance(@Param("id") int id);
}
