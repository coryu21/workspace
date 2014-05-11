package Basic;
public class StuTest {
	public static void main(String args[]) {
		Student students[] = new Student[3];
		students[0] = new Student("kim", 20, 99);
		students[1] = new Student("park", 21, 93);
		students[2] = new Student("lee", 23, 85);

		for (int i = 0; i < students.length; i++) {
			System.out.println("ID : " + students[i].getMyID() + ", 이름 : "
					+ students[i].getName() + ", 나이 : " + students[i].getAge()
					+ ", 점수 : " + students[i].getScore());
		}
	}
}
