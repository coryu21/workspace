public class InsertionSort {
	public void sort(int arr[], int h) {
		int i, j, temp;

		// 쉘정렬을 사용하기 위해 삽입정렬 클래스를 만들었다 h값에 따라 정렬하는 구간이 달라진다
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
