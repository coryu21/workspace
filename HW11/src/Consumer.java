public class Consumer extends Thread {
	Counter c;
	int num;
	public Consumer(Counter c, int n) {
		this.c = c;
		this.num = n;
	}

	public void run() {
		for (int i = 0; i < num; i++) {
			c.decrement();
			System.out.println(getName() + " decrease");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println(c.getCount());
			}
		}
	}

}
