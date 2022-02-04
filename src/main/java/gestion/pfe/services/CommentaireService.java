package gestion.pfe.services;

import java.util.List;



import gestion.pfe.entities.Commentaire;
import gestion.pfe.models.CommentaireModel;

public interface CommentaireService {

	Commentaire saveCommentaire(Commentaire e);
	Commentaire updateCommentaire(Commentaire e);
	void deleteCommentaire(Commentaire e);
	void deleteCommentaireById(int id);
	Commentaire getCommentaire(int id);
	List<CommentaireModel> getAllCommentaires();
	List<CommentaireModel> getCommentairesBySFE(int id);
	
}
