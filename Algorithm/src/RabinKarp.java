public class RabinKarp {
	int num;
	int q, d;

	public RabinKarp(int q, int d) {
		System.out.println("라빈-카프 알고리즘 객체가 생성되었습니다.");
		this.q = q;
		this.d = d;
	}

	public int index(char c) {
		if (c == 32)
			return 0;
		else
			return (c - 64);
	}

	public int rabinKarp(String pattern, String text, int index) {
		char p[] = pattern.toCharArray();
		char t[] = text.toCharArray();
		int i, dm = 1, h1 = 0, h2 = 0;
		
		if (index >= text.length()) {
			return index + 1;
		}
		
		for (i = 1; i < p.length; i++)
			dm = (d * dm) % q;
		
		for (i = 0; i < p.length; i++) {
			h1 = (h1 * d + index(p[i])) % q;
			h2 = (h2 * d + index(t[i + index])) % q;
		}

		for (i = index; h1 != h2; i++) {
			h2 = (h2 + d * q - index(t[i]) * dm) % q;
			h2 = (h2 * d + index(t[i + p.length])) % q;
			if (i > t.length - p.length)
				return t.length;
		}
		return i;
	}

	public void search(String pattern, String text) {
		int i = 0, pos;
		while (true) {
			pos = rabinKarp(pattern, text, i);
			i = pos + pattern.length();
			if (i <= text.length()) {
				System.out.println("패턴이 발생한 위치 : " + pos);
			} else {
				System.out.println("패턴 검색이 종료되었습니다..");
				break;
			}
		}
	}

	public static void main(String args[]) {
		RabinKarp rk = new RabinKarp(33554393, 32);
		String pattern = "ab";
		String text = "ababab";
		rk.search(pattern, text);
	}
}
