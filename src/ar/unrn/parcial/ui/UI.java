package ar.unrn.parcial.ui;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ar.unrn.parcial.modelo.Combustible;
import ar.unrn.parcial.modelo.CombustibleComun;
import ar.unrn.parcial.modelo.CombustibleSuper;
import ar.unrn.parcial.modelo.RepositorioDeVentas;
import ar.unrn.parcial.modelo.Ventas;

public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField textLitros;
	private JComboBox comboBoxTipo;
	private RepositorioDeVentas repositorioDeVentas;
	private JTextField nombre, telefono, region;

	public UI(RepositorioDeVentas repositorioDeVentas) {
		this.repositorioDeVentas = repositorioDeVentas;
	}

	public void setupUIComponents() {
		setTitle("Cargar Combustible");
		setSize(400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textLitros = new JTextField(10);
		comboBoxTipo = new JComboBox<String>();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] { "Com\u00FAn", "Super" }));
		region = new JTextField(10);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JLabel("Litros: "));
		contentPane.add(textLitros);
		contentPane.add(new JLabel("Tipo: "));
		contentPane.add(comboBoxTipo);
		JButton botonCargar = new JButton("Consultar Monto");
		botonCargar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onBotonCargar();
			}
		});
		contentPane.add(botonCargar);

		JButton botonConfirmarPago = new JButton("Confirmar Pago");
		botonConfirmarPago.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		contentPane.add(botonConfirmarPago);
		setContentPane(contentPane);
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pack();
		setVisible(true);
	}

	private void onBotonCargar() {
		String tipo = (String) comboBoxTipo.getSelectedItem();
		if (comboBoxTipo.getSelectedIndex() == 0) {
			Combustible combustibleComun = new CombustibleComun(tipo);
			Ventas ventas = new Ventas(LocalDate.now(), Integer.valueOf(textLitros.getText()));
			ventas.realizarVentas(combustibleComun);
			this.repositorioDeVentas.registrarVenta(ventas);
		} else {
			Combustible combustibleSuper = new CombustibleSuper(tipo);
			Ventas ventas = new Ventas(LocalDate.now(), Integer.valueOf(textLitros.getText()));
			ventas.realizarVentas(combustibleSuper);
			this.repositorioDeVentas.registrarVenta(ventas);
		}
	}
}