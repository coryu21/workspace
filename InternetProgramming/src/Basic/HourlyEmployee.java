package Basic;
public class HourlyEmployee extends Employee {
	private double wage;
	private double hours;

	public HourlyEmployee(String first, String last, String ssn, double wage,
			double hours) {
		super(first, last, ssn);
		this.wage = wage;
		this.hours = hours;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public double getWage() {
		return this.wage;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public double getHours() {
		return this.hours;
	}

	@Override
	public double earnings() {
		return getWage() * getHours();
	}

	@Override
	public String toString() {
		String printName = "Hourly employee : " + getFirstName() + " "
				+ getLastName() + "\n";
		String printSsn = "social security number : "
				+ getSocialSecuriyNumber() + "\n";
		String printWage = "hourly wage : $" + getWage() + " hours worked : "
				+ getHours();
		return printName + printSsn + printWage;
	}
}
