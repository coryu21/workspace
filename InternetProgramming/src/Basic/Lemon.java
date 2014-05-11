package Basic;
public class Lemon implements Payable {
	private String owner;
	private int price;

	public Lemon(String owner, int price) {
		this.owner = owner;
		this.price = price;
	}

	@Override
	public String Edible() {
		return "레몬은 먹을 수 있습니다.";
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