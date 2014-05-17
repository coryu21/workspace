public class Common {
	
	public void swap(Point1 p[], int i, int j) {
		Point1 t = p[i];
		p[i] = p[j];
		p[j] = t;
	}

	public float theta(Point1 p1, Point1 p2) {
		int dx, dy, ax, ay;
		float t;

		dx = p2.x - p1.x;
		ax = Math.abs(dx);
		dy = p2.y - p1.y;
		ay = Math.abs(dy);
		t = (ax + ay == 0) ? 0 : (float) dy / (ax + ay);

		if (dx < 0)
			t = 2 - t;
		else if (dy < 0)
			t = 4 + t;
		return (float) (t * 90.0);
	}
	
	public int ccw(Point1 p0, Point1 p1, Point1 p2) {
		int dx1, dx2, dy1, dy2;
		dx1 = p1.x - p0.x;
		dx2 = p2.x - p0.x;
		dy1 = p1.y - p0.y;
		dy2 = p2.y - p0.y;
		if (dx1 * dy2 > dx2 * dy1)
			return 1;
		if (dx1 * dy2 < dx2 * dy1)
			return -1;
		if ((dx1 == 0) && (dx2 == 0))
			return 0;
		if ((dx1 * dx2) < 0 || (dy1 * dy2) < 0)
			return -1;
		if ((dx1 * dx1 + dy1 * dy1) < (dx2 * dx2 + dy2 * dy2))
			return 1;
		return 0;
	}

	public int partition(Point1 p[], int l, int r) {
		int v = r;
		int p_l = l - 1;
		int p_r = r;
		while (true) {
			while ((theta(p[1], p[++p_l])) < (theta(p[1], p[v]))) {
				;
			}
			while ((theta(p[1], p[--p_r])) > (theta(p[1], p[v]))) {
				;
			}
			// 피벗보다 크면 r 값을 왼쪽으로 이동
			if (p_l >= p_r) // 교차하면 반복문을 빠져나감
				break;
			swap(p, p_l, p_r);
		}
		swap(p, p_l, r);
		return p_l;
	}

	public void q_sort(Point1 p[], int l, int r) {
		if (r > l) {
			int v = partition(p, l, r);
			q_sort(p, l, v - 1); // 피벗의 위치 왼쪽 정렬
			q_sort(p, v + 1, r); // 피벗의 위치 오른쪽 정렬
		}
	}
	
	public boolean intersect(Line l1, Line l2){
		if (((ccw(l1.p1, l1.p2, l2.p1) * ccw(l1.p1, l1.p2, l2.p2))<=0) && ((ccw(l2.p1, l2.p2, l1.p1)* ccw(l2.p1, l2.p2, l1.p2))<=0)){
			return true;
		}else{
			return false;
		}
	}
	
}
