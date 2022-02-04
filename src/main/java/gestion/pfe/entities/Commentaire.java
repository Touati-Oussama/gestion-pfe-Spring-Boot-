package gestion.pfe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class Commentaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String commentaire;
	@ManyToOne
	private SFE sfe;
	
	private LocalDateTime date = LocalDateTime.now();
	
	@Column(name ="onwer", nullable= false)
	private String owner;
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	/*
	@ManyToOne
	private Enseignant encadreur;*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public SFE getSfe() {
		return sfe;
	}
	public void setSfe(SFE sfe) {
		this.sfe = sfe;
	}
	/*
	public Enseignant getEncadreur() {
		return encadreur;
	}
	public void setEncadreur(Enseignant encadreur) {
		this.encadreur = encadreur;
	}*/
	
	
	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", commentaire=" + commentaire + ", sfe=" + sfe + ", date=" + date + ", owner="
				+ owner + "]";
	}
	public Commentaire(int id, String commentaire, SFE sfe, LocalDateTime date, String owner) {
		super();
		this.id = id;
		this.commentaire = commentaire;
		this.sfe = sfe;
		this.date = date;
		this.owner = owner;
	}


	
	
	
}
