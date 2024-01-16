package cascade.fetch.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passport {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int pid;
	private String name;
	private String address;
	
	public Passport() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Passport(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}



	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return "Passport [pid=" + pid + ", name=" + name + ", address=" + address + "]";
	}
	
	
}
