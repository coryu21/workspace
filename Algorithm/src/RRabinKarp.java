public class RRabinKarp {
	int num;
	int q, d;
	int jump;
	
	public RRabinKarp(int q, int d) {
		System.out.println("라빈-카프 알고리즘 객체가 생성되었습니다.");
		this.q = q;
		this.d = d;
	}

	public int index(char c) {
		return c;
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
			if (i+index >= t.length)
				return t.length;
			h1 = (h1 * d + index(p[i])) % q;
			h2 = (h2 * d + index(t[i+index])) % q;
		}

		for (i = index; h1 != h2; i++) {
			if (i+p.length >= t.length)
				return t.length;
			h2 = (h2 + d * q - index(t[i]) * dm) % q;
			h2 = (h2 * d + index(t[i + p.length])) % q;
			
		}
		return i;
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
			pos = rabinKarp(pattern, text, npos); // 탐색
			i = pos + pattern.length(); // 탐색이 끝났는지 아닌지를 판별하는 변수 i

			if (checkOverlap(pattern, text, pos)) { // 중복처리
				npos = pos + jump; // 중복처리가 일어나면 일어난 부분을 탐색 할 위치로 정한다.
			} else {
				npos = i; // 중복처리가 일어나지 않으면 찾은 문자열 다음 부분을 탐색 할 위치로 정한다.
			}

			if (i <= text.length()) {
				//System.out.println("패턴이 발생한 위치 : " + pos);
			} else {
				System.out.println("패턴 검색이 종료되었습니다..");
				break;
			}
		}
	}

	/*
	public static void main(String args[]) {
		RRabinKarp rrk = new RRabinKarp(33554393,32);
		String text = "ababab";
		String pattern = "abab";
		rrk.search(pattern, text);
	}
	*/
}
