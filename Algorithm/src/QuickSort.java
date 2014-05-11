public class QuickSort {

	// pivot을 결정하고 r, l을 이동하며 값을 변경하는 parition
	public int partition(int arr[], int l, int r) {
		int v = arr[r];
		int p_l = l - 1;
		int p_r = r;
		while (true) {
			while (arr[++p_l] < v)
				// 피벗보다 작으면 l 값을 오른쪽으로 이동
				;
			while (arr[--p_r] > v)
				// 피벗보다 크면 r 값을 왼쪽으로 이동
				;
			if (p_l >= p_r) // 교차하면 반복문을 빠져나감
				break;
			swap(arr, p_l, p_r);
		}
		swap(arr, p_l, r);
		return p_l;
	}

	public void q_sort(int[] arr, int l, int r) {
		if (r > l) {
			int v = partition(arr, l, r);
			q_sort(arr, l, v - 1); // 피벗의 위치 왼쪽 정렬
			q_sort(arr, v + 1, r); // 피벗의 위치 오른쪽 정렬
		}
	}

	public void swap(int arr[], int l, int r) {
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}

}
