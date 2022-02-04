package gestion.pfe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.pfe.entities.Commentaire;
import gestion.pfe.entities.DemandeEncadrement;
import gestion.pfe.entities.SFE;
import gestion.pfe.models.DemandeEnDTO;
import gestion.pfe.models.sfeModel;
import gestion.pfe.repos.SfeRepository;

@Service
public class SfeServiceImp implements SfeService{
	
	@Autowired
	SfeRepository SFERepository;
	
	@Override
	public SFE saveSFE(SFE e) {
		// TODO Auto-generated method stub
		return SFERepository.save(e);
	}

	@Override
	public SFE updateSFE(SFE e) {
		// TODO Auto-generated method stub
		return SFERepository.save(e);
	}

	@Override
	public void deleteSFE(SFE e) {
		// TODO Auto-generated method stub
		SFERepository.delete(e);
		
	}

	@Override
	public void deleteSFEById(int id) {
		// TODO Auto-generated method stub
		SFERepository.deleteById(id);
	}

	@Override
	public sfeModel getSFEById(int id) {
		// TODO Auto-generated method stub
		SFE tmp = this.SFERepository.findById(id).get();
		sfeModel d = new sfeModel();
		d.setId(tmp.getId());
		d.setSujet(tmp.getSujet());
		d.setEncadreur(tmp.getEncadreur().getNom() + " " + tmp.getEncadreur().getPrenom());
		d.setEtudiant(tmp.getEtudiant().getNom() + " " + tmp.getEtudiant().getPrenom());
		
		return d;
	}

	@Override
	public List<DemandeEnDTO> getAllSFEsByEng(int id) {
		// TODO Auto-generated method stub
			List<SFE> tmp = this.SFERepository.getAllSFEsByEng(id);
			List<DemandeEnDTO> list = new ArrayList();
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
	
	@Override
	public DemandeEnDTO getAllSFEsByEtudiant(int id) {
		// TODO Auto-generated method stub
			SFE tmp = this.SFERepository.getAllSFEsByEtudiant(id);
			if (tmp != null) {
				DemandeEnDTO d = new DemandeEnDTO();
				d.setId(tmp.getId());
				d.setSujet(tmp.getSujet());
				d.setEtudiant(tmp.getEtudiant().getNom() + " " + tmp.getEtudiant().getPrenom());
				d.setEmail(tmp.getEtudiant().getEmail());
				return d;
			}
			//return new DemandeEnDTO();
			return null;

			
			
	}

	@Override
	public SFE findByNCET(int ncet) {

		return this.SFERepository.findByNCET(ncet);
	}

	@Override
	public List<Commentaire> getCommentaires(int id) {
		// TODO Auto-generated method stub
		return this.SFERepository.getCommentaires(id);
	}

	@Override
	public List<sfeModel> getAll() {
		// TODO Auto-generated method stub
		ArrayList<sfeModel> list = new ArrayList();
		List<SFE> tmp = this.SFERepository.findAll();
		for (int i = 0; i < tmp.size();i++) {
			sfeModel d = new sfeModel();
			d.setId(tmp.get(i).getId());
			d.setSujet(tmp.get(i).getSujet());
			d.setEncadreur(tmp.get(i).getEncadreur().getNom() + " " + tmp.get(i).getEncadreur().getPrenom());
			d.setEtudiant(tmp.get(i).getEtudiant().getNom() + " " + tmp.get(i).getEtudiant().getPrenom());
			list.add(d);
		}
		return list;
	}

	@Override
	public SFE getSFE(int id) {
		// TODO Auto-generated method stub
		return this.SFERepository.findById(id).get();
	}

}
