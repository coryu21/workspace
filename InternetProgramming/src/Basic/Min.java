package Basic;
import java.util.Scanner;

public class Min {
	public void findMinimum(){
		Scanner input = new Scanner(System.in);
		
		double one;
		double two;
		double three;
		double four;
		
		System.out.printf("%s\n, %s\n, %s\n",
				"Type the end-of-file indicator to terminate",
				"On UNIX/LINUX/MAC 05 X type <ctrl> d then prees Enter",
				"On Window type <ctrl>  c then press Enter");
		System.out.print("Or enter first number : ");
		
		while(input.hasNext()){
			one = input.nextDouble();
			System.out.println("Enter second number: ");
			two = input.nextDouble();
			System.out.println("Enter third number: ");
			three = input.nextDouble();
			System.out.println("Enter fourth number: ");
			four = input.nextDouble();
			
			System.out.printf("Minimum is %f\n", minimum4(one, two, three, four));
			
			System.out.printf("%s\n, %s\n, %s\n",
					"Type the end-of-file indicator to terminate",
					"On UNIX/LINUX/MAC 05 X type <ctrl> d then prees Enter",
					"On Window type <ctrl>  then press Enter");
			System.out.print("Or enter first number : ");
		}
	}
	
	public double minimum4(double one, double two, double three, double four){
		return Math.min(Math.min(one,two), Math.min(three, four));
	}
	
}