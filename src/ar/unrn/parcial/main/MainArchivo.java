package ar.unrn.parcial.main;

import java.time.LocalDate;

import ar.unrn.parcial.modelo.Combustible;
import ar.unrn.parcial.modelo.CombustibleSuper;
import ar.unrn.parcial.modelo.RepositorioDeVentas;
import ar.unrn.parcial.modelo.Ventas;
import ar.unrn.parcial.persistencia.EnDiscoRegistroDeVentas;

public class MainArchivo {

	public static void main(String[] args) {

		String direccion = "C:\\archivo_prueba.txt";
		RepositorioDeVentas repositorio = new EnDiscoRegistroDeVentas(direccion);
		Combustible combustibleSuper = new CombustibleSuper("Super");
		Ventas venta = new Ventas(LocalDate.now(), 25);
		venta.realizarVentas(combustibleSuper);
		repositorio.registrarVenta(venta);

	}
}
