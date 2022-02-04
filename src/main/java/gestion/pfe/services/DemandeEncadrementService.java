package gestion.pfe.services;

import java.util.List;

import javax.transaction.Transactional;

import gestion.pfe.entities.DemandeEncadrement;
import gestion.pfe.entities.Enseignant;
import gestion.pfe.entities.Etudiant;
import gestion.pfe.models.DemandeEnDTO;
import gestion.pfe.models.DemandeEtudDTO;


public interface DemandeEncadrementService {

	DemandeEncadrement saveDemandeEncadrement(DemandeEncadrement e);
	DemandeEncadrement updateDemandeEncadrement(DemandeEncadrement e);
	void deleteDemandeEncadrement(DemandeEncadrement e);
	void deleteDemandeEncadrementById(int id);
	DemandeEncadrement getDemandeEncadrement(int id);
	List<DemandeEncadrement> getAllDemandeEncadrements();
	
	int deleteDemande(Etudiant e,Enseignant ens);
	
	List<DemandeEtudDTO>getByEtudId(int id);
	public List<DemandeEnDTO>getByEnId(int id);
	List<DemandeEtudDTO> getByIds(int idEtud, int idEns);
	void deleteById(int id);
}
