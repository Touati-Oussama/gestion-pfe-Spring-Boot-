package gestion.pfe.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Soutenance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime date;
	
	@ManyToOne
	private Salle Salle;
	
	@ManyToOne
	private Enseignant presidant;
	@ManyToOne
	private Enseignant rapporteur;
	
	@OneToOne
	private SFE sfe;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Salle getSalle() {
		return Salle;
	}

	public void setSalle(Salle salle) {
		Salle = salle;
	}

	public Enseignant getPresidant() {
		return presidant;
	}

	public void setPresidant(Enseignant presidant) {
		this.presidant = presidant;
	}

	public Enseignant getRapporteur() {
		return rapporteur;
	}

	public void setRapporteur(Enseignant rapporteur) {
		this.rapporteur = rapporteur;
	}

	public SFE getSfe() {
		return sfe;
	}

	public void setSfe(SFE sfe) {
		this.sfe = sfe;
	}

	@Override
	public String toString() {
		return "Soutenance [id=" + id + ", date=" + date + ", Salle=" + Salle + ", presidant=" + presidant
				+ ", rapporteur=" + rapporteur + ", sfe=" + sfe + "]";
	}

	public Soutenance(int id, LocalDateTime date, gestion.pfe.entities.Salle salle, Enseignant presidant,
			Enseignant rapporteur, SFE sfe) {
		super();
		this.id = id;
		this.date = date;
		Salle = salle;
		this.presidant = presidant;
		this.rapporteur = rapporteur;
		this.sfe = sfe;
	}

	public Soutenance() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
	
}
