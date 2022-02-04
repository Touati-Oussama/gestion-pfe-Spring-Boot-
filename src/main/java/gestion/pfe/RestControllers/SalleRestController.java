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

import gestion.pfe.entities.Etudiant;
import gestion.pfe.entities.Salle;
import gestion.pfe.models.JSONResponse;
import gestion.pfe.services.SalleService;


@RestController
@RequestMapping("/api/salle")
@CrossOrigin
public class SalleRestController {
	@Autowired
	SalleService salleService;
	
	
	
	@RequestMapping(method= RequestMethod.GET)
	List<Salle> getAllSalles(){
		
		return this.salleService.getAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> createEtudiant(@RequestBody Salle salle) {;
		return ResponseEntity.ok(this.salleService.addSalle(salle));
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Salle  getSalleById(@PathVariable("id") int id)
	{
		return this.salleService.getSalle(id);
	}
	
	@RequestMapping(value="/nom/{nom}",method = RequestMethod.GET)
	public Salle  getNom(@PathVariable("nom") String salle)
	{
		return this.salleService.getByNom(salle);
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<?> updateEtudiant(@RequestBody Salle s, @PathVariable("id") int id ) {
		Salle salle = this.salleService.getSalle(id);
		salle.setNom(s.getNom());
		return ResponseEntity.ok(this.salleService.updateSalle(salle));
	}
	
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteSalle(@PathVariable("id") int id) {
		Salle s = this.salleService.getSalle(id);
		JSONResponse res = new JSONResponse();
		
		res.setSuccess(true);
		this.salleService.deleteSalle(s);
		return ResponseEntity.ok(res);
	}
	
}
