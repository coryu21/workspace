package Basic;
public class Cube extends ThreeDimensionalShape {

	public Cube(int x, int y, double side) {
		super(x, y, side, side, side);
	}

	@Override
	public String getName() {
		return "Cube";
	}

	@Override
	public double area() {
		return 6 * super.getDimension1() * super.getDimension1();
	}

	@Override
	public double volume() {
		return super.getDimension1() * super.getDimension1()
				* super.getDimension1();
	}

	public void setSide(double side) {
		super.setDimension1(side);
	}

	public double getSide() {
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
