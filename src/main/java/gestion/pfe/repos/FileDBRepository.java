package gestion.pfe.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gestion.pfe.entities.FileDB;
import gestion.pfe.entities.SFE;

public interface FileDBRepository extends JpaRepository<FileDB, String> {

	@Query("select f from Etudiant e join FileDB f on f.etudiant = e where e.NCET = ?1")
	List<FileDB> findByNCET(int ncet);
	
	@Query("select f from Etudiant e join FileDB f on f.etudiant = e where e.NCET = ?1")
	FileDB get(int ncet);
	
	@Query("SELECT f from SFE s join FileDB f on (s.etudiant = f.etudiant) where s.id=:id")
	FileDB getBySfe(@Param("id") int id);
}

