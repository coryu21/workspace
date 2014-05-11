public class ShellSort extends InsertionSort {
	InsertionSort is;

	// num은 h값을 결정한다 . h가 나눠질때 홀수/짝수가 번갈아 놔아야 값의 중복을 최소화할 수 있어 효율을 높일수 있다
	public void sort(int arr[], int num) {
		int h = 1;
		for (; h < arr.length; h = h * num + 1)
			// 배열의 크기만큼 h 값을 증가시킨다
			;
		super.sort(arr, h); // 구한 h값의 구간만큼 삽입정렬을 실행한다
	}
}
