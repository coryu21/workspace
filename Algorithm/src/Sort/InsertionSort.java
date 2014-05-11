package Sort;public class InsertionSort {
	public void sort(int arr[], int h) {
		int i, j, temp;

		// �������� ����ϱ� ���� �������� Ŭ������ ������ h���� ��� �����ϴ� ������ �޶����
		for (; h > 0; h /= 2) {
			for (i = h + 1; i < arr.length; i++) {
				temp = arr[i];
				for (j = i - h; ((arr[j] > temp) && j >= h); j = j - h) {
					arr[j + h] = arr[j];
				}
				arr[j + h] = temp;
			}
		}
	}
}
