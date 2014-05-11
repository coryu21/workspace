public class Information { // 클래스의 객체는 하나의 데이터
	private String name, id, sns;
	
	public Information(String name, String id, String sns){
		this.name = name;
		this.id = id;
		this.sns = sns;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public void setSns(String sns){
		this.sns = sns;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getSns(){
		return this.sns;
	}
}
