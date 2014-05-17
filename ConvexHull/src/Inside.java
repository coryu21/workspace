public class Inside extends Common {
	int N = 16;
	int x_value[] = { 2, 12, 3, 10, 14, 1, 13, 6, 8, 7, 15, 16, 4, 11, 9, 5 };
	int y_value[] = { 6, 16, 12, 11, 4, 10, 8, 7, 9, 5, 3, 14, 15, 1, 13, 2 };
	char c_value[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
			'L', 'M', 'N', 'O', 'P' };

	public int inside(Point1 t, Point1 p[], int n) {
		int i, count = 0, j = 0;
		Line lt = new Line(), lp = new Line();
		p[0] = p[n];
		System.out.println((char)p[n].c);
		p[n + 1] = p[1];
		lt.p1 = t;
		lt.p2 = new Point1();
		lt.p2.x = 1000;
		lt.p2.y = t.y;
		for (i = 1; i <= n+1; i++) {
			lp.p1 = p[i];
			lp.p2 = p[i];
			if (!intersect(lp, lt)) {
				lp.p2 = p[j];
				j = i;
				System.out.print((char) lp.p1.c);
				System.out.print((char) lp.p2.c);
				System.out.println();
				if (intersect(lp, lt))
					count++;
			}
		}
		System.out.println(count);
		System.out.println(count & 1);
		return count & 1;
	}

	public static void main(String args[]) { // 인덱스 1부터 시작하게!
		Inside is = new Inside();

		int i, min, result;
		Point1 t;
		Point1 p[] = new Point1[is.N + 2];
		p[0] = new Point1();
		for (i = 1; i <= is.N; i++) {
			p[i] = new Point1();
			p[i].x = is.x_value[i - 1];
			p[i].y = is.y_value[i - 1];
			p[i].c = is.c_value[i - 1];
			System.out.println((char) p[i].c + "  " + p[i].x + ", " + p[i].y);
		}

		for (min = 1, i = 2; i <= is.N; i++) {
			if (p[i].y < p[min].y)
				min = i;
		}
		is.swap(p, 1, min);
		is.q_sort(p, 2, is.N);

		t = new Point1();
		t.x = 10;
		t.y = 5;

		if (t.x <= 0 && t.y == 0)
			return;
		result = is.inside(t, p, is.N);

		if (result > 0)
			System.out.println("다각형 내부");
		else
			System.out.println("다각형 외부");

	}

}
