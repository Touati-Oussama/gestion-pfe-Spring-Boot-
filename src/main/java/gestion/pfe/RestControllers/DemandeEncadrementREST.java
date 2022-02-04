package gestion.pfe.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gestion.pfe.entities.DemandeEncadrement;
import gestion.pfe.entities.Enseignant;
import gestion.pfe.entities.Etudiant;
import gestion.pfe.entities.SFE;
import gestion.pfe.models.DemandeEnDTO;
import gestion.pfe.models.DemandeEtudDTO;
import gestion.pfe.models.JSONResponse;
import gestion.pfe.repos.DemnadeEncadrementRepos;
import gestion.pfe.services.DemandeEncadrementService;
import gestion.pfe.services.EnseignantService;
import gestion.pfe.services.EtudiantService;


@RestController
@RequestMapping("/api/DemandeEncadrement")
@CrossOrigin
public class DemandeEncadrementREST {
	
	@Autowired 
	DemandeEncadrementService demandeService;
	@Autowired
	DemnadeEncadrementRepos  demandeEncadrementRepository; 
	
	@Autowired
	EtudiantService etudiantService;
	
	@Autowired
	EnseignantService encadreurService;
	
	@RequestMapping(method= RequestMethod.GET)
	List<DemandeEncadrement> getAllDemandeEncadrements(){
		
		return demandeService.getAllDemandeEncadrements();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public DemandeEncadrement  getDemandeEncadrementById(@PathVariable("id") int id)
	{
		return demandeService.getDemandeEncadrement(id);
	}

	
	@RequestMapping(value="/etud/{id}",method = RequestMethod.GET)
	List <DemandeEtudDTO>getByEtudId(@PathVariable("id") int id)
	{
		return this.demandeService.getByEtudId(id);
	}
	
	
	@RequestMapping(value="/{idEtud}/{idEns}",method = RequestMethod.GET)
	List <DemandeEtudDTO>getByIds(@PathVariable("idEtud") int idEtud, @PathVariable("idEns") int idEns)
	{
		return this.demandeService.getByIds(idEtud, idEns);
	}
	
	@RequestMapping(value="/en/{id}",method = RequestMethod.GET)
	List <DemandeEnDTO>getByEnId(@PathVariable("id") int id)
	{
		return this.demandeService.getByEnId(id);
	}
	
	
	
	@PostMapping("/add/{etudId}/{encadId}")
	public 	DemandeEncadrement createDemandeEncadrement(@RequestBody DemandeEncadrement demande , @PathVariable("etudId") int etudiant, @PathVariable("encadId") int encadreur) {
		demande.setEtudiant(etudiantService.getEtudiant(etudiant));
		demande.setEnseignant(encadreurService.getEnseignant(encadreur));
		return demandeService.saveDemandeEncadrement(demande);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public DemandeEncadrement updateDemandeEncadrement(@RequestBody DemandeEncadrement DemandeEncadrement) {
		
		return demandeService.updateDemandeEncadrement(DemandeEncadrement);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteDemandeEncadrement(@PathVariable("id") int id) {
		DemandeEncadrement d = this.demandeService.getDemandeEncadrement(id);
		demandeService.deleteDemandeEncadrement(d);
		JSONResponse res = new JSONResponse();
		
		res.setSuccess(true);
		return ResponseEntity.ok(res);
	}
	
	@RequestMapping(value="/delete/{idEtud}/{idEns}", method = RequestMethod.DELETE)
	public void deleteDemandeEncadremen(@PathVariable("idEtud") int idEtud,@PathVariable("idEns") int idEns) {
		Etudiant e = this.etudiantService.getEtudiant(idEtud);
		Enseignant ens = this.encadreurService.getEnseignant(idEns);
		demandeService. deleteDemande(e,ens);
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEncad(@PathVariable("id") int id) {
		DemandeEncadrement d = this.demandeEncadrementRepository.findById(id).get();
		JSONResponse res = new JSONResponse();
		res.setSuccess(true);
		this.demandeService.deleteDemandeEncadrement(d);
		return ResponseEntity.ok(res);
	}
}
