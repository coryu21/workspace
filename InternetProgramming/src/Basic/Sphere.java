package Basic;
public class Sphere extends ThreeDimensionalShape {

	public Sphere(int x, int y, double radius) {
		super(x, y, radius, radius, radius);
	}

	@Override
	public String getName() {
		return "Sphere";
	}

	@Override
	public double area() {
		return Math.PI * super.getDimension1() * super.getDimension1();
	}

	@Override
	public double volume() {
		return Math.PI * super.getDimension1() * super.getDimension1()
				* super.getDimension1();
	}

	public void setRadius(double radius) {
		super.setDimension1(radius);
	}

	public double getRadius() {
		return super.getDimension1();
	}
}
