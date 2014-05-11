package Basic;

public abstract class Shape {
	private int x, y;
	
	public Shape(int x, int y){
		setX(x);
		setY(y);
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y =y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public abstract String getName();
	//public abstract String toString();

	public String toString() {
		String print = "클래스 이름 : " + getName() + "  주명종/12101621";
		return print;
	}
}
