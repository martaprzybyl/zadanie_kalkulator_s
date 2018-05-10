
public class Currency {

	private String name;
	private double value;
	private double tax;
	private double cost;
	
	public Currency(String name, double value, double tax, double cost) {
		super();
		this.name = name;
		this.value = value;
		this.tax = tax;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public double getValue() {
		return value;
	}

	public double getTax() {
		return tax;
	}

	public double getCost() {
		return cost;
	}





}
