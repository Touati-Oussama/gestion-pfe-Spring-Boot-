package gestion.pfe.models;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SoutenanceDTO {

	private int id;
	private String sfe;
	private String encadreur;
	private String president;
	private String rapporteur;
	private String salle;
	private LocalDateTime date;
	private String idFile;
	public String getIdFile() {
		return idFile;
	}
	public void setIdFile(String idFile) {
		this.idFile = idFile;
	}
	private String fileDownloadUri;
	private String rapport;
	
	public String getFileDownloadUri() {
		return fileDownloadUri;
	}
	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}
	public int getId() {
		return id;
	}
	public String getRapport() {
		return rapport;
	}
	public void setRapport(String rapport) {
		this.rapport = rapport;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSfe() {
		return sfe;
	}
	public void setSfe(String sfe) {
		this.sfe = sfe;
	}
	public String getEncadreur() {
		return encadreur;
	}
	public void setEncadreur(String encadreur) {
		this.encadreur = encadreur;
	}
	public String getPresident() {
		return president;
	}
	public void setPresident(String president) {
		this.president = president;
	}
	public String getRapporteur() {
		return rapporteur;
	}
	public void setRapporteur(String rapporteur) {
		this.rapporteur = rapporteur;
	}
	public  LocalDateTime getDate() {
		return date;
	}
	public void setDate( LocalDateTime date) {
		this.date = date;
	}
	public String getSalle() {
		return salle;
	}
	public void setSalle(String salle) {
		this.salle = salle;
	}
	@Override
	public String toString() {
		return "SoutenanceDTO [id=" + id + ", sfe=" + sfe + ", encadreur=" + encadreur + ", president=" + president
				+ ", rapporteur=" + rapporteur + ", salle=" + salle + ", date=" + date + ", idFile=" + idFile
				+ ", fileDownloadUri=" + fileDownloadUri + ", rapport=" + rapport + "]";
	}
	public SoutenanceDTO(int id, String sfe, String encadreur, String president, String rapporteur, String salle,
			LocalDateTime date, String idFile, String fileDownloadUri, String rapport) {
		super();
		this.id = id;
		this.sfe = sfe;
		this.encadreur = encadreur;
		this.president = president;
		this.rapporteur = rapporteur;
		this.salle = salle;
		this.date = date;
		this.idFile = idFile;
		this.fileDownloadUri = fileDownloadUri;
		this.rapport = rapport;
	}
	public SoutenanceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
