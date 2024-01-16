package springcore;

public class Student {
	private String name;
	private String address;
	
	public Student(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + "]";
	}
	
}
