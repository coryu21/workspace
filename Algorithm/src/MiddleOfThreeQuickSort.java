public class MiddleOfThreeQuickSort extends QuickSort {

	// 중간값을 구해 a[l], a[m], a[r]값을 바꿔준다
	public void medainOfThree(int arr[], int l, int r) {
		int m = (l + r) / 2;
		if (arr[l] > arr[m])
			swap(arr, l, m);
		if (arr[l] > arr[r])
			swap(arr, l, r);
		if (arr[m] > arr[r])
			swap(arr, m, r);
		swap(arr, m, r - 1);
	}

	public void sort(int[] arr, int l, int r) {
		if (r > l + 1) {
			medainOfThree(arr, l, r);
			int v = partition(arr, l + 1, r - 1); // 이미 r, l, m 값을 정렬되었으므로 r-1부터
													// 퀵소트를 시작한다
			sort(arr, l, v - 1);
			sort(arr, v + 1, r);
		}
	}
}
