public class SharedData {
	private boolean isNew = false;
	private int data;

	public synchronized void put(int data) {
		try {
			while (isNew) {
				System.out.println("put waiting()....");
				wait();
			}
		} catch (InterruptedException e) {
		}
		this.data = data;
		isNew = true;
		notifyAll();
		System.out.println("put notifyAll()...");
	}

	public synchronized int get() {
		try {
			while (!isNew) {
				System.out.println("get waiting()....");
				wait();
			}
		} catch (InterruptedException e) {
		}
		isNew = false;
		notifyAll();
		System.out.println("get notifyAll()...");
		return data;
	}
}
