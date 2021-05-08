package ar.unrn.parcial.persistencia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.unrn.parcial.modelo.RepositorioDeVentas;
import ar.unrn.parcial.modelo.Ventas;

public class EnMemoriaRegistroDeCosto implements RepositorioDeVentas {

	List<Ventas> listaVentaas = new ArrayList<>();

	@Override
	public void registrarVenta(Ventas ventas) {
		this.listaVentaas.add(ventas);
	}

	public boolean verficarRegistroDeVentas(LocalDate fecha) {
		for (Ventas ventas : this.listaVentaas) {
			if (ventas.obtenerFecha().equals(fecha)) {
				return true;
			}
		}
		return false;
	}
}