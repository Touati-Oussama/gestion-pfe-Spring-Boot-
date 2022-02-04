package gestion.pfe.repos;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import gestion.pfe.entities.Soutenance;
import gestion.pfe.models.SoutenanceDTO;

public interface SoutenanceRepository extends JpaRepository<Soutenance, Integer> {

	
	@Query("SELECT e from Soutenance e where e.date like :date and e.Salle=:salle")
	List<Soutenance> findByDateSalle(@Param("date")  LocalDateTime date,@Param("salle") String salle);
	
	@Query("SELECT e from Soutenance e where e.date like :date and (e.presidant.NCEN=:id or e.rapporteur.NCEN=:id)")
	List<Soutenance> findByDateJury(@Param("date")  LocalDateTime date,@Param("id") int id);
	
	
	@Query("SELECT e from Soutenance e where e.sfe.id=:id")
	Soutenance findBySfeId(@Param("id") int id);
	
	
	@Query("SELECT s from Soutenance s join SFE e on (s.sfe = e) join Etudiant et on (e.etudiant = et)  where et.NCET=:id")
	Soutenance findByEtudId(@Param("id") int id);
	
	@Query("SELECT s from Soutenance s join SFE e on (s.sfe = e) join Enseignant en on (e.encadreur = en)  where en.NCEN=:id or s.presidant.id=:id  or s.rapporteur.id=:id")
	List<Soutenance> findByEnId(@Param("id") int id);
	
	
	@Query("SELECT s from Soutenance s join Salle e on (s.Salle = e)  where s.date like :date and e.id=:idSalle")
	List<Soutenance> getByDateSalle(@Param("date")  LocalDateTime date,@Param("idSalle") int idSalle);
	
	@Query("SELECT s from Soutenance s join Salle e on (s.Salle = e)  where  e.id=:idSalle")
	List<Soutenance> getBySalle(@Param("idSalle") int idSalle);
	

}
