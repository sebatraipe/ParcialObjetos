package ar.unrn.parcial.persistencia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import ar.unrn.parcial.modelo.RepositorioDeVentas;
import ar.unrn.parcial.modelo.Ventas;

public class EnDiscoRegistroDeVentas implements RepositorioDeVentas {

	private String direccion;

	public EnDiscoRegistroDeVentas(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public void registrarVenta(Ventas venta) {

		String datosVentas = venta.obtenerFecha().toString() + ", " + venta.obtenerLitrosCargados().toString() + ", "
				+ String.valueOf(venta.obtenerMontoFacturado());

		try {
			Files.write(Paths.get(direccion), datosVentas.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("No se pudo persistir...", e);
		}
	}
}