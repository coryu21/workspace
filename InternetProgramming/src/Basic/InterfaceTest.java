package Basic;

interface Inf1 {
	void mi1();
}

interface Inf2 {
	void mi2();
}

interface Inf3 extends Inf1, Inf2 {
	void mi3();
}

interface Inf4 {
	void mi4();
}

class A {
	public void mc1() {
		System.out.println("mic()");
	}
	/*
	 * public void mi2() { System.out.println("mi2()"); }
	 * 
	 * public void mi3() { System.out.println("mi3()"); }
	 * 
	 * public void mi4() { System.out.println("mi4()"); }
	 */
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

class C {
	public void mcC() {
		System.out.println("mcccc");
	}
}

public class InterfaceTest {
	public static void main(String args[]) {
		/*
		
		A a = new B();
		a.mc1();
		//B b = new A();
		//B b = (B)new A();
		
		//B b = new C();
		//Inf1 i1 = new B();
		//i1.mi1();
		//i1.mc1();
		
		Inf1 i1 = new B();
		Inf2 i2 = (Inf2)i1;
		Inf4 i4 = (Inf4) i1;
		i2.mi2();
		i4.mi4();
		
		*/
		
		Inf1 in1 = (Inf1) new C();
		//Inf1 in1 = (Inf1) new Double();
		//Inf i1 = new C();
		//Inf1 i1 = (Inf1)new C();
		/*
		 * A a = new A(); //Inf1 i1 = a; Inf3 i3 = a; Inf2 i2 = i3; Inf4 i4 = a;
		 * i3.mi1(); i3.mi2(); i3.mi3(); //i3.mi4();
		 */
		/*
		Inf1 i1 = new B();
		Inf2 i2 = (Inf2) i1;
		i2 = (Inf3) i1;
		A a = (A) i1;
		B b = (B) i1;

		// i1.mi2();
		// i2.mi1();
		a.mc1();
		b.mi3();
		b.mi1();

		a = new A();

		try {
			b = (B) a;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(i1 instanceof B);
		System.out.println(a instanceof B);
	*/
	}
}
