package Basic;

public class FruitTest {
	public static void main(String args[]){
		Payable fruits[] = new Payable[6];
		int total = 0;
		double average;
		
		fruits[0] = new Apple("철수", 1000);
		fruits[1] = new Banana("영희", 500);
		fruits[2] = new Lemon("영수", 1500);
		fruits[3] = new Banana("미희", 700);
		fruits[4] = new Apple("영호", 1200);
		fruits[5] = new Lemon("지수", 2300);
		
		System.out.println("<<< 아이들이 가지고 있는 과일의 가격 >>>");
		
		for(Payable fs : fruits){
			System.out.println(fs.getOwner() + "가 가진 " + fs.Edible());
			System.out.println("이 과일의 가격은 " + fs.getPrice() +"원입니다.");
			total += fs.getPrice();
		}
		
		average = total /  fruits.length;
		
		System.out.println("아이들이 가지고 있는 과일의 갯수 : " + fruits.length);
		System.out.println("아이들이 가지고 있는 과일들의 가격의 합 : " + total);
		System.out.println("아이들이 가지고 있는 과일들의 가격의 평균 : " + average);
		
		
	}

}
