package person_jdbc;

public class Person {
	
	private int id;
	private String name;
	private String address;
	
	public static void main(String[] args) {
		

	}
	
	

	public Person(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}



	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
