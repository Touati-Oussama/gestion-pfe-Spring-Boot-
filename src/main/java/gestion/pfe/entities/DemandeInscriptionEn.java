package gestion.pfe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DemandeInscriptionEn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int NCET;
	private String nom;
	private String prenom;
	private Long telephone;
	private String email;
	private String password;
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Long getTelephone() {
		return telephone;
	}
	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public DemandeInscriptionEn() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return NCET;
	}
	public void setId(int id) {
		this.NCET = id;
	}
	@Override
	public String toString() {
		return "Demande Inscriptiont [id=" + NCET + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + ", email="
				+ email + ", password=" + password + "]";
	}
	public DemandeInscriptionEn(String nom, String prenom, Long telephone, String email, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
	}
}
