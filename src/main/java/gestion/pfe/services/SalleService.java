package gestion.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gestion.pfe.repos.SalleRepository;
import gestion.pfe.entities.Salle;
@Service
public class SalleService {

	@Autowired
	SalleRepository salleReposioty;
	
	public Salle addSalle(Salle s){
		return this.salleReposioty.save(s);
	}
	
	public Salle updateSalle(Salle s) {
		return this.salleReposioty.save(s);
	}
	
	public void deleteSalle(Salle s) {
		this.salleReposioty.delete(s);
	}
	
	public List<Salle> getAll(){
		return this.salleReposioty.findAll();
	}
	
	public Salle getSalle(int id) {
		return this.salleReposioty.findById(id).get();
	}
	
	public Salle getByNom(String  nom) {
		return this.salleReposioty.findByNom(nom);
	}
}
