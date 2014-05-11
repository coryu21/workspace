package Basic;
public abstract class TwoDimensionalShape extends Shape {
	
	private double dimension1, dimension2;

	public TwoDimensionalShape(int x, int y, double d1, double d2) {
		super(x, y);
		setDimension1(d1);
		setDimension2(d2);
	}

	public void setDimension1(double d){
		this.dimension1 = d;
	}
	
	public void setDimension2(double d){
		this.dimension2 = d;
	}
	
	public double getDimension1(){
		return this.dimension1;
	}
	
	public double getDimension2(){
		return this.dimension2;
	}
	
	public abstract double area();
	//public abstract String toString();
}
