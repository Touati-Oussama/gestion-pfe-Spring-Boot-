package gestion.pfe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.pfe.entities.Note;
import gestion.pfe.entities.Soutenance;
import gestion.pfe.models.NoteModel;
import gestion.pfe.repos.NoteRepository;
import gestion.pfe.repos.SoutenanceRepository;

@Service
public class NoteService {

	@Autowired
	NoteRepository noteRepository;
	
	@Autowired
	SoutenanceRepository soutenanceRepository;
	
	public NoteModel findByEtudId(int id) {
		Note n = this.noteRepository.findByEtudId(id);
		if (n != null)
		{
			NoteModel nm = new NoteModel();
			nm.setId(n.getId());
			nm.setNote(n.getNote());
			nm.setSoutenance(n.getSoutenance().getId());
			return nm;
		}
		
		return null;
	}
	
	
	public Note saveNote(Note n) {
		// TODO Auto-generated method stub
		return this.noteRepository.save(n);
	}
	
	public NoteModel findBySoutenance(int id) {
		Note n = this.noteRepository.findBySoutenance(id);
		if (n != null)
		{
			NoteModel nm = new NoteModel();
			nm.setId(n.getId());
			nm.setNote(n.getNote());
			nm.setSoutenance(n.getSoutenance().getId());
			return nm;
		}
		
		return null;
	}
	

}
