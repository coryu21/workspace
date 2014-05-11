public class KMP {
	int next[];

	public KMP(int size) {
		System.out.println("KMP 알고리즘 객체가 생성되었습니다.");
		this.next = new int[size];
	}

	void initNext(String pattern) {
		char p[] = pattern.toCharArray();
		next[0] = -1;

		for (int i = 0, j = -1; i < p.length; i++, j++) {
			if (j >= 0 && p[i] == p[j])
				next[i] = next[j];
			else
				next[i] = j;
			while ((j >= 0) && (p[i] != p[j])) {
				j = next[j];
			}
		}
	}

	void createNext(String pattern) {
		initNext(pattern);

		for (int i = 1; i < pattern.length(); i++)
			System.out.print(next[i] + " ");

		System.out.println();
	}

	int KMP(String pattern, String text, int index) {
		char p[] = pattern.toCharArray();
		char t[] = text.toCharArray();
		int i = index;
		int j;

		for (j = 0; j < pattern.length() && i < text.length(); i++, j++) {
			while ((j >= 0) && (t[i] != p[j])) {
				j = next[j];
			}
		}

		if (j == pattern.length())
			return i - pattern.length() - index;
		return i;
	}

	void search(String pattern, String text) {
		int pos, previous, i;
		previous = 0;
		i = 0;

		while (true) {
			pos = KMP(pattern, text, i);
			pos += previous;
			i = pos + pattern.length();
			if (i <= text.length()) {
				System.out.println("패턴이 발생한 위치 : " + pos);
			} else {
				System.out.println("패턴 검색이 종료되었습니다..");
				break;
			}
			previous = i;
		}
	}

	public static void main(String args[]) {
		KMP k = new KMP(50);
		String text = "ababababcababababcaabbabababcaab";
		// ababababcababababcaabbabababcaab
		String pattern = "aba";
		// abababca
		k.createNext(pattern);
		k.search(pattern, text);
	}
}
