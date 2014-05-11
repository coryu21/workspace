public class RRKMP {
	int next[];
	int n_next[];
	int jump;

	public RRKMP(int size) {
		System.out.println("KMP 알고리즘 객체가 생성되었습니다.");
		this.next = new int[size];
		this.n_next = new int[size - 1];
	}

	void initNext(String pattern) {
		char p[] = pattern.toCharArray();
		next[0] = -1;

		for (int i = 0, j = -1; i < p.length; i++, j++) {
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

	void initN_Next(String pattern) {
		char p[] = pattern.toCharArray();
		n_next[0] = -1;

		for (int i = 0, j = -1; i < p.length; i++, j++) {
			n_next[i] = j;
			while ((j >= 0) && (p[i] != p[j])) {
				j = n_next[j];
			}
		}
	}

	void createN_Next(String pattern) {
		initN_Next(pattern);

		for (int i = 1; i < pattern.length(); i++)
			System.out.print(n_next[i] + " ");

		System.out.println();
	}

	int rrkmp(String pattern, String text, int index) {
		char p[] = pattern.toCharArray();
		char t[] = text.toCharArray();
		int i = index;
		int j;

		for (j = 0; j < pattern.length() && i < text.length(); i++, j++) {
			while ((j >= 0) && (t[i] != p[j])) {
				j = n_next[j];
			}
		}

		if (j == pattern.length())
			return i - pattern.length();
		return i;
	}

	int check(String pattern, String text, int index) {
		String t_pattern; // 패턴 문자열을 잘라 저장할 변수
		String t_text; // 텍스트 문자열을 잘라 저장할 변수
		int npos = pattern.length(); // 패턴의 길이를 저장하는 변수
		for (int i = 1; i < pattern.length(); i++) { // 패턴의 두번째 문자열부터 반복문 실행
			t_pattern = pattern.substring(0, pattern.length() - i); // 패턴의 문자열을 자름
			if (index + pattern.length() >= text.length()) { // 검사할 값이 텍스트 길이를 넘어가면 리턴딘다
				return npos; 
			}
			t_text = text.substring(index + i, index + pattern.length()); // 텍스트의 문자열을 잘린 패턴의 길이만큼 자름
			if (t_pattern.equals(t_text)) { // 패턴과 텍스트의 문자열이 일치하면 몇번째인지를 반환
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

	void search(String pattern, String text) {
		int pos, i, npos;
		i = 0;
		npos = 0;
		while (true) {
			pos = rrkmp(pattern, text, npos);
			i = pos + pattern.length();

			if (checkOverlap(pattern, text, pos)) {
				npos = pos + jump;
			} else {
				npos = i;
			}

			if (i <= text.length()) {
				//System.out.println("패턴이 발생한 위치 : " + pos);
			} else {
				System.out.println("패턴 검색이 종료되었습니다..");
				break;
			}
		}
	}
}
