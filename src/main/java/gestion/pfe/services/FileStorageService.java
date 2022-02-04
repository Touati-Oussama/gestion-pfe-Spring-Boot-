package gestion.pfe.services;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import gestion.pfe.entities.FileDB;
import gestion.pfe.repos.FileDBRepository;



@Service
public class FileStorageService {

  @Autowired
  private FileDBRepository fileDBRepository;

  @Autowired 
  private EtudiantService etudiantService;
  
  public FileDB store(MultipartFile file, int id) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    FileDB FileDB = new FileDB();
    FileDB.setName(fileName);
    FileDB.setType(file.getContentType());
    FileDB.setData(file.getBytes());
    FileDB.setEtudiant(this.etudiantService.getEtudiant(id));
    return fileDBRepository.save(FileDB);
  }

  public FileDB getFile(String id) {
    return fileDBRepository.findById(id).get();
  }
  
  public Stream<FileDB> getByEtudiant(int id) {
	    return this.fileDBRepository.findByNCET(id).stream();
	  }
  public FileDB get(int id)
  {
	  return this.fileDBRepository.get(id);
  }
  public Stream<FileDB> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }
  
  public FileDB getBySfe(int id) {
	  return this.fileDBRepository.getBySfe(id);
  }
}
