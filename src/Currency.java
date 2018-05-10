
public class Currency {

	private String name;
	private double price;
	private double tax;
	private double cost;
	
	public Currency(String name, double price, double tax, double cost) {
		super();
		this.name = name;
		this.price = price;
		this.tax = tax;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public double getTax() {
		return tax;
	}

	public double getCost() {
		return cost;
	}





}
