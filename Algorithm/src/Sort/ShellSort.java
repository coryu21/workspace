package Sort;public class ShellSort extends InsertionSort {
	InsertionSort is;

	// num�� h���� �����Ѵ� . h�� ������ Ȧ��/¦���� ��� ���ƾ� ���� �ߺ��� �ּ�ȭ�� �� �־� ȿ���� ���ϼ� �ִ�
	public void sort(int arr[], int num) {
		int h = 1;
		for (; h < arr.length; h = h * num + 1)
			// �迭�� ũ�⸸ŭ h ���� ������Ų��
			;
		super.sort(arr, h); // ���� h���� ������ŭ ���������� �����Ѵ�
	}
}