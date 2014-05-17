public class PatternMatching {
	Deque dq = new Deque();
	int scan = -1;
	char ch[] = { ' ', 'A', ' ', 'B', ' ', ' ', 'A', 'C', 'D', ' ' };
	int next1[] = { 5, 2, 3, 4, 8, 6, 7, 8, 9, 0 };
	int next2[] = { 5, 2, 1, 4, 8, 2, 7, 8, 9, 0 };

	void insertFirst(int v) {
		dq.deque[dq.first--] = v;
	}

	void insertLast(int v) {
		dq.deque[++dq.last] = v;
	}

	int deleteFirst() {
		dq.deque[dq.first] = 0;
		return dq.deque[++dq.first];
	}

	boolean isEmpty() {
		if (dq.first == dq.last)
			return true;
		else
			return false;
	}

	int match(String t) {
		int n1, n2;
		int i, j = 0, N = t.length(), state = next1[0];
		dq.first = 50;
		dq.last = 50;
		for (i = 0; i < 100; i++) {
			dq.deque[i] = 0;
			insertLast(scan);
			while (state != 0) {
				if (state == scan) {
					j++;
					if (isEmpty())
						insertFirst(next1[0]);
					insertLast(scan);
				} else if (ch[state] == t.charAt(j)) {
					insertLast(next1[state]);
				} else if (ch[state] == ' ') {
					n1 = next1[state];
					n2 = next2[state];
					insertFirst(n1);
					if (n1 != n2)
						insertFirst(n2);
				}
				if (isEmpty()) // 언제빠져나오지?
					return j;
				if (j > N)
					return 0;
				state = deleteFirst();
			}
		}
		return j - 1;
	}

	public static void main(String args[]) {
		PatternMatching pm = new PatternMatching();
		String text = "AAABD ";

		int N, pos, previous = 0, i = 0;
		N = text.length();
		while (true) {
			pos = pm.match(text);
			if (pos == 0)
				break;
			pos += previous;
			i = pos;
				//text = text.substring(i);
			System.out.println(text);
			if (i <= text.length()) {
				System.out.println("패턴이 발생한 위치 : " + pos);
			} else {
				System.out.println("패턴 검색이 종료되었습니다..");
				break;
			}
			previous = i;
		}

	}
}

class Deque {
	int deque[];
	int first, last;

	Deque() {
		deque = new int[200];
	}
}