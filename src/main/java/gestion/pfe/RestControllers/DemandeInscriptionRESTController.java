
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

import gestion.pfe.entities.DemandeInscription;
import gestion.pfe.services.DemandeInscriptionService;

@RestController
@RequestMapping("/api/DemandeInscription")
@CrossOrigin
public class DemandeInscriptionRESTController {
	
	
	@Autowired
	DemandeInscriptionService demandeInscriptionService;
	
	
	
	@RequestMapping(method= RequestMethod.GET)
	List<DemandeInscription> getAllDemandeInscriptions(){
		
		return demandeInscriptionService.getAllDemandeInscriptions();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public DemandeInscription  getDemandeInscriptionById(@PathVariable("id") int id)
	{
		return demandeInscriptionService.getDemandeInscription(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?>  createDemandeInscription(@RequestBody DemandeInscription DemandeInscription) {;
		return ResponseEntity.ok(demandeInscriptionService.saveDemandeInscription(DemandeInscription));
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public DemandeInscription updateDemandeInscription(@RequestBody DemandeInscription DemandeInscription) {
		
		return demandeInscriptionService.updateDemandeInscription(DemandeInscription);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void deleteDemandeInscription(@PathVariable("id") int id) {
		demandeInscriptionService.deleteDemandeInscriptionById(id);
	}


}

