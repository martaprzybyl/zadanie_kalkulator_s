import java.util.ArrayList;
import java.util.List;

//poczatkowa baza
public class InMemoryDatabase {

	private static List<Currency> currencies = new ArrayList<Currency>();

	static {
		currencies.add(new Currency("GBP", 34.5, 3, 500));
		currencies.add(new Currency("EUR", 3, 5, 330));
		currencies.add(new Currency("PLN", 6, 3, 880));
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

}
