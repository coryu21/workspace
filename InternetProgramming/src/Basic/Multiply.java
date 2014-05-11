package Basic;
import java.util.Random;
import java.util.Scanner;

public class Multiply {
	Random randomNumbers = new Random();
	int answer;

	public void quiz() {
		Scanner input = new Scanner(System.in);

		int guess;

		createQuestion();

		System.out.println("Enter your answer (-1 to exit) :");
		guess = input.nextInt();

		while (guess != -1) {
			checkResponse(guess);
			System.out.println("Enter your answer (-1 to exit) :");
			guess = input.nextInt();
		}
	}

	public void createQuestion() {
		int digit1 = randomNumbers.nextInt(10);
		int digit2 = randomNumbers.nextInt(10);

		answer = digit1 * digit2;
		System.out.printf("How much is %d times %d?\n", digit1, digit2);
	}

	public void checkResponse(int guess) {
		if (guess != answer) {
			System.out.println(badResponse());
		} else {
			System.out.println(goodResponse());
			createQuestion();
		}
	}

	public String goodResponse() {
		switch (randomNumbers.nextInt(4)) {
		case 0:
			return ("Very Good!");
		case 1:
			return ("Excellent!");
		case 2:
			return ("Nice Work");
		case 3:
			return ("Keep up the good work!");
		default:
			return ("Error!");
		}
	}
	
	public String badResponse() {
		switch (randomNumbers.nextInt(4)) {
		case 0:
			return ("No, Please try again.");
		case 1:
			return ("Wrong. Try once more.");
		case 2:
			return ("Don't give up!");
		case 3:
			return ("No. Keep trying!");
		default:
			return ("Error!");
		}
	}
}
