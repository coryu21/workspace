public class BoyerMoore {
	int skip[];
	int num;
	int jump;
	public BoyerMoore(int num) {
		System.out.println("보이어 무어 알고리즘 객체가 생성되었습니다.");
		this.num = num;
		this.jump = 0;
		skip = new int[this.num];
	}

	public int index(char c) {
		if (c == 32)
			return 0;
		else
			return (c - 64);
	}

	public void initSkip(String pattern) {
		char p[] = pattern.toCharArray();
		for (int i = 0; i < num; i++)
			skip[i] = p.length;
		for (int i = 0; i < p.length; i++)
			skip[index(p[i])] = p.length - i - 1;
	}

	public int misChar(String pattern, String text, int index) {
		char p[] = pattern.toCharArray();
		char t[] = text.toCharArray();
		int i, j, k;

		for (i = p.length - 1 + index, j = p.length - 1; j >= 0; i--, j--) {
			while (i < t.length && t[i] != p[j]) {
				k = skip[index(t[i])];
				i += (p.length - j > k) ? p.length - j : k;
				if (i >= t.length)
					return t.length;
				j = p.length - 1;
			}
		}
		return i + 1;
	}

	int check(String pattern, String text, int index) {
		String t_pattern;
		String t_text;
		int npos = pattern.length();
		for (int i = 1; i < pattern.length(); i++) {
			t_pattern = pattern.substring(0, pattern.length() - i);
			if (index + pattern.length() >= text.length()) {
				return npos;
			}
			t_text = text.substring(index + i, index + pattern.length());
			if (t_pattern.equals(t_text)) {
				npos = i;
				return npos;
			}
		}
		return npos; // 중복체크
	}

	Boolean checkOverlap(String pattern, String text, int index) {
		int j = check(pattern, text, index);
		if (j < pattern.length()) {
			jump = j;
			return true;
		}
		return false;
	}
	
	public void search(String pattern, String text) {
		int pos, i, npos;
		i = 0;
		npos = 0;
		while (true) {
			pos = misChar(pattern, text, npos);
			i = pos + pattern.length();
			
			if (checkOverlap(pattern, text, pos)) {
				npos = pos + jump;
			} else {
				npos = i;
			}
			if (i <= text.length()) {
				System.out.println("패턴이 발생한 위치 : " + pos);
			} else {
				System.out.println("패턴 검색이 종료되었습니다..");
				break;
			}
		}
	}


	public static void main(String args[]) {
		BoyerMoore bm = new BoyerMoore(128);
		String pattern = "zx zx";
		String text = "zx zx zx";
		bm.initSkip(pattern);
		bm.search(pattern, text);
	}
}
