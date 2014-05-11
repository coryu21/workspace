package Sort;public class MiddleOfThreeQuickSort extends QuickSort{
	
	// �߰����� ���� a[l], a[m], a[r]���� �ٲ��ش�
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
			int v = partition(arr, l + 1, r - 1); // �̹� r, l, m ���� ���ĵǾ����Ƿ� r-1���� ���Ʈ�� �����Ѵ�
			sort(arr, l, v - 1);
			sort(arr, v + 1, r);
		}
	}
}
