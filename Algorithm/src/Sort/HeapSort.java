package Sort;

public class HeapSort {

	public void heapSort(int arr[]) {

		for (int i = (arr.length - 1) / 2; i > 0; i--) {
			heapify(arr, i, arr.length - 1); // �� ó�� �Է¹��� �迭�� ����ȭ�Ѵ�
		}
		
		for (int i = arr.length - 1; i > 0; i--) {
			swap(arr, 1, i); // �迭�� ó���� ���� �ٲ��ش�
			heapify(arr, 1, i - 1); // �� - 1 ���� �ٽ� ����ȭ�Ѵ�
		}
	}

	public void heapify(int arr[], int n, int size) {
		for (int i = 2 * n; i <= size; i = i * 2) { // �θ𿡼� �ڽ����� �������鼭 ���� ���Ѵ�
			if (i < size && arr[i] < arr[i + 1]) // ���� �ڽİ� ������ �ڽ��� ���� ���Ѵ�
				i++;
			if (arr[i / 2] >= arr[i]) { // �θ� ũ�ų� ������ for���� �����
				break;
			} else {
				swap(arr, i / 2, i); // �ڽ��� �� ũ�� �θ�� �ٲ۴�
			}
		}
	}

	// ���� �ٲ��ִ� swap
	public void swap(int arr[], int l, int r) {
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}

}
