package gestion.pfe.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gestion.pfe.RestControllers.test;
import gestion.pfe.entities.DemandeEncadrement;
import gestion.pfe.entities.Enseignant;
import gestion.pfe.entities.Etudiant;


@Repository
public interface DemnadeEncadrementRepos extends JpaRepository<DemandeEncadrement, Integer> {
	@Transactional
	@Modifying
	
	@Query("DELETE from DemandeEncadrement e where e.etudiant =:etud and e.encadreur=:encad")
	int deleteDemande(@Param("etud") Etudiant etud,@Param("encad") Enseignant encad);

	@Query("SELECT d from DemandeEncadrement d where d.etudiant.id=:id")
	List<DemandeEncadrement> getByEtudId(@Param("id") int id);
	
	@Query("DELETE from DemandeEncadrement d where d.etudiant.id=:id")
	List<DemandeEncadrement> deleteByEtudId(@Param("id") int id);
	
	@Query("DELETE from DemandeEncadrement d where d.id=:id")
	void deleteById(@Param("id") int id);

	@Query("SELECT d from DemandeEncadrement d where d.encadreur.id=:id")
	List<DemandeEncadrement> getByEnId(@Param("id") int id);

	
	@Query("SELECT d from DemandeEncadrement d where d.etudiant.id=:idEtud and d.encadreur.id =:idEns")
	List<DemandeEncadrement> getByIds(@Param("idEtud") int idEtud, @Param("idEns") int idEns);
}
