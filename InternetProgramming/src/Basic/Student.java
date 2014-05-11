package Basic;

public class Student extends Person{
	private static int ID = 1;
	private int myID;
	private int score;
	
	public Student(){
		this("noname", 0, 0);
	}
	
	public Student(String name, int age, int score){
		super(name, age);
		setScore(score);
		setMyID(getID());
		setID();
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public int getScore(){
		return this.score;
	}
	
	public void setAge(int age){
		super.setAge(age);
	}
	
	public int getAge(){
		return super.getAge();
	}
	
	public void setName(String name){
		super.setName(name);
	}
	
	public String getName(){
		return super.getName();
	}
	
	public static void setID(){
		ID += 1;
	}
	
	public static int getID(){
		return ID;
	}

	public void setMyID(int ID){
		this.myID = getID();
	}
	
	public int getMyID(){
		return this.myID;
	}
}
