package gestion.pfe.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SFE {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String sujet;
	
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "ncet")
    private Etudiant etudiant;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "ncen")
    private Enseignant encadreur;
    
    /*
	@OneToMany(mappedBy = "sfe")
	@JsonIgnore
	private List<Commentaire> ListeCommentaire;
	*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	/*
	public List<Commentaire> getListeCommentaire() {
		return ListeCommentaire;
	}*/
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	
	public Enseignant getEncadreur() {
		return this.encadreur;
	}
	public void setEnseignant(Enseignant encadreur) {
		this.encadreur = encadreur;
	}
	/*
	public void setListeCommentaire(List<Commentaire> listeCommentaire) {
		ListeCommentaire = listeCommentaire;
	}*/
	public SFE() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SFE(String sujet, Etudiant etudiant, Enseignant encadreur) {
		super();
		this.sujet = sujet;
		this.etudiant = etudiant;
		this.encadreur = encadreur;
	}
	@Override
	public String toString() {
		return "SFE [id=" + id + ", sujet=" + sujet + ", etudiant=" + etudiant + ", encadreur=" + encadreur + "]";
	}

	
	
	

	
	
	
	
	
	
}
