package ar.unrn.parcial.main;

import ar.unrn.parcial.bd.JdbcVentas;
import ar.unrn.parcial.ui.UI;

public class MainBD {

	public static void main(String[] args) {

		UI ui = new UI(new JdbcVentas());
		ui.setupUIComponents();

	}

}
