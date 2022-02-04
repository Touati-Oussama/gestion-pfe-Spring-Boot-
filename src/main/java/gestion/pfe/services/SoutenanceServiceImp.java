package gestion.pfe.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.el.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gestion.pfe.entities.FileDB;
import gestion.pfe.entities.Soutenance;
import gestion.pfe.models.CommentaireModel;
import gestion.pfe.models.ResponseFile;
import gestion.pfe.models.SoutenanceDTO;
import gestion.pfe.repos.SoutenanceRepository;

@Service
public class SoutenanceServiceImp implements SoutenanceService{
	
	@Autowired
	SoutenanceRepository soutenanceRepository;

	@Autowired 
	FileStorageService fileStorageService;
	
	@Override
	public Soutenance saveSoutenance(Soutenance e) {
		// TODO Auto-generated method stub
		return this.soutenanceRepository.save(e);
	}

	@Override
	public Soutenance updateSoutenance(Soutenance e) {
		// TODO Auto-generated method stub
		return this.soutenanceRepository.save(e);
	}

	@Override
	public void deleteSoutenance(Soutenance e) {
		// TODO Auto-generated method stub
		this.soutenanceRepository.delete(e);
	}

	@Override
	public void deleteSoutenanceById(int id) {
		// TODO Auto-generated method stub
		this.soutenanceRepository.deleteById(id);
	}

	@Override
	public Soutenance getSoutenance(int id) {
		// TODO Auto-generated method stub
		return this.soutenanceRepository.findById(id).get();
	}

	@Override
	public List<SoutenanceDTO> getAll() {
		// TODO Auto-generated method stub
		List<Soutenance> tmp = this.soutenanceRepository.findAll();
		ArrayList<SoutenanceDTO> list = new ArrayList();
		for (int i = 0; i < tmp.size();i++) {
			SoutenanceDTO s = new SoutenanceDTO();
			s.setId(tmp.get(i).getId());
			s.setSfe(tmp.get(i).getSfe().getSujet());
			s.setEncadreur(tmp.get(i).getSfe().getEncadreur().getNom() + " " +tmp.get(i).getSfe().getEncadreur().getPrenom() );
			s.setPresident(tmp.get(i).getPresidant().getNom() + " " +tmp.get(i).getPresidant().getPrenom());
			s.setRapporteur(tmp.get(i).getRapporteur().getNom() + " " +tmp.get(i).getRapporteur().getPrenom());
			s.setDate(tmp.get(i).getDate());
			s.setSalle(tmp.get(i).getSalle().getNom());
			list.add(s);
		}
		return list;
	}
	
	@Override
	public List<SoutenanceDTO> test( LocalDateTime date,String salle){
		List<Soutenance> tmp = this.soutenanceRepository.findByDateSalle(date,salle);
		ArrayList<SoutenanceDTO> list = new ArrayList();
		for (int i = 0; i < tmp.size();i++) {
			SoutenanceDTO s = new SoutenanceDTO();
			s.setId(tmp.get(i).getId());
			s.setSfe(tmp.get(i).getSfe().getSujet());
			s.setEncadreur(tmp.get(i).getSfe().getEncadreur().getNom() + " " +tmp.get(i).getSfe().getEncadreur().getPrenom() );
			s.setPresident(tmp.get(i).getPresidant().getNom() + " " +tmp.get(i).getPresidant().getPrenom());
			s.setRapporteur(tmp.get(i).getRapporteur().getNom() + " " +tmp.get(i).getRapporteur().getPrenom());
			s.setDate(tmp.get(i).getDate());
			s.setSalle(tmp.get(i).getSalle().getNom());
			list.add(s);
		}
		return list;
	}
	
	@Override
	 public List<SoutenanceDTO> getBySalleDate(LocalDateTime date,int id){
		List<Soutenance> tmp = this.soutenanceRepository.getByDateSalle(date,id);
		ArrayList<SoutenanceDTO> list = new ArrayList();
		for (int i = 0; i < tmp.size();i++) {
			SoutenanceDTO s = new SoutenanceDTO();
			s.setId(tmp.get(i).getId());
			s.setSfe(tmp.get(i).getSfe().getSujet());
			s.setEncadreur(tmp.get(i).getSfe().getEncadreur().getNom() + " " +tmp.get(i).getSfe().getEncadreur().getPrenom() );
			s.setPresident(tmp.get(i).getPresidant().getNom() + " " +tmp.get(i).getPresidant().getPrenom());
			s.setRapporteur(tmp.get(i).getRapporteur().getNom() + " " +tmp.get(i).getRapporteur().getPrenom());
			s.setDate(tmp.get(i).getDate());
			s.setSalle(tmp.get(i).getSalle().getNom());
			list.add(s);
		}
		return list;
	}
	
	@Override
	 public List<SoutenanceDTO> getBySalle(int id){
		List<Soutenance> tmp = this.soutenanceRepository.getBySalle(id);
		ArrayList<SoutenanceDTO> list = new ArrayList();
		for (int i = 0; i < tmp.size();i++) {
			SoutenanceDTO s = new SoutenanceDTO();
			s.setId(tmp.get(i).getId());
			s.setSfe(tmp.get(i).getSfe().getSujet());
			s.setEncadreur(tmp.get(i).getSfe().getEncadreur().getNom() + " " +tmp.get(i).getSfe().getEncadreur().getPrenom() );
			s.setPresident(tmp.get(i).getPresidant().getNom() + " " +tmp.get(i).getPresidant().getPrenom());
			s.setRapporteur(tmp.get(i).getRapporteur().getNom() + " " +tmp.get(i).getRapporteur().getPrenom());
			s.setDate(tmp.get(i).getDate());
			s.setSalle(tmp.get(i).getSalle().getNom());
			list.add(s);
		}
		return list;
	}

	@Override
	public List<SoutenanceDTO> findByDateJury(LocalDateTime date, int id) {
		// TODO Auto-generated method stub
		List<Soutenance> tmp = this.soutenanceRepository.findByDateJury(date, id);
		ArrayList<SoutenanceDTO> list = new ArrayList();
		for (int i = 0; i < tmp.size();i++) {
			SoutenanceDTO s = new SoutenanceDTO();
			s.setId(tmp.get(i).getId());
			s.setSfe(tmp.get(i).getSfe().getSujet());
			s.setEncadreur(tmp.get(i).getSfe().getEncadreur().getNom() + " " +tmp.get(i).getSfe().getEncadreur().getPrenom() );
			s.setPresident(tmp.get(i).getPresidant().getNom() + " " +tmp.get(i).getPresidant().getPrenom());
			s.setRapporteur(tmp.get(i).getRapporteur().getNom() + " " +tmp.get(i).getRapporteur().getPrenom());
			s.setDate(tmp.get(i).getDate());
			s.setSalle(tmp.get(i).getSalle().getNom());
			list.add(s);
		}
		return list;
	}

	@Override
	public SoutenanceDTO getBySfeId(int id) {
		// TODO Auto-generated method stub
		Soutenance tmp = this.soutenanceRepository.findBySfeId(id);
		SoutenanceDTO s = new SoutenanceDTO();
		if (tmp != null) {
			s.setId(tmp.getId());
			s.setSfe(tmp.getSfe().getSujet());
			s.setEncadreur(tmp.getSfe().getEncadreur().getNom() + " " +tmp.getSfe().getEncadreur().getPrenom() );
			s.setPresident(tmp.getPresidant().getNom() + " " +tmp.getPresidant().getPrenom());
			s.setRapporteur(tmp.getRapporteur().getNom() + " " +tmp.getRapporteur().getPrenom());
			s.setDate(tmp.getDate());
			s.setSalle(tmp.getSalle().getNom());
			return s;
		}
		return null;

	}

	@Override
	public SoutenanceDTO getByEtudId(int id) {
		// TODO Auto-generated method stub
		Soutenance tmp = this.soutenanceRepository.findByEtudId(id);
		SoutenanceDTO s = new SoutenanceDTO();
		if (tmp != null) {
			s.setId(tmp.getId());
			s.setSfe(tmp.getSfe().getSujet());
			s.setEncadreur(tmp.getSfe().getEncadreur().getNom() + " " +tmp.getSfe().getEncadreur().getPrenom() );
			s.setPresident(tmp.getPresidant().getNom() + " " +tmp.getPresidant().getPrenom());
			s.setRapporteur(tmp.getRapporteur().getNom() + " " +tmp.getRapporteur().getPrenom());
			s.setDate(tmp.getDate());
			s.setSalle(tmp.getSalle().getNom());
			return s;
		}
		return null;
	}
	
	
	@Override
	public List<SoutenanceDTO> getByEnId(int id) {
		// TODO Auto-generated method stub
				

				
				List<Soutenance> tmp = this.soutenanceRepository.findByEnId(id);
				ArrayList<SoutenanceDTO> list = new ArrayList();
				for (int i = 0; i < tmp.size();i++) {
					SoutenanceDTO s = new SoutenanceDTO();
					s.setId(tmp.get(i).getId());
					s.setSfe(tmp.get(i).getSfe().getSujet());
					int idEtud = tmp.get(i).getSfe().getEtudiant().getId();
					FileDB d = this.fileStorageService.get(idEtud);
					String fileDownloadUri =  ServletUriComponentsBuilder
				            .fromCurrentContextPath()
				            .path("/files/")
				            .path(d.getId())
				            .toUriString();
					s.setFileDownloadUri(fileDownloadUri);
					s.setRapport(d.getName());
					s.setIdFile(d.getId());
					s.setEncadreur(tmp.get(i).getSfe().getEncadreur().getNom() + " " +tmp.get(i).getSfe().getEncadreur().getPrenom() );
					s.setPresident(tmp.get(i).getPresidant().getNom() + " " +tmp.get(i).getPresidant().getPrenom());
					s.setRapporteur(tmp.get(i).getRapporteur().getNom() + " " +tmp.get(i).getRapporteur().getPrenom());
					s.setDate(tmp.get(i).getDate());
					s.setSalle(tmp.get(i).getSalle().getNom());
					list.add(s);
				}
				return list;

	}
}
	
