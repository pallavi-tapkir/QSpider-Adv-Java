package springcore;


public class DPA implements School {
	private double fees;
	
	@Override
	public void name() {
		System.out.println("School name is DPA");
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}
	
}
