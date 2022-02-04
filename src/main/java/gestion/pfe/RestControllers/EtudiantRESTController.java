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
import gestion.pfe.models.JSONResponse;
import gestion.pfe.services.EtudiantService;

@RestController
@RequestMapping("/api/etudiant")
@CrossOrigin
public class EtudiantRESTController {
	
	@Autowired
	EtudiantService etudiantService;
	
	
	
	@RequestMapping(method= RequestMethod.GET)
	List<Etudiant> getAllEtudiants(){
		
		return etudiantService.getAllEtudiants();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Etudiant  getEtudiantById(@PathVariable("id") int id)
	{
		return etudiantService.getEtudiant(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> createEtudiant(@RequestBody Etudiant etudiant) {;
		return ResponseEntity.ok(etudiantService.saveEtudiant(etudiant));
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<?> updateEtudiant(@RequestBody Etudiant etudiant, @PathVariable("id") int id ) {
		Etudiant e = this.etudiantService.getEtudiant(id);
		e.setNom(etudiant.getNom());
		e.setPrenom(etudiant.getPrenom());
		e.setEmail(etudiant.getEmail());
		e.setPassword(etudiant.getPassword());
		e.setTelephone(etudiant.getTelephone());
		return ResponseEntity.ok(etudiantService.updateEtudiant(e));
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEtudiant(@PathVariable("id") int id) {
		Etudiant e = this.etudiantService.getEtudiant(id);
		JSONResponse res = new JSONResponse();
		
		res.setSuccess(true);
		this.etudiantService.deleteEtudiant(e);
		return ResponseEntity.ok(res);
	}
	
	@RequestMapping( value="/findBySfe/{nom}",method = RequestMethod.GET)
	public Etudiant findBySfe(@PathVariable("nom") String nom) {
		return etudiantService.findBySfe(nom);
	}
	


}
