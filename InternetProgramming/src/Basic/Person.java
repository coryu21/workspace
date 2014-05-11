package Basic;

public class Person {
	protected String name;
	protected int age;
	
	public Person(){
		setName("");
		setAge(0);
	}
	
	public Person(String name, int age){
		setName(name);
		setAge(age);
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}
