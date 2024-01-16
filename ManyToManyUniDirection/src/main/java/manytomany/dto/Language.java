package manytomany.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Language {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	private String name;
	private String origin;
	
	public Language() {
		
	}
	
	public Language(String name, String origin) {
		super();
		this.name = name;
		this.origin = origin;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	@Override
	public String toString() {
		return "Language [id=" + id + ", name=" + name + ", origin=" + origin + "]";
	}
	
}
