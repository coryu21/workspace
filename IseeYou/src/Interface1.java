interface Inf1 {
	void mi1();
}

interface Inf2 {
	void mi2();
}

interface Inf3 extends Inf1, Inf2 {
	void mi3();
}

class A {
	public void mc1() {
		System.out.println("mc1()");
	}
}

class B extends A implements Inf3 {

	public void mi1() {
		System.out.println("mi1()");
	}

	public void mi2() {
		System.out.println("mi2()");
	}

	public void mi3() {
		System.out.println("mi3()");
	}
}

public class Interface1 {
	public static void main(String args[]) {
		Inf1 i1 = new B();
		//Inf2 i2 = (Inf2) i1;
		//i2 = (Inf3) i1;
		A a = (A) i1;
		B b = (B) i1;

		// i1.mi2(); 불가능 //i2.mi1(); 불가능 a.mc1(); b.mi3(); b.mc1();

//		a = new A();

		try {
			b = (B) a;
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(i1 instanceof B);
		System.out.println(a instanceof Inf1);
	}
}
