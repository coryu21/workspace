package Basic;
public class Apple implements Payable {
	private String owner;
	private int price;

	public Apple(String owner, int price) {
		this.owner = owner;
		this.price = price;
	}

	@Override
	public String Edible() {
		return "사과는 먹을 수 있습니다.";
	}

	@Override
	public String getOwner() {
		return this.owner;
	}

	@Override
	public int getPrice() {
		return this.price;
	}
}
