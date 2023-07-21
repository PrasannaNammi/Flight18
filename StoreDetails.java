
package products;

public class StoreDetails {
	private String name;
	private int price;
	private int qoh;

	public StoreDetails(String name, int price, int qoh) {
		this.name = name;
		this.price = price;
		this.qoh = qoh;
	}

	public String name() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void sale(int units) {
		if (this.qoh >= units) {
			qoh = units;
			System.out.println(units);
		} else {
			System.out.println("Quantity insufficient");
		}
	}

	public void purchase(int units) {
		this.qoh = this.qoh + units;
		System.out.println("purchase");
	}

	public int getNetPrice() {
		return price * qoh;
	}

	public void print() {
		System.out.println(this.name);
		System.out.println(this.price);
		System.out.println(this.qoh);
	}
}