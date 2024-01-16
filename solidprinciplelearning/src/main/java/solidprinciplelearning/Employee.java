package solidprinciplelearning;

public abstract class Employee {
	private String firstName;
	private String lastName;
	private int monthlyIncome;
	private int numOfHrsPerWeek;
	
	public Employee(String fullName, int monthlyIncome) {
		String[] names = fullName.split(" ");
		
		this.firstName = names[0];
		this.lastName = names[1];
		
		setMonthlyIncome(monthlyIncome);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", monthlyIncome=" + monthlyIncome
				+ ", numOfHrsPerWeek=" + numOfHrsPerWeek + "]";
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(int monthlyIncome) {
		 if(monthlyIncome < 0){
	            throw new IllegalArgumentException("Income must be positive");
	        }
		this.monthlyIncome = monthlyIncome;
	}

	public int getNumOfHrsPerWeek() {
		return numOfHrsPerWeek;
	}

	public void setNumOfHrsPerWeek(int numOfHrsPerWeek) {
		if(numOfHrsPerWeek <= 0){
            throw new IllegalArgumentException("Income must be positive");
        }
		this.numOfHrsPerWeek = numOfHrsPerWeek;
	}
	
	public String getEmail() {
		return this.firstName + "." + this.lastName + "@dummy.com";
	}
	
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
}
