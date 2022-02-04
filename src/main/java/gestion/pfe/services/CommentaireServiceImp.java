package gestion.pfe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.pfe.entities.Commentaire;
import gestion.pfe.models.CommentaireModel;
import gestion.pfe.models.DemandeEtudDTO;
import gestion.pfe.repos.CommentaireRepository;

@Service
public class CommentaireServiceImp implements CommentaireService{
	
	@Autowired
	CommentaireRepository commentaireRepository;
	@Override
	public Commentaire saveCommentaire(Commentaire e) {
		// TODO Auto-generated method stub
		return commentaireRepository.save(e);
	}

	@Override
	public Commentaire updateCommentaire(Commentaire e) {
		// TODO Auto-generated method stub
		return commentaireRepository.save(e);
	}

	@Override
	public void deleteCommentaire(Commentaire e) {
		// TODO Auto-generated method stub
		commentaireRepository.delete(e);
		
	}

	@Override
	public void deleteCommentaireById(int id) {
		// TODO Auto-generated method stub
		commentaireRepository.deleteById(id);
	}

	@Override
	public Commentaire getCommentaire(int id) {
		// TODO Auto-generated method stub
		return commentaireRepository.findById(id).get();
	}

	@Override
	public List<CommentaireModel> getAllCommentaires() {
		// TODO Auto-generated method stub
		List <Commentaire>tmp =  commentaireRepository.findAll();
		ArrayList<CommentaireModel> list = new ArrayList();
		for (int i = 0; i < tmp.size();i++) {
			CommentaireModel d = new CommentaireModel();
			d.setId(tmp.get(i).getId());
			d.setCommentaire(tmp.get(i).getCommentaire());
			d.setOwner(tmp.get(i).getOwner());
			d.setDate(tmp.get(i).getDate());
			d.setSfe(tmp.get(i).getSfe().getId());
			/*
			d.setId(tmp.get(i).getId());
			d.setSujet(tmp.get(i).getSujet());
			d.setEncadreur(tmp.get(i).getEncadreur().getNom() + " " + tmp.get(i).getEncadreur().getPrenom());*/
			list.add(d);
		}
		return list;
	}

	
	@Override
	public List <CommentaireModel> getCommentairesBySFE(int id){
		// TODO Auto-generated method stub
		List <Commentaire>tmp = this.commentaireRepository.getCommentairesBySFE(id);
		ArrayList<CommentaireModel> list = new ArrayList();
		for (int i = 0; i < tmp.size();i++) {
			CommentaireModel d = new CommentaireModel();
			d.setId(tmp.get(i).getId());
			d.setCommentaire(tmp.get(i).getCommentaire());
			d.setOwner(tmp.get(i).getOwner());
			d.setDate(tmp.get(i).getDate());
			d.setSfe(tmp.get(i).getSfe().getId());
			list.add(d);
		}
		return list;
	}



}
