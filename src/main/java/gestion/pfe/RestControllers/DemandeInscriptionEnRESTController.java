package gestion.pfe.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gestion.pfe.entities.DemandeInscriptionEn;
import gestion.pfe.services.DemandeInscriptionEnService;




@RestController
@RequestMapping("/api/DemandeInscriptionEn/En")
@CrossOrigin
public class DemandeInscriptionEnRESTController {

	@Autowired
	DemandeInscriptionEnService demandeInscriptionEnService;
	
	@RequestMapping(method= RequestMethod.GET)
	List<DemandeInscriptionEn> getAllDemandeInscriptionEns(){
		
		return demandeInscriptionEnService.getAllDemandeInscriptionEns();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public DemandeInscriptionEn  getDemandeInscriptionEnById(@PathVariable("id") int id)
	{
		return demandeInscriptionEnService.getDemandeInscriptionEn(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?>   createDemandeInscriptionEn(@RequestBody DemandeInscriptionEn DemandeInscriptionEn) {;
		return  ResponseEntity.ok(demandeInscriptionEnService.saveDemandeInscriptionEn(DemandeInscriptionEn));
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public DemandeInscriptionEn updateDemandeInscriptionEn(@RequestBody DemandeInscriptionEn DemandeInscriptionEn) {
		
		return demandeInscriptionEnService.updateDemandeInscriptionEn(DemandeInscriptionEn);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void deleteDemandeInscriptionEn(@PathVariable("id") int id) {
		demandeInscriptionEnService.deleteDemandeInscriptionEnById(id);
	}
}
