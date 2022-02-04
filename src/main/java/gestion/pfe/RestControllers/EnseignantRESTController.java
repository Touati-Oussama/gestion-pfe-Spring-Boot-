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


import gestion.pfe.entities.Enseignant;
import gestion.pfe.models.JSONResponse;
import gestion.pfe.services.EnseignantService;


@RestController
@RequestMapping("/api/enseignant")
@CrossOrigin
public class EnseignantRESTController {
	
	@Autowired
	EnseignantService enseignantService;
	
	
	
	@RequestMapping(method= RequestMethod.GET)
	List<Enseignant> getAllEnseignants(){
		
		return enseignantService.getAllEnseignants();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Enseignant getEnseignantById(@PathVariable("id") int id)
	{
		return this.enseignantService.getEnseignant(id) ;
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public 	ResponseEntity<?> createEnseignant(@RequestBody Enseignant Enseignant) {
		
		return ResponseEntity.ok(enseignantService.saveEnseignant(Enseignant));
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<?> updateEnseignant(@RequestBody Enseignant enseignant, @PathVariable("id") int id ) {
		Enseignant e = this.enseignantService.getEnseignant(id);
		e.setNom(enseignant.getNom());
		e.setPrenom(enseignant.getPrenom());
		e.setTelephone(enseignant.getTelephone());
		e.setEmail(enseignant.getEmail());
		e.setPassword(enseignant.getPassword());
		return ResponseEntity.ok(enseignantService.updateEnseignant(e));
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEnseignant(@PathVariable("id") int id) {
		Enseignant e = this.enseignantService.getEnseignant(id);
		JSONResponse res = new JSONResponse();
		
		res.setSuccess(true);
		enseignantService.deleteEnseignant(e);
		return ResponseEntity.ok(res);
	}

}
