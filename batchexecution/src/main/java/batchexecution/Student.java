package batchexecution;

import java.util.Scanner;

public class Student {
	private int id;
	private String name;
	private double marks;
	
	

	public Student(int id2, String name2, double marks2) {
		this.id = id2;
		this.name = name2;
		this.marks = marks2;
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



	public double getMarks() {
		return marks;
	}



	public void setMarks(double marks) {
		this.marks = marks;
	}



	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nEnter the student id : ");
		int id = scanner.nextInt();
		System.out.print("\nEnter the name : ");
		String name = scanner.next();
		System.out.print("\nEnter the marks : ");
		double marks = scanner.nextDouble();
		
		Student student = new Student(id, name, marks); 
	}

}
