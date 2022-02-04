package gestion.pfe.RestControllers;

public class test {

	private String sujet;
	private String nom;
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "test [sujet=" + sujet + ", nom=" + nom + "]";
	}
	public test(String sujet, String nom) {
		super();
		this.sujet = sujet;
		this.nom = nom;
	}
	public test() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
