package Basic;
public class test {
	public void print() {
		System.out.println("부모");
	}

	public static void main(String args[]) {
		test t = new test();
		test t1 = new child();
		child t2 = new child();
		child t3 = (child) new test();
		
		t.print();
		t1.print();
		t2.print();
		//t3.print();
	}

}

class child extends test {
	public void print() {
		System.out.println("자식");
	}
}
