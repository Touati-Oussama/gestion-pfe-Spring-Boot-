package gestion.pfe.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gestion.pfe.entities.Note;
import gestion.pfe.entities.Salle;

public interface SalleRepository extends JpaRepository<Salle, Integer> {

	Salle findByNom(String nom);
	
}
