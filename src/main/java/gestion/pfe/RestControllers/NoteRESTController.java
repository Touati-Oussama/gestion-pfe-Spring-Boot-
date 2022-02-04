package gestion.pfe.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gestion.pfe.entities.Note;
import gestion.pfe.entities.Soutenance;
import gestion.pfe.models.NoteModel;
import gestion.pfe.models.SoutenanceDTO;
import gestion.pfe.repos.NoteRepository;
import gestion.pfe.repos.SoutenanceRepository;
import gestion.pfe.services.NoteService;
import gestion.pfe.services.SoutenanceService;

@RestController
@RequestMapping("/api/note")
@CrossOrigin
public class NoteRESTController {

	@Autowired 
	NoteService noteService;
	@Autowired 
	SoutenanceService soutenanceService;
	
	@RequestMapping(value="/etud/{id}", method= RequestMethod.GET)
	NoteModel findByEud(@PathVariable("id") int id){
		return this.noteService.findByEtudId(id);
	}
	
	@RequestMapping(value="/soutenance/{id}", method= RequestMethod.GET)
	NoteModel findBySou(@PathVariable("id") int id){
		return this.noteService.findBySoutenance(id);
	}
	
	
	@PostMapping("/add/{id}")
	public 	ResponseEntity<?> addNote(@RequestBody Note note, @PathVariable("id") int id) {
		note.setSoutenance(this.soutenanceService.getSoutenance(id));
		return ResponseEntity.ok(this.noteService.saveNote(note));
	}
}
