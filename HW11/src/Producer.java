public class Producer extends Thread {
	Counter c;
	int num;
	public Producer(Counter c, int n) {
		this.c = c;
		this.num = n;
	}

	public void run() {
		for (int i = 0; i < num; i++) {
			c.increment();
			System.out.println(getName() + " increase");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println(c.getCount());
			}
		}
	}
}
