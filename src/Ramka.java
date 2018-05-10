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

public class Ramka extends JFrame implements ActionListener {

	JButton button;
	JTextField Textkwota;
	JLabel wprowadz;
	JLabel wprowadz2;
	JLabel wyswietl;
	JButton przelicz;
	JTextField wynik;
	double kwota;
	public List<Currency> waluty;
	public List<JTextField> nazwy;
	public List<JButton> przyciski;
	public JComboBox currenciesBox = new JComboBox(InMemoryDatabase.getCurrenciesAsString());

	public Ramka() {

		this.waluty = InMemoryDatabase.getCurrencies();
		setTitle("Wynagrodzenie");
		setSize(300, 300);
		setLayout(null);
		// kwota do wpisania w okienku tekstowym
		Textkwota = new JTextField("");
		Textkwota.setBounds(120, 80, 160, 20);
		add(Textkwota);
		// pole tekstowe w ktorym pojawi sie obliczona kwota
		wynik = new JTextField("");
		wynik.setBounds(120, 150, 160, 20);
		add(wynik);
		// przycisk za pomoca ktorego obliczymy wynagrodzenie z waluty obcej
		przelicz = new JButton("Przelicz");
		przelicz.addActionListener(this);
		przelicz.setBounds(100, 120, 100, 20);
		add(przelicz);
		// tekst
		wprowadz = new JLabel("Stawka/dzien");
		wprowadz.setBounds(40, 80, 200, 20);
		add(wprowadz);

		wprowadz2 = new JLabel("Wynik");
		wprowadz2.setBounds(40, 150, 200, 20);
		add(wprowadz2);
		// lista nazw walut
		this.nazwy = new ArrayList<JTextField>();

		currenciesBox.setSelectedIndex(2);
		currenciesBox.addActionListener(this);
		add(currenciesBox);
		currenciesBox.setBounds(30, 30, 100, 20);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void wypelnijPanel() {
		this.przyciski = new ArrayList<JButton>();
	}

	public void ObliczWynagrodzenie() {
		for (int i = 0; i < waluty.size(); i++) {

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object zrodlo = e.getSource();
		if (zrodlo == przelicz) {

			String currenciesName = (String) currenciesBox.getSelectedItem();
			Currency selectedCurrency = InMemoryDatabase.getCurrencyByName(currenciesName);
			
			kwota = Double.parseDouble(Textkwota.getText());
			wynik.setText(String.valueOf(kwota));
		}

	}

}
