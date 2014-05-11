public class MethodChaining {
	private int value;

	public MethodChaining(int value) {
		this.value = value;
	}

	public MethodChaining increment() {
		this.value += 1;
		return this;
	}

	public MethodChaining add(int value) {
		this.value += value;
		return this;
	}

	public void shout() {
		System.out.println(this.value);
	}
	
	public static void main(String args[]){
		MethodChaining mc = new MethodChaining(1);
		mc.increment();
		mc.add(3);
		mc.shout();
	}
}
