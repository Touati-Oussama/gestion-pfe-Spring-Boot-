package gestion.pfe.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import gestion.pfe.entities.Soutenance;
import gestion.pfe.models.SoutenanceDTO;


public interface SoutenanceService {

	Soutenance saveSoutenance(Soutenance e);
	Soutenance updateSoutenance(Soutenance e);
	void deleteSoutenance(Soutenance e);
	void deleteSoutenanceById(int id);
	Soutenance getSoutenance(int id);
	List<SoutenanceDTO> getAll();
	//List<DemandeEnDTO> getAllSoutenancesByEng(int id);
	//Soutenance findByNCET(int ncet);
	//DemandeEnDTO getAllSoutenancesByEtudiant(int id);
	List<SoutenanceDTO> test(LocalDateTime date,String salle);
	List<SoutenanceDTO> getBySalleDate(LocalDateTime date,int id);
	List<SoutenanceDTO> findByDateJury(LocalDateTime date,int id);
	SoutenanceDTO getBySfeId(int id);
	SoutenanceDTO getByEtudId(int id);
	List<SoutenanceDTO> getByEnId(int id);
	List<SoutenanceDTO> getBySalle(int id);
}
