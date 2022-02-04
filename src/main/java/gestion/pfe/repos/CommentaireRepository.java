package gestion.pfe.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gestion.pfe.entities.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {

	@Query("select c from Commentaire c where c.sfe.id=:id")
	List <Commentaire> getCommentairesBySFE(@Param("id") int id);
}
