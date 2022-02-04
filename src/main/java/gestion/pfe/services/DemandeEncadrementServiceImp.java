package gestion.pfe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.pfe.entities.DemandeEncadrement;
import gestion.pfe.entities.DemandeInscription;
import gestion.pfe.entities.Enseignant;
import gestion.pfe.entities.Etudiant;
import gestion.pfe.models.DemandeEnDTO;
import gestion.pfe.models.DemandeEtudDTO;
import gestion.pfe.repos.DemnadeEncadrementRepos;

@Service
public class DemandeEncadrementServiceImp implements DemandeEncadrementService{
	

	@Autowired
	DemnadeEncadrementRepos demandeRepository;
	@Override
	public DemandeEncadrement saveDemandeEncadrement(DemandeEncadrement e) {
		// TODO Auto-generated method stub
		return this.demandeRepository.save(e);
	}

	@Override
	public DemandeEncadrement updateDemandeEncadrement(DemandeEncadrement e) {
		// TODO Auto-generated method stub
		return this.demandeRepository.save(e);
	}

	@Override
	public void deleteDemandeEncadrement(DemandeEncadrement e) {
		this.demandeRepository.delete(e);
		
	}

	@Override
	public void deleteDemandeEncadrementById(int id) {
		this.demandeRepository.deleteById(id);
		
	}

	@Override
	public DemandeEncadrement getDemandeEncadrement(int id) {
		// TODO Auto-generated method stub
		return this.demandeRepository.findById(id).get();
	}

	@Override
	public List<DemandeEncadrement> getAllDemandeEncadrements() {
		// TODO Auto-generated method stub
		return this.demandeRepository.findAll();
	}

	@Override
	public int  deleteDemande(Etudiant e,Enseignant ens) {
		return this.demandeRepository. deleteDemande(e,ens);
		
	}
	
	@Override
	public void  deleteById(int id) {
		 this.demandeRepository.deleteById(id);
		
	}

	@Override
	public List<DemandeEtudDTO> getByEtudId(int id) {
		List<DemandeEncadrement> tmp = this.demandeRepository.getByEtudId(id);
		ArrayList<DemandeEtudDTO> list = new ArrayList();
		for (int i = 0; i < tmp.size();i++) {
			DemandeEtudDTO d = new DemandeEtudDTO();
			d.setId(tmp.get(i).getId());
			d.setSujet(tmp.get(i).getSujet());
			d.setEncadreur(tmp.get(i).getEncadreur().getNom() + " " + tmp.get(i).getEncadreur().getPrenom());
			list.add(d);
		}
		return list;
	}
	
	@Override
	public List<DemandeEtudDTO> getByIds(int idEtud, int idEns) {
		List<DemandeEncadrement> tmp = this.demandeRepository.getByIds(idEtud, idEns);
		ArrayList<DemandeEtudDTO> list = new ArrayList();
		for (int i = 0; i < tmp.size();i++) {
			DemandeEtudDTO d = new DemandeEtudDTO();
			d.setId(tmp.get(i).getId());
			d.setSujet(tmp.get(i).getSujet());
			d.setEncadreur(tmp.get(i).getEncadreur().getNom() + " " + tmp.get(i).getEncadreur().getPrenom());
			list.add(d);
		}
		return list;
	}

	@Override
	public List<DemandeEnDTO> getByEnId(int id) {
		List<DemandeEncadrement> tmp = this.demandeRepository.getByEnId(id);
		ArrayList<DemandeEnDTO> list = new ArrayList();
		for (int i = 0; i < tmp.size();i++) {
			DemandeEnDTO d = new DemandeEnDTO();
			d.setId(tmp.get(i).getId());
			d.setSujet(tmp.get(i).getSujet());
			d.setEtudiant(tmp.get(i).getEtudiant().getNom() + " " + tmp.get(i).getEtudiant().getPrenom());
			d.setEmail(tmp.get(i).getEtudiant().getEmail());
			list.add(d);
		}
		return list;
	}

}
