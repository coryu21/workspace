package Basic;

public class Circle extends TwoDimensionalShape{
	public Circle(int x, int y, double radius){
		super(x, y, radius, radius);
	}
	
	@Override
	public String getName() {
		return "Circle";
	}

	@Override
	public double area() {
		return Math.PI * super.getDimension1() * super.getDimension1();
	}

	public void setRadius(double radius){
		super.setDimension1(radius);
	}
	
	public double getRadius(){
		return super.getDimension1();
	}
/*
	@Override
	public String toString() {
		String print = "클래스 이름 : " + getName() + "  주명종/12101621";
		return print;
	}
	*/

}
