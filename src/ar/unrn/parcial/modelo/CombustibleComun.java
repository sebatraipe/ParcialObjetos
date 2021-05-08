package ar.unrn.parcial.modelo;

import java.time.LocalTime;

public class CombustibleComun extends Combustible {

	private double descuento = 0.5;
	private float precio = 70;

	public CombustibleComun(String nombre) {
		super(nombre);
	}

	public double calcularMonto(Integer litrosCargados) {
		LocalTime time = LocalTime.now();
		if ((time.isAfter(LocalTime.parse("08:00:00.00"))) && (time.isBefore(LocalTime.parse("10:00:00.00")))) {
			return (litrosCargados * this.precio) * descuento;
		}
		return (litrosCargados * this.precio);
	}
}