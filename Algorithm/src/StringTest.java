public class StringTest {
	RRabinKarp rrk;
	RBoyerMoore rbm;
	RRKMP rk;
	String text;
	long startTime; // 탐색 전 현재 시간을 받는다
	long endTime; // 탐색 후 현재 시간을 받는다
	long executeTime1; // 탐색 후 시간 - 정렬 전 시간으로 소요 시간을 구한다
	long executeTime2;
	long executeTime3;
	int size;

	public StringTest(int size) {
		System.out.println("String test 객체 생성!");
		this.size = size;
		rrk = new RRabinKarp(33554393,32);
		rbm = new RBoyerMoore(128);
		rk = new RRKMP(128);
	}

	public void createText() {
		char t[] = new char[this.size];
		char textArr[] = {'a', 'b', '1', '2', '$', '%'};
		for (int i = 0; i < this.size; i++) {
			//int value = (int) (Math.random() * 94) + 33;
			int value = (int) (Math.random() * 6);
			t[i] = textArr[value];
			//System.out.print(t[i]);
		}
		//System.out.println();
		this.text = String.valueOf(t);
		//System.out.println(text);
	}
	
	public void test(String pattern){
		createText(); // 탐색할 텍스트 생성
		
		System.out.println("<< KMP 탐색 >>");
		startTime = System.nanoTime(); // 탐색 전 시간
		rk.initN_Next(pattern);
		rk.search(pattern, this.text);
		endTime = System.nanoTime(); // 탐색 후 시간
		executeTime1 = endTime - startTime; // 탐색에 걸리는 시간
		System.out.println("TIME : " + executeTime1 + "(ns)");
		
		System.out.println("<< Boyer-Moore 탐색 >>");
		startTime = System.nanoTime();
		rbm.initSkip(pattern);
		rbm.search(pattern, text);
		endTime = System.nanoTime();
		executeTime2 = endTime - startTime;
		System.out.println("TIME : " + executeTime2 + "(ns)");
		
		System.out.println("<< RabinKarp 탐색 >>");
		startTime = System.nanoTime();
		rrk.search(pattern, text);
		endTime = System.nanoTime();
		executeTime3 = endTime - startTime;
		System.out.println("TIME : " + executeTime3 + "(ns)");
	}
	
	public static void main(String args[]){
		StringTest st = new StringTest(10000000);
		st.test("a1a1");
		
	}
}
