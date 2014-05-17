public class TwoDTreeSearch {
	Node head;
	Node z;
	Point1 dummy;

	int N = 16;
	int x_value[] = { 2, 12, 3, 10, 14, 1, 13, 6, 8, 7, 15, 16, 4, 11, 9, 5 };
	int y_value[] = { 6, 16, 12, 11, 4, 10, 8, 7, 9, 5, 3, 14, 15, 1, 13, 2 };
	char c_value[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
			'L', 'M', 'N', 'O', 'P' };

	public TwoDTreeSearch() {
		head = new Node();
		z = new Node();
		dummy = new Point1();
	}

	public boolean insiderect(Point1 p, Rect range) {
		return (p.x >= range.x1 && p.x <= range.x2)
				&& (p.y >= range.y1 && p.y <= range.y2);
	}

	public void insert(Point1 p) {
		Node f = null, t;
		boolean d, td = false;

		for (d = true, t = head; t != z; d = !d) {
			td = d ? (p.x < t.p.x) : (p.y < t.p.y);
			System.out.print((char)t.p.c);
			System.out.println((char)p.c);
			f = t;
			t = td ? t.l : t.r;
		}

		t = new Node();
		t.p = p;
		t.l = z;
		t.r = z;
		if (td) {
			f.l = t;
		} else {
			f.r = t;
		}
	}

	public int search(Rect range) {
		return searchr(head.r, range, false);
	}

	public int searchr(Node t, Rect range, boolean d) {
		System.out.println((char)t.p.c);
		int count = 0;
		boolean t1, t2, tx1, tx2, ty1, ty2;
		if (t == z)
			return 0;
		tx1 = range.x1 < t.p.x;
		tx2 = t.p.x <= range.x2;
		ty1 = range.y1 < t.p.y;
		ty2 = t.p.y <= range.y2;

		t1 = d ? tx1 : ty1;
		t2 = d ? tx2 : ty2;

		if (t1)
			count += searchr(t.l, range, !d);
		if (insiderect(t.p, range))
			count++;
		if (t2)
			count += searchr(t.r, range, !d);
		return count;
	}

	public static void main(String args[]) { // 인덱스 1부터 시작하게!
		TwoDTreeSearch tdt = new TwoDTreeSearch();

		Point1 p[] = new Point1[tdt.N + 1];
		Rect range = new Rect();
		int i, result;

		tdt.dummy.x = 0;
		tdt.dummy.y = 0;

		tdt.z.p = tdt.dummy;
		tdt.z.l = tdt.z;
		tdt.z.r = tdt.z;

		tdt.head.p = tdt.dummy;
		tdt.head.l = null;
		tdt.head.r = tdt.z;

		for (i = 1; i <= tdt.N; i++) {
			p[i] = new Point1();
			p[i].x = tdt.x_value[i - 1];
			p[i].y = tdt.y_value[i - 1];
			p[i].c = tdt.c_value[i - 1];
			System.out.println((char) p[i].c + "  " + p[i].x + ", " + p[i].y);
		}

		for (i = 1; i <= tdt.N; i++)
			tdt.insert(p[i]);
		range.x1 = 7;
		range.y1 = 10;
		range.x2 = 11;
		range.y2 = 16;
		result = tdt.search(range);
		System.out.println("범위 내에 있는 점의 개수 : " + result);
	}
}
