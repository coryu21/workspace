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
		System.out.println("mi1()");
	}
	public void INT(int a){
		System.out.println(a);
	}
}

class B extends A implements Inf3 {

	public void mc1() {
		System.out.println("mic1()");
	}

	public void mi2() {
		System.out.println("mi2()");
	}

	public void mi3() {
		System.out.println("mi3()");
	}
	
	public void INT(double a){
		System.out.println(a);
	}

	@Override
	public void mi1() {
		// TODO Auto-generated method stub
		
	}
}

class C {
	public void mcC() {
		System.out.println("mcC()");
	}
}

public class Interface1{
	public static void main(String args[]){
		Inf1 i1 = new B();
		//Inf4 i4 = (Inf4)i1;
		A a = new B();
		a = (A)a;
		a.mc1();
	}
}
