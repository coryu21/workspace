package Basic;

class Car{
	private int speed;
	
	public Car(){
		setSpeed(0);
	}
	
	public void setSpeed(int a){
		speed = a;
	}
	
	public int getSpeed(){
			return speed;
	}
}
public class Hello {
	public static void main(String args[]){
		Car c1 = new Car();
		String s = c1.toString();
		
		System.out.println(s);
	}
}
