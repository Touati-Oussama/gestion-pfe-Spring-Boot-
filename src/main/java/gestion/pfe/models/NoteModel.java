package gestion.pfe.models;

public class NoteModel {

	private int id;
	private double note;
	
	private int soutenance;
	
	public int getSoutenance() {
		return soutenance;
	}
	public void setSoutenance(int soutenance) {
		this.soutenance = soutenance;
	}
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
	@Override
	public String toString() {
		return "NoteModel [id=" + id + ", note=" + note + "]";
	}
	public NoteModel(int id, double note) {
		super();
		this.id = id;
		this.note = note;
	}
	public NoteModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
