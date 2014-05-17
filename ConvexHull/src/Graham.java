public class Graham extends Common {
	
	public int scan(Point1 p[], int n) {
		int i, min, M;
		for (min = 1, i = 2; i <= n; i++) {
			if (p[i].y < p[min].y)
				min = i;
		}
		for (i = 1; i <= n; i++) {
			if (p[i].y == p[min].y) {
				if (p[i].x > p[min].x)
					min = i;
				swap(p, 1, min);
			}
		}
		System.out.println();
		q_sort(p, 2, n);
		p[0] = p[n];
		for (M = 3, i = 4; i <= n; i++) {
			while (ccw(p[M], p[M - 1], p[i]) >= 0)
				M--;
			M++;
			swap(p, i, M);
		}
		return M;
	}
}
