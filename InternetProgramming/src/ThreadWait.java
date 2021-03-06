public class ThreadWait {
	public static void main(String args[]) {
		SharedData shared = new SharedData();
		new Consumer(shared).start();
		new Consumer(shared).start();
		new Producer(shared, 25).start();
	}
}

class SharedData {
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

class Producer extends Thread {
	private SharedData shared;
	private int data;

	public Producer(SharedData shared, int data) {
		this.shared = shared;
		this.data = data;
	}

	public void run() {
		shared.put(data);
		shared.put(data + 1);
	}
}

class Consumer extends Thread {
	private SharedData shared;

	public Consumer(SharedData shared) {
		this.shared = shared;
	}

	public void run() {
		while (true) {
			System.out.println(getName() + " got " + shared.get());
		}
	}
}
