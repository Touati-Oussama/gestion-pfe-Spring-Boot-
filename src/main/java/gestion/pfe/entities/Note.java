package gestion.pfe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private double note;
	
	@OneToOne
	private Soutenance soutenance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public Soutenance getSoutenance() {
		return soutenance;
	}

	public void setSoutenance(Soutenance soutenance) {
		this.soutenance = soutenance;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", note=" + note + ", soutenance=" + soutenance + "]";
	}

	public Note(int id, double note, Soutenance soutenance) {
		super();
		this.id = id;
		this.note = note;
		this.soutenance = soutenance;
	}

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
