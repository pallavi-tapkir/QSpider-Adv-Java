package main.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Floor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int floorNo;
		
	public Floor() {
		// TODO Auto-generated constructor stub
	}

	public Floor(String name, int floorNo) {
		super();
		this.name = name;
		this.floorNo = floorNo;
	}

	public int getPid() {
		return id;
	}

	public void setPid(int pid) {
		this.id = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}

	@Override
	public String toString() {
		return "Person [pid=" + id + ", name=" + name + ", floorNo=" + floorNo + "]";
	}
	
	
}
