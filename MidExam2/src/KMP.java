public class KMP {

	int next[];

	public KMP() {
	}

	public void initNext(String pattern) {
		next = new int[pattern.length()];
		next[0] = -1;
		for (int i = 1, j = 0; i < pattern.length(); i++, j++) {
			// next[i] = j;
			next[i] = (pattern.charAt(i) == pattern.charAt(j)) ? next[j] : j;
			while (j >= 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = next[j];
			}
		}
		System.out.print("패턴 : " + pattern + "\tnext[] : ");
		for (int i = 1; i < next.length; i++) {
			System.out.print(next[i] + " ");
		}
		System.out.println();
	}

	public int kmp(String text, String pattern, int pos) {
		int i = 0, j = 0;
		initNext(pattern);
		for (i = pos, j = 0; j < pattern.length() && i < text.length(); i++, j++) {
			while((j>=0) && (text.charAt(i) != pattern.charAt(j))) j = next[j];
		}
		if(j==pattern.length()) return i-pattern.length();
		else return i;
	}

	public void search(String text, String pattern) {
		int pos, i, next = 0;
		while (true) {
			pos = kmp(text, pattern, next);
			next = pos + pattern.length();
			if (pos < text.length()) {
				System.out.println("패턴이 발새한 위치 : " + pos);
			} else {
				break;
			}
		}
	}

	public static void main(String args[]) {
		new KMP().search("ababababcababababcaabbabababcaab", "abababca");
	}
}