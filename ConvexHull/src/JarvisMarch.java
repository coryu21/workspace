public class JarvisMarch extends Common{
	public int PackageWrapping(Point1 p[], int n) {
		int i, min, M;
		float th, v;
		for (min = 0, i = 1; i < n; i++) { 
			if (p[i].y < p[min].y)
				min = i;
		}
		p[n] = p[min];
		th = (float) 0.00;
		for (M = 0; M < n; M++) {
			swap(p, M, min);
			min = n;
			v = th;
			th = (float) 360.0;

			for (i = M + 1; i <= n; i++) {
				if (theta(p[M], p[i]) > v) {
					if (theta(p[M], p[i]) < th) {
						min = i;
						th = theta(p[M], p[min]);
					}
				}
			}
			if (min == n)
				return M;
		}
		return 0;
	}
}