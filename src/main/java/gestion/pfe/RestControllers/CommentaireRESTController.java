package gestion.pfe.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import gestion.pfe.entities.Commentaire;
import gestion.pfe.models.CommentaireModel;
import gestion.pfe.services.CommentaireService;
import gestion.pfe.services.EnseignantService;
import gestion.pfe.services.SfeService;

@RestController
@RequestMapping("/api/Commentaire")
@CrossOrigin
public class CommentaireRESTController {
	
	@Autowired
	CommentaireService commentaireService;
	
	@Autowired
	SfeService sfeService;
	
	@Autowired
	EnseignantService encadreurService;
	
	
	
	@RequestMapping(method= RequestMethod.GET)
	List<CommentaireModel> getAllCommentaires(){
		
		return commentaireService.getAllCommentaires();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Commentaire  getCommentaireById(@PathVariable("id") int id)
	{
		return commentaireService.getCommentaire(id);
	}
	
	
	@PostMapping("/add/{sfeId}")
	public 	ResponseEntity<?> createCommentaire(@RequestBody Commentaire commentaire, @PathVariable("sfeId") int sfe) {
		
		commentaire.setSfe(sfeService.getSFE(sfe));
		
		return ResponseEntity.ok(commentaireService.saveCommentaire(commentaire));
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Commentaire updateCommentaire(@RequestBody Commentaire Commentaire) {
		
		return commentaireService.updateCommentaire(Commentaire);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void deleteCommentaire(@PathVariable("id") int id) {
		commentaireService.deleteCommentaireById(id);
	}
	
    @RequestMapping(value="/sfe/{id}",method = RequestMethod.GET)
    public List <CommentaireModel> getCommentairesBySFE(@PathVariable("id") int id){
    	return commentaireService.getCommentairesBySFE(id);
    }
	


}