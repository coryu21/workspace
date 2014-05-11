package Basic;
public class Plane {
	private static int numOfPlanes = 0;
	private int number;
	private String model;
	private int peoples;

	public Plane() {
		setNumber(0);
		setModel(null);
		setPeoples(0);
		numOfPlanes++;
		System.out.println("<식별번호> : " + getNumber() + " <모델> : " + getModel()
				+ " <승객수> : " + getPeoples() + "인 비행기가 생성되었습니다");
	}

	public Plane(int number) {
		super();
		numOfPlanes++;
		setNumber(number);
		System.out.println("<식별번호> : " + getNumber() + " <모델> : " + getModel()
				+ " <승객수> : " + getPeoples() + "인 비행기가 생성되었습니다");
	}

	public Plane(int number, String model) {
		super();
		numOfPlanes++;
		setNumber(number);
		setModel(model);
		System.out.println("<식별번호> : " + getNumber() + " <모델> : " + getModel()
				+ " <승객수> : " + getPeoples() + "인 비행기가 생성되었습니다");
	}

	public Plane(int number, String model, int peoples) {
		super();
		numOfPlanes++;
		setNumber(number);
		setModel(model);
		setPeoples(peoples);
		System.out.println("<식별번호> : " + getNumber() + " <모델> : " + getModel()
				+ " <승객수> : " + getPeoples() + "인 비행기가 생성되었습니다");
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPeoples() {
		return peoples;
	}

	public void setPeoples(int peoples) {
		this.peoples = peoples;
	}

	public static int getPlaens() {
		return numOfPlanes;
	}
	
	public static void setPlaens(int num) {
		numOfPlanes = num;
	}

	public String toString() {
		String out = "<식별번호> : " + getNumber() + " <모델> : " + getModel()
				+ " <승객수> : " + getPeoples() + "인 비행기입니다";
		return out;
	}

	public static void main(String argsp[]) {
		Plane PlaneTest[] = new Plane[4];

		System.out.println("비행기 수 : " + Plane.getPlaens());
		PlaneTest[0] = new Plane();
		System.out.println("비행기 수 : " + Plane.getPlaens());
		PlaneTest[1] = new Plane(1);
		System.out.println("비행기 수 : " + Plane.getPlaens());
		PlaneTest[2] = new Plane(2, "인하대호");
		System.out.println("비행기 수 : " + Plane.getPlaens());
		PlaneTest[3] = new Plane(3, "인경호", 100);
		System.out.println("비행기 수 : " + Plane.getPlaens());
		
		
		System.out.println("\n\n<총 비행기 명단을확인합니다>");

		for (int i = 0; i < PlaneTest.length; i++) {
			System.out.println(PlaneTest[i]);
		}
		
		PlaneTest[2].setPeoples(200);
		System.out.println("PlaneTest[2] 승객 수 : " + PlaneTest[2].getPeoples());
		PlaneTest[1].setPeoples(100);
		System.out.println("PlaneTest[1] 승객 수 : " + PlaneTest[1].getPeoples());
		
		
	}
}
