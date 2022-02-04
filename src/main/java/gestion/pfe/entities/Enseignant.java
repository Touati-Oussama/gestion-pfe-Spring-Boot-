package gestion.pfe.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Enseignant{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int NCEN;

	private String nom;
	private String prenom;
	private int telephone;
	private String email;
	private String password;
	private String roles = "ENSEIGNANT";
	
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
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
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
	
	public int getNCEN() {
		return NCEN;
	}

	public void setNCEN(int nCEN) {
		NCEN = nCEN;
	}

	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	public Enseignant(String nom, String prenom, int telephone, String email, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Enseignant [NCEN=" + NCEN + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone
				+ ", email=" + email + ", password=" + password + ", roles=" + roles + "]";
	}
	
	

	
	
}
