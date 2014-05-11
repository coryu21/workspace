package Basic;

import java.util.Scanner;

public class Homework1 {
	static int inputNum = 0;
	static Scanner s;
	static char[] cashArr;
	static int cashNum;
	static char[] testArr;
	static String inputCase;
	static int testNum;
	static int count = 0;
	static int c_count = 0;
	static boolean check1 = true;
	static boolean check2 = true;

	static void caseNum(int num) {
		for (int i = 0; i < num; i++) {
			System.out.print("테스트 케이스의 캐시 슬롯 수 :");
			cashNum = s.nextInt();
			cashArr = new char[cashNum];
			System.out.print("접근할 데이터의 수 :");
			testNum = s.nextInt();
			testArr = new char[testNum];
			System.out.println(cashNum + "  " + testNum);
			inputTest();
			paging();
		}
	}

	static void inputTest() {
		System.out.print("테스트 케이스를 입력하세요 :");
		s = new Scanner(System.in);
		inputCase = s.nextLine();
		for (int i = 0; i < inputCase.length(); i++)
			testArr[i] = inputCase.charAt(i);
		System.out.println(testArr);
	}

	static void paging() {
		for (int i = 0; i < inputCase.length(); i++) {
			if (cashArr[count] == '\u0000') {
				for (int j = 0; j < count; j++) {
					if (cashArr[j] == testArr[i]) {
						check2 = false;
						break;
					} else {
						check2 = true;
					}
				}
				if (check2) {
					cashArr[count] = testArr[i];
					count++;
					System.out.println(cashArr);
				}
				System.out.println(c_count);
			} else {
				for (int j = 0; j < cashNum; j++) {
					if (cashArr[j] == testArr[i]) {
						check1 = false;
						break;
					} else {
						check1 = true;
					}
				}
				if (check1) {
					/*if (count == 0)
						cashArr[count] = testArr[i];
					else
						cashArr[count - 1] = testArr[i];
					*/
					// count++;
					int temp = time(i);
					cashArr[temp] = testArr[i];
					c_count++;
					System.out.println(cashArr);
					check1 = false;
				}
				count++;
			}
			if (count == cashNum)
				count = 0;
		}
		System.out.println("캐시 카운팅 : " + c_count);
	}

	static int time(int num) {
		int j = 0;
		char temp;
		int c_num = 0;
		int m_num = 0;
		int max = 0;
		int count = 0;
		boolean check  = true;
		for (int i = 0; i < cashNum; i++) {
			count = 0;
			temp = cashArr[i];
			for (j = num; j < testNum; j++) {
				count++;
				if (temp == testArr[j]) {
					c_num = i;
					check = false;
					break;
				}
			}
			System.out.println(i + "  :  " + count);
			if(j==testNum)
				return i;
			if (i == 0) {
				max = count;
				m_num = c_num;
			}
			if (max< count) {
				max = count;
				m_num = c_num;
			}
		}
		return m_num;
	}

	public static void main(String args[]) {
		s = new Scanner(System.in);
		System.out.print("테스트 케이스의 수를 입력하시오 :");
		inputNum = s.nextInt();
		caseNum(inputNum);
	}
}
