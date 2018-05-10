import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Frame extends JFrame implements ActionListener {

	JButton button;
	JButton convert;
	JTextField TextAmount;
	JTextField name;
	JLabel jName;
	JTextField price;
	JLabel jPrice;
	JTextField tax;
	JLabel jTax;
	JTextField cost;
	JLabel jCost;
	JTextField result;
	JLabel enter;
	JLabel enter2;
	JLabel enter3;
	JLabel show;
	double amount;
	public List<Currency> currencies;
	public List<JTextField> names;
	public JComboBox currenciesBox = new JComboBox(InMemoryDatabase.getCurrenciesAsString());

	public Frame() {

		this.currencies = InMemoryDatabase.getCurrencies();
		initFrame();
		initAndDisplayFieldForDailySalary();
		initAndDisplayFieldForFinalResult();
		buttonForConvertingSalaryFromForeignCurrency();
		nameForFieldDailySalary();
		buttonForAddingNewCurrency();
		nameForFieldFinalResult();
		nameForFieldForAddingNewCurrency();
		this.names = new ArrayList<JTextField>();
		addJComboBox();
		initAndDisplayFieldForAddingNewCurrency();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void nameForFieldForAddingNewCurrency() {
		enter3 = new JLabel("Dodaj nowa walute. Zatwierdz przyciskiem:");
		enter3.setBounds(20, 200, 300, 20);
		add(enter3);
		jName = new JLabel("nazwa");
		jName.setBounds(20, 250, 80, 20);
		add(jName);
		jPrice = new JLabel("cena");
		jPrice.setBounds(20, 280, 80, 20);
		add(jPrice);
		jTax = new JLabel("podatek w %");
		jTax.setBounds(20, 310, 80, 20);
		add(jTax);
		jCost = new JLabel("koszty sta³e");
		jCost.setBounds(20, 340, 80, 20);
		add(jCost);
	}

	private void initAndDisplayFieldForAddingNewCurrency() {
		name = new JTextField("");
		name.setBounds(100, 250, 130, 20);
		add(name);
		price = new JTextField("");
		price.setBounds(100, 280, 130, 20);
		add(price);
		price.setText("cena na 1 PLN");
		cost = new JTextField("");
		cost.setBounds(100, 310, 130, 20);
		add(cost);
		tax = new JTextField("");
		tax.setBounds(100, 340, 130, 20);
		add(tax);
	}

	private void addJComboBox() {
		currenciesBox.setSelectedIndex(2);
		currenciesBox.addActionListener(this);
		add(currenciesBox);
		currenciesBox.setBounds(100, 30, 100, 20);
	}

	private void nameForFieldFinalResult() {
		enter2 = new JLabel("Wynik");
		enter2.setBounds(40, 150, 200, 20);
		add(enter2);
	}

	private void buttonForAddingNewCurrency() {
		button = new JButton("Dodaj walute");
		button.addActionListener(this);
		button.setBounds(80, 400, 120, 20);
		add(button);
	}

	private void nameForFieldDailySalary() {
		enter = new JLabel("Stawka/dzien");
		enter.setBounds(40, 80, 200, 20);
		add(enter);
	}

	private void buttonForConvertingSalaryFromForeignCurrency() {
		convert = new JButton("Przelicz");
		convert.addActionListener(this);
		convert.setBounds(100, 120, 100, 20);
		add(convert);
	}

	private void initAndDisplayFieldForDailySalary() {
		TextAmount = new JTextField("");
		TextAmount.setBounds(120, 80, 160, 20);
		add(TextAmount);
	}

	private void initFrame() {
		setTitle("Wynagrodzenie");
		setSize(300, 500);
		setLayout(null);
	}

	private void initAndDisplayFieldForFinalResult() {
		result = new JTextField("");
		result.setBounds(120, 150, 160, 20);
		add(result);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object zrodlo = e.getSource();
		if (zrodlo == convert) {

			String currenciesName = (String) currenciesBox.getSelectedItem();
			Currency selectedCurrency = InMemoryDatabase.getCurrencyByName(currenciesName);

			amount = Double.parseDouble(TextAmount.getText()) * selectedCurrency.getValue() * 22
					* (1 - (selectedCurrency.getTax() / 100));
			result.setText(String.valueOf(amount));
		}
		if (zrodlo == button) {
			InMemoryDatabase.addCurrency(name.getText(), Double.parseDouble(price.getText()),
					Double.parseDouble(tax.getText()), Double.parseDouble(cost.getText()));
			currenciesBox.addItem(name.getText());
		}
		this.repaint();

	}

}
