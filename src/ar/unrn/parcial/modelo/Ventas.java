package ar.unrn.parcial.modelo;

import java.time.LocalDate;

public class Ventas {

	private LocalDate fecha;
	private Integer litrosCargados;
	private double montoFacturado;

	public Ventas(LocalDate fecha, Integer litrosCargados) {
		this.fecha = fecha;
		this.litrosCargados = litrosCargados;
	}

	public void realizarVentas(Combustible combustible) {
		this.montoFacturado = combustible.calcularMonto(this.litrosCargados);
	}

	public LocalDate obtenerFecha() {
		return fecha;
	}

	public Integer obtenerLitrosCargados() {
		return litrosCargados;
	}

	public double obtenerMontoFacturado() {
		return montoFacturado;
	}
}