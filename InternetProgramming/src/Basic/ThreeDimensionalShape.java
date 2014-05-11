package Basic;

public abstract class ThreeDimensionalShape extends Shape{
	private double dimension1, dimension2, dimension3;

	public ThreeDimensionalShape(int x, int y, double d1, double d2, double d3) {
		super(x, y);
		setDimension1(d1);
		setDimension2(d2);
		setDimension3(d3);
	}

	public void setDimension1(double d){
		this.dimension1 = d;
	}
	
	public void setDimension2(double d){
		this.dimension2 = d;
	}
	
	public void setDimension3(double d){
		this.dimension3 = d;
	}
	
	public double getDimension1(){
		return this.dimension1;
	}
	
	public double getDimension2(){
		return this.dimension2;
	}
	
	public double getDimension3(){
		return this.dimension3;
	}
	
	public abstract double area();
	public abstract double volume();
	//public abstract String toString();
}
