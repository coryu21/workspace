import java.util.Random;

public class Test {
	int arr1[];
	int arr2[];
	int arr3[];
	long startTime; // 정렬 전 현재 시간을 받는다
	long endTime; // 정렬 후 현재 시간을 받는다
	long exectueTime1; // 정렬 후 시간 - 정렬 전 시간으로 소요 시간을 구한다
	long executeTime2;
	long exectueTime3;

	public void test(int num) {
		arr1 = new int[num]; // 쉘소트에서 사용할 입력 배열, 이 배열에 random으로 값이 들어가 arr2,
								// arr3으로 복사한다
		arr2 = new int[num]; // 중간값 퀵소트에서 사용할 입력 배열
		arr3 = new int[num]; // 힙소트에서 사용할 입력 배열
		arr1[0] = -1; // 0번째 자리는 -1로 초기화하고 사용하지 않는다

		// 입력배열에 배열의 크기만큼 랜던값을 준다
		for (int i = 1; i < arr1.length; i++) {
			arr1[i] = (int) (Math.random() * arr1.length);
		}

		// 두 배열에 값을 복사한다
		for (int i = 1; i < arr1.length; i++) {
			arr2[i] = arr1[i];
			arr3[i] = arr1[i];
		}

		for (int i = 1; i < arr1.length; i++) {
			System.out.println(arr1[i] + " ");
		}
		System.out.println();
		// 쉘소트
		ShellSort ss = new ShellSort();
		startTime = System.currentTimeMillis();
		ss.sort(arr1, 3);
		endTime = System.currentTimeMillis();
		System.out.println();
		exectueTime1 = endTime - startTime;
		System.out.println("쉘소트 완료!");
		System.out.println("TIME : " + exectueTime1 + "(ms)");
		for (int i = 1; i < arr1.length; i++) {
			System.out.println(arr1[i] + " ");
		}
		System.out.println();
		System.out.println();

		// 중간값 퀵소트
		MiddleOfThreeQuickSort mqs = new MiddleOfThreeQuickSort();
		startTime = System.currentTimeMillis();
		mqs.sort(arr2, 1, arr2.length - 1);
		endTime = System.currentTimeMillis();
		System.out.println();
		executeTime2 = endTime - startTime;
		System.out.println("중간값 퀵소트 완료!");
		System.out.println("TIME : " + executeTime2 + "(ms)");

		System.out.println();

		// 힙소트
		HeapSort hs = new HeapSort();
		startTime = System.currentTimeMillis();
		hs.heapSort(arr3);
		endTime = System.currentTimeMillis();
		System.out.println();
		exectueTime3 = endTime - startTime;
		System.out.println("힙소트 완료!");
		System.out.println("TIME : " + exectueTime3 + "(ms)");

	}

	public static void main(String args[]) {
		Test t = new Test();
		int size = 100; // 입력 배열의 크기
		t.test(size + 1);
	}
}
