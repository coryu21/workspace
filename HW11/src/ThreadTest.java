public class ThreadTest {

	public static void main(String args[]) {
		Counter c = new Counter();
		int number = 20;
		new Consumer(c, number).start();
		new Consumer(c, number).start();
		new Producer(c, number).start();
		new Producer(c, number).start();
	}

}
