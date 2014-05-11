import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Prime {
	private LinkedList<Integer> list;
	private int num1;
	private int num2;
	int input;
	Scanner s;

	public Prime() {
		System.out.println("소수 구하기 객체 생성!");
		list = new LinkedList<Integer>();
		s = new Scanner(System.in);
	}

	public void inputNumber() throws Exception {

		System.out.print(">> 입력할 수의 범위 n을 입력하세요 ( 2 ~ n ) : ");
		try {
			input = s.nextInt();
			if (input <= 1 || input > 10000) {
				System.out.println("n은 1 이하, 10000 초과 일 수 없습니다. 다시 입력해주십시오.");
				throw new Exception();
			}
		} catch (Exception e) {
			inputNumber();
		}
		this.num1 = 2;
		this.num2 = input;

	}

	public void setNumber() {
		for (int i = this.num1; i <= this.num2; i++) {
			list.add(i);
		}
		System.out.println("입력 받은 수는 아래와 같습니다.");
		System.out.println(list);
	}

	public void getPrime1() {
		int i, j;
		boolean isPrime;

		for (i = this.num1, j = 0; i <= this.num2; i++) {
			isPrime = true;

			for (int n = 2; n < i; n++) {
				if (i % n == 0) {
					isPrime = false;
					list.remove(j);
					break;
				}
			}

			if (isPrime == true) {
				j++;
			}
		}
	}

	public void getPrime2() {
		Iterator<Integer> it = list.iterator();
		int i;
		while (it.hasNext()) {
			i = it.next();
			for (int n = 2; n < i; n++) {
				if (i % n == 0) {
					it.remove();
					break;
				}
			}
		}
	}

	public void printNumber() {
		Iterator<Integer> it = list.iterator();
		System.out.println(">> 입력 받은 수의 소수는 아래와 같습니다.");
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
		//System.out.println(list);
	}

	public static void main(String args[]) throws Exception {
		Prime p1 = new Prime();
		p1.inputNumber();
		p1.setNumber();
		p1.getPrime2();
		p1.printNumber();
	}
}
