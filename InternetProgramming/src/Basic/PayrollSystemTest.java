package Basic;
public class PayrollSystemTest {
	public static void main(String args[]) {
		Employee employees[] = new Employee[3];
		employees[0] = new SalariedEmployee("John", "Smith", "111-11-1111",
				800.00);
		employees[1] = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75,
				40);
		employees[2] = new PieceWorker("Rick", "Bridges", "333-33-3333", 2.25,
				400);

		System.out.println("Employees processed ploymorphically :\n");
		
		for(Employee currentEmployee : employees){
			System.out.println(currentEmployee);
			System.out.printf("earned $%,.2f\n\n", currentEmployee.earnings());
		}
	}
}
