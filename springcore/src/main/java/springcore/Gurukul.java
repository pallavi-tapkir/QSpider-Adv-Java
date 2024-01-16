package springcore;

public class Gurukul implements School {
	private double fees;
	
	@Override
	public void name() {
		System.out.println("School name is Gurukul");
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}
	
}
