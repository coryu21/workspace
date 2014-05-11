package Sort;public class QuickSort {
	
	// pivot�� �����ϰ� r, l�� �̵��ϸ� ���� �����ϴ� parition
	public int partition(int arr[], int l, int r) {
		int v = arr[r];
		int p_l = l - 1;
		int p_r = r;
		while (true) {
			while (arr[++p_l] < v) // �ǹ����� ������ l ���� ���������� �̵�
				;
			while (arr[--p_r] > v) // �ǹ����� ũ�� r ���� �������� �̵�
				;
			if (p_l >= p_r) // �����ϸ� �ݺ����� ��������
				break;
			swap(arr, p_l, p_r);
		}
		swap(arr, p_l, r);
		return p_l;
	}

	public void q_sort(int[] arr, int l, int r) {
		if (r > l) {
			int v = partition(arr, l, r);
			q_sort(arr, l, v - 1); // �ǹ��� ��ġ ���� ����
			q_sort(arr, v + 1, r); // �ǹ��� ��ġ ������ ����
		}
	}

	public void swap(int arr[], int l, int r) {
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}

}
