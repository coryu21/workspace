public class HeapSort {

	public void heapSort(int arr[]) {

		for (int i = (arr.length - 1) / 2; i > 0; i--) {
			heapify(arr, i, arr.length - 1); // 맨 처음 입력받은 배열을 히피화한다
		}

		for (int i = arr.length - 1; i > 0; i--) {
			swap(arr, 1, i); // 배열의 처음과 끝을 바꿔준다
			heapify(arr, 1, i - 1); // 끝 - 1 부터 다시 히피화한다
		}
	}

	public void heapify(int arr[], int n, int size) {
		for (int i = 2 * n; i <= size; i = i * 2) { // 부모에서 자식으로 내려가면서 값을 비교한다
			if (i < size && arr[i] < arr[i + 1]) // 왼쪽 자식과 오른쪽 자식의 값을 비교한다
				i++;
			if (arr[i / 2] >= arr[i]) { // 부모가 크거나 같으면 for문을 벗어난다
				break;
			} else {
				swap(arr, i / 2, i); // 자식이 더 크면 부모와 바꾼다
			}
		}
	}

	// 값을 바꿔주는 swap
	public void swap(int arr[], int l, int r) {
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}

}
