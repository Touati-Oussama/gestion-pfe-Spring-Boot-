package gestion.pfe.RestControllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

import gestion.pfe.entities.SFE;
import gestion.pfe.entities.Soutenance;
import gestion.pfe.models.SoutenanceDTO;
import gestion.pfe.repos.SfeRepository;
import gestion.pfe.repos.SoutenanceRepository;
import gestion.pfe.services.EnseignantService;
import gestion.pfe.services.SalleService;
import gestion.pfe.services.SfeService;
import gestion.pfe.services.SoutenanceService;

@RestController
@RequestMapping("/api/soutenance")
@CrossOrigin
public class SoutenanceRESTController {

	@Autowired
	SoutenanceService soutenanceService;
	
	@Autowired
	SoutenanceRepository soutenanceRepository;

	@RequestMapping(value="/list", method= RequestMethod.GET)
	List<Soutenance> all(){
		
		return this.soutenanceRepository.findAll();
	}
	
	@Autowired
	SalleService salleService;
	
	@Autowired
	SfeService sfeService;
	@Autowired
	EnseignantService encadreurService;
	
	
	@RequestMapping(method= RequestMethod.GET)
	List<SoutenanceDTO> getAll(){
		
		return this.soutenanceService.getAll();
	}
	
	@RequestMapping(value="/getByDateSalle/{date}/{salle}", method= RequestMethod.GET)
	List<SoutenanceDTO> test(@PathVariable("date") /*@DateTimeFormat(pattern="yyyy-MM-dd HH:mm") LocalDateTime  */ String date,@PathVariable("salle") String salle){
		System.out.println(date);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
		LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
		return this.soutenanceService.test(dateTime,salle);
	}
	
	@RequestMapping(value="/findByDateSalle/{date}/{idSalle}", method= RequestMethod.GET)
	List<SoutenanceDTO> getByDateSalle(@PathVariable("date") String date,@PathVariable("idSalle") int idSalle){
		System.out.println(date);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
		LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
		return this.soutenanceService.getBySalleDate(dateTime, idSalle);
	}

	@RequestMapping(value="/salle/{idSalle}", method= RequestMethod.GET)
	List<SoutenanceDTO> getBySalle(@PathVariable("idSalle") int idSalle){
		return this.soutenanceService.getBySalle(idSalle);
	}
	
	@RequestMapping(value="/getByDateJury/{date}/{idPre}", method= RequestMethod.GET)
	List<SoutenanceDTO> findByDateJury(@PathVariable("date")String date,@PathVariable("idPre") int idPre){
		System.out.println(date);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
		LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
		return this.soutenanceService.findByDateJury(dateTime,idPre);
	}
	
	@RequestMapping(value="/getBySfe/{id}", method= RequestMethod.GET)
	SoutenanceDTO findBySfe(@PathVariable("id") int id){
		return this.soutenanceService.getBySfeId(id);
	}
	
	
	@RequestMapping(value="/etud/{id}", method= RequestMethod.GET)
	SoutenanceDTO findByEud(@PathVariable("id") int id){
		return this.soutenanceService.getByEtudId(id);
	}
	

	@RequestMapping(value="/en/{id}", method= RequestMethod.GET)
	List<SoutenanceDTO> findByEnId(@PathVariable("id") int id){
		return this.soutenanceService.getByEnId(id);
	}
	
	
	@PostMapping("/add/{idSfe}/{idPre}/{idRap}/{idSalle}")
	public 	ResponseEntity<?> createSoutenance(
			@RequestBody Soutenance sou, @PathVariable("idSfe") int idSfe,
			@PathVariable("idPre") int idPre, @PathVariable("idRap") int idRap,
			@PathVariable("idSalle") int idSalle) {
		sou.setSfe(this.sfeService.getSFE(idSfe));
		sou.setPresidant(this.encadreurService.getEnseignant(idPre));
		sou.setRapporteur(this.encadreurService.getEnseignant(idRap));
		sou.setSalle(this.salleService.getSalle(idSalle));
		System.out.println(sou.getDate());
		return ResponseEntity.ok(this.soutenanceService.saveSoutenance(sou));
	}
}
