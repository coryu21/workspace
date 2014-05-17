import java.util.ArrayList;
import java.util.Collections;

public class TestConvexHull {
	private JarvisMarch jm;
	private Graham gra;
	private Point1 p1[];
	private Point1 p2[];
	
	private int size;
	private long exectueTime1;
	private long exectueTime2;
	
	public TestConvexHull() {
		jm = new JarvisMarch();
		gra = new Graham();
	}

	public void test() {
		int m1;
		int m2;
		long startTime; 
		long endTime;
		
		startTime = System.currentTimeMillis();
		m1 = jm.PackageWrapping(p1, size);
		endTime = System.currentTimeMillis();
		exectueTime1 = endTime - startTime;
		System.out.println();

		startTime = System.currentTimeMillis();
		m2 = gra.scan(p2, size);
		endTime = System.currentTimeMillis();
		exectueTime2 = endTime - startTime;
		
		System.out.println("짐꾸리기 알고리즘 실행시간 : " + exectueTime1);
		System.out.println("그라함 스캔 알고리즘 실행시간 : " + exectueTime2);
	}

	public void makePoint(int size) {
		this.size = size;
		ArrayList<Integer> x_random = new ArrayList<Integer>();
		ArrayList<Integer> y_random = new ArrayList<Integer>();
		ArrayList<String> c_random = new ArrayList<String>();
		
		p1 = new Point1[size + 1];
		p2 = new Point1[size + 1];

		for (int i = 1; i <= size; i++) {
			x_random.add(i);
			y_random.add(i);
			c_random.add("점" + Integer.toString(i));
		}

		Collections.shuffle(x_random);
		Collections.shuffle(y_random);

		p2[0] = new Point1();

		for (int i = 0; i < size; i++) {
			p1[i] = new Point1();
			p2[i + 1] = new Point1();
			p1[i].x = x_random.get(i);
			p1[i].y = y_random.get(i);
			p1[i].c = c_random.get(i);
			p2[i + 1].x = x_random.get(i);
			p2[i + 1].y = y_random.get(i);
			p2[i + 1].c = c_random.get(i);
		}
	}

	public static void main(String args[]) {
		TestConvexHull tch = new TestConvexHull();
		tch.makePoint(1000);
		tch.test();
	}

}
