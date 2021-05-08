package ar.unrn.parcial.modelo;

import java.time.LocalDate;

public class CombustibleSuper extends Combustible {

	private double descuentoDomingo = 0.1;
	private double descuentoSabado = 0.12;
	private final String DAY_SUNDAY = "SUNDAY";
	private final String DAY_SATURDAY = "SATURDAY";
	private final float precioSuper = 90;

	public CombustibleSuper(String nombre) {
		super(nombre);
	}

	/* El monto esta mal calculado arreglar!!1 */
	public double calcularMonto(Integer litrosCargados) {
		LocalDate fechaActual = LocalDate.now();
		String fecha = String.valueOf(fechaActual.getDayOfYear());
		if ((litrosCargados > 20) && (fecha.equals(DAY_SATURDAY))) {
			return (litrosCargados * precioSuper) - this.descuentoSabado;
		}
		if ((fecha.equals(DAY_SUNDAY))) {
			return (litrosCargados * precioSuper) - this.descuentoDomingo;
		}
		return (litrosCargados * this.precioSuper);
	}
}