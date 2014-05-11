package Basic;
public class SalariedEmployee extends Employee {
	private double salary;

	public SalariedEmployee(String first, String last, String ssn, double salary) {
		super(first, last, ssn);
		this.salary = salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getSalary() {
		return this.salary;
	}

	@Override
	public double earnings() {
		return getSalary();
	}

	@Override
	public String toString() {
		String printName = "salaried employee : " + getFirstName() + " "
				+ getLastName() + "\n";
		String printSsn = "social security number : "
				+ getSocialSecuriyNumber() + "\n";
		String printWage = "weekly salary : $" + getSalary();
		return printName + printSsn + printWage;
	}
}
