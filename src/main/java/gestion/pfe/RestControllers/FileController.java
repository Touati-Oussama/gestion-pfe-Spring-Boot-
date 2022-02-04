package gestion.pfe.RestControllers;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



import gestion.pfe.entities.FileDB;
import gestion.pfe.models.JSONResponse;
import gestion.pfe.models.ResponseFile;
import gestion.pfe.models.ResponseMessage;
import gestion.pfe.services.FileStorageService;



@RestController
@RequestMapping("/api/file")
@CrossOrigin
public class FileController {

  @Autowired
  private FileStorageService storageService;

  @PostMapping("/upload/{id}")
  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable("id") int id) {
    String message = "";
    try {
      storageService.store(file,id);

      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }

  @GetMapping("/files")
  public ResponseEntity<List<ResponseFile>> getListFiles() {
    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
      String fileDownloadUri = ServletUriComponentsBuilder
          .fromCurrentContextPath()
          .path("/files/")
          .path(dbFile.getId())
          .toUriString();

      return new ResponseFile(  
    	  dbFile.getId(),
          dbFile.getName(),
          fileDownloadUri,
          dbFile.getType(),
          dbFile.getData().length);
    }).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK).body(files);
  }

  
  @GetMapping("/etudiant/{id}")
  public  ResponseEntity<List<ResponseFile>>  getFileByEtud(@PathVariable("id") int id) {
	    List<ResponseFile> files = storageService.getByEtudiant(id).map(dbFile -> {
	        String fileDownloadUri = ServletUriComponentsBuilder
	            .fromCurrentContextPath()
	            .path("/files/")
	            .path(dbFile.getId())
	            .toUriString();

	        return new ResponseFile(
	        	dbFile.getId(),
	            dbFile.getName(),
	            fileDownloadUri,
	            dbFile.getType(),
	            dbFile.getData().length);
	      }).collect(Collectors.toList());

	      return ResponseEntity.status(HttpStatus.OK).body(files);
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
    FileDB fileDB = storageService.getFile(id);
    System.out.println(fileDB);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
        .body(fileDB.getData());
  }
  
  
  @GetMapping("/download/{id}")
	public void downloadFile(@PathVariable String id, HttpServletResponse res) throws Exception {
	    FileDB fileDB = storageService.getFile(id);
		res.setHeader("Content-Disposition", "attachment; filename=" + fileDB.getName());
		res.getOutputStream().write(fileDB.getData());
	}
  
  @GetMapping("/getBySfe/{id}")
  public ResponseEntity<?> getBySfe(@PathVariable int id) {
    FileDB fileDB = storageService.getBySfe(id);
	JSONResponse res = new JSONResponse();
	if (fileDB != null)
		res.setSuccess(true);
	else
		res.setSuccess(false);
	
	 
	return  ResponseEntity.ok(res)  ;

  }
	
}