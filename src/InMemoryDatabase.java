import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabase {

	private static List<Currency> currencies = new ArrayList<Currency>();

	static {
		currencies.add(new Currency("GBP", 3.56, 25, 600));
		currencies.add(new Currency("EUR", 4.25, 20, 800));
		currencies.add(new Currency("PLN", 1, 19, 1200));
	}

	public static List<Currency> getCurrencies() {
		return currencies;
	}

	public static String[] getCurrenciesAsString() {
		String[] currenciesName = new String[currencies.size()];

		for (int i = 0; i < currencies.size(); i++) {
			String name = currencies.get(i).getName();
			currenciesName[i] = name;
		}
		return currenciesName;

	}

	public static Currency getCurrencyByName(String currency) {
		for (int i = 0; i < currencies.size(); i++) {
			if (currencies.get(i).getName().equals(currency)) {
				return currencies.get(i);
			}
		}
		return null;

	}

	public static void addCurrency(String name, double price, double tax, double cost) {
		currencies.add(new Currency(name,price,tax,cost));
	}

}
