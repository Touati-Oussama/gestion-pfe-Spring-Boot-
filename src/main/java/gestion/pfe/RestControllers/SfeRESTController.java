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
import gestion.pfe.entities.DemandeEncadrement;
import gestion.pfe.entities.Etudiant;
import gestion.pfe.entities.SFE;
import gestion.pfe.models.DemandeEnDTO;
import gestion.pfe.models.sfeModel;
import gestion.pfe.repos.DemnadeEncadrementRepos;
import gestion.pfe.repos.SfeRepository;
import gestion.pfe.services.DemandeEncadrementService;
import gestion.pfe.services.EnseignantService;
import gestion.pfe.services.EtudiantService;
import gestion.pfe.services.SfeService;



@RestController
@RequestMapping("/api/sfe")
@CrossOrigin
public class SfeRESTController {
	
	@Autowired
	SfeService SFEService;
	
	@Autowired
	SfeRepository sfeRepository;
	@Autowired
	EtudiantService etudiantService;
	
	@Autowired
	EnseignantService encadreurService;
	
	@Autowired 
	DemandeEncadrementService demandeService;
	
	
	
	@RequestMapping(method= RequestMethod.GET)
	List<SFE> getAllSFEs(){
		
		return this.sfeRepository.findAll();
	}
	
	@RequestMapping(value="/get",method= RequestMethod.GET)
	List<sfeModel> getAll(){
		
		return this.SFEService.getAll();
	}
	
	@RequestMapping(value="/en/{id}", method= RequestMethod.GET)
	List<DemandeEnDTO> getAllSFEs(@PathVariable("id") int id){
		
		return SFEService.getAllSFEsByEng(id);
	}
	
	@RequestMapping(value="/etudiant/{id}", method= RequestMethod.GET)
	DemandeEnDTO getSFEbyEtud(@PathVariable("id") int id){
		
		return SFEService.getAllSFEsByEtudiant(id);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public SFE  getSFEById(@PathVariable("id") int id)
	{
		return SFEService.getSFE(id);
	}
	
	@RequestMapping(value="/get/{id}",method = RequestMethod.GET)
	public sfeModel  getById(@PathVariable("id") int id)
	{
		return SFEService.getSFEById(id);
	}
	
	
	@PostMapping("/add/{etudId}/{encadId}")
	public 	ResponseEntity<?> createSFE(@RequestBody SFE sfe, @PathVariable("etudId") int etudiant, @PathVariable("encadId") int encadreur ) {
		sfe.setEtudiant(etudiantService.getEtudiant(etudiant));
		sfe.setEnseignant(encadreurService.getEnseignant(encadreur));
		return ResponseEntity.ok(SFEService.saveSFE(sfe));
	}
	
	@PostMapping("/add/{DemandeId}")
	public 	SFE createSFETest(@PathVariable("DemandeId") int id) {
		DemandeEncadrement d = this.demandeService.getDemandeEncadrement(id);
		SFE sfe = new SFE();
		sfe.setEtudiant(d.getEtudiant());
		sfe.setEnseignant(d.getEncadreur());
		sfe.setSujet(d.getSujet());
		return SFEService.saveSFE(sfe);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public SFE updateSFE(@RequestBody SFE SFE) {
		
		return SFEService.updateSFE(SFE);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void deleteSFE(@PathVariable("id") int id) {
		SFEService.deleteSFEById(id);
	}
	
	@RequestMapping( value="/findByEtudiant/{ncet}",method = RequestMethod.GET)
	public SFE findByEtudiant(@PathVariable("ncet") int ncet) {
		return SFEService.findByNCET(ncet);
	}
	
	@RequestMapping( value="/test/{id}",method = RequestMethod.GET)
	public List <Commentaire> getCommentaires(@PathVariable("id") int id) {
		System.out.println(SFEService.getCommentaires(id));
		return SFEService.getCommentaires(id);
		
	}

}
