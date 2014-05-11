package Basic;

public class Square extends TwoDimensionalShape{
	
	public Square(int x, int y, double side){
		super(x, y, side, side);
	}

	@Override
	public String getName() {
		return "Square";
	}
	
	@Override
	public double area() {
		return super.getDimension1() * super.getDimension1();
	}
	
	public void setSide(double side){
		super.setDimension1(side);
	}
	
	public double getSide(){
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
