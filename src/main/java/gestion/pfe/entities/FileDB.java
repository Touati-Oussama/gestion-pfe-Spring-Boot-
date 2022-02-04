package gestion.pfe.entities;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "files")
public class FileDB {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  private String name;

  private String type;

  @Lob
  private byte[] data;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(referencedColumnName = "ncet")
  private Etudiant etudiant;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public byte[] getData() {
	return data;
}

public void setData(byte[] data) {
	this.data = data;
}

public Etudiant getEtudiant() {
	return etudiant;
}

public void setEtudiant(Etudiant etudiant) {
	this.etudiant = etudiant;
}

@Override
public String toString() {
	return "FileDB [id=" + id + ", name=" + name + ", type=" + type + ", data=" + Arrays.toString(data) + ", etudiant="
			+ etudiant + "]";
}

public FileDB(String id, String name, String type, byte[] data, Etudiant etudiant) {
	super();
	this.id = id;
	this.name = name;
	this.type = type;
	this.data = data;
	this.etudiant = etudiant;
}

public FileDB() {
	super();
	// TODO Auto-generated constructor stub
}
  
  
  }