package Sort;import java.util.Random;

public class Test {
	int arr1[];
	int arr2[];
	int arr3[];
	long startTime; // ���� �� ���� �ð��� �޴´�
	long endTime; // ���� �� ���� �ð��� �޴´�
	long exectueTime1; // ���� �� �ð� - ���� �� �ð����� �ҿ� �ð��� ���Ѵ�
	long exectueTime2;
	long exectueTime3;

	public void test(int num) {
		arr1 = new int[num]; // ����Ʈ���� ����� �Է� �迭, �� �迭�� random���� ���� �� arr2,
								// arr3���� �����Ѵ�
		arr2 = new int[num]; // �߰��� ���Ʈ���� ����� �Է� �迭
		arr3 = new int[num]; // ���Ʈ���� ����� �Է� �迭
		arr1[0] = -1; // 0��° �ڸ��� -1�� �ʱ�ȭ�ϰ� ������� �ʴ´�

		// �Է¹迭�� �迭�� ũ�⸸ŭ ������ �ش�
		for (int i = 1; i < arr1.length; i++) {
			arr1[i] = (int) (Math.random() * arr1.length);
		}

		// �� �迭�� ���� �����Ѵ�
		for (int i = 1; i < arr1.length; i++) {
			arr2[i] = arr1[i];
			arr3[i] = arr1[i];
		}

		// ����Ʈ
		ShellSort ss = new ShellSort();
		startTime = System.currentTimeMillis();
		ss.sort(arr1, 3);
		endTime = System.currentTimeMillis();
		System.out.println();
		exectueTime1 = endTime - startTime;
		System.out.println("����Ʈ �Ϸ�!");
		System.out.println("TIME : " + exectueTime1 + "(ms)");

		System.out.println();

		// �߰��� ���Ʈ
		MiddleOfThreeQuickSort mqs = new MiddleOfThreeQuickSort();
		startTime = System.currentTimeMillis();
		mqs.sort(arr2, 1, arr2.length - 1);
		endTime = System.currentTimeMillis();
		System.out.println();
		exectueTime2 = endTime - startTime;
		System.out.println("�߰��� ���Ʈ �Ϸ�!");
		System.out.println("TIME : " + exectueTime2 + "(ms)");

		System.out.println();

		// ���Ʈ
		HeapSort hs = new HeapSort();
		startTime = System.currentTimeMillis();
		hs.heapSort(arr3);
		endTime = System.currentTimeMillis();
		System.out.println();
		exectueTime3 = endTime - startTime;
		System.out.println("���Ʈ �Ϸ�!");
		System.out.println("TIME : " + exectueTime3 + "(ms)");

	}

	public static void main(String args[]) {
		Test t = new Test();
		//int size = Integer.parseInt(args[0]); // �Է� �迭�� ũ��
		t.test(10000 + 1);
	}
}
