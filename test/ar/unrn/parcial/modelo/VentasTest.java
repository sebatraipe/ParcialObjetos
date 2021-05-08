package ar.unrn.parcial.modelo;

import org.junit.Test;

import ar.unrn.parcial.persistencia.EnMemoriaRegistroDeCosto;

public class VentasTest {

	@Test
	public void calcularMontoCargaDeCombustibleComun() {

		RepositorioDeVentas repositorioDeVentas = new EnMemoriaRegistroDeCosto();
		Combustible combustibleComun = new Combustible("Comun");
		Combustible combustibleSuper = new CombustibleSuper("Super");

		double montoCombustibleComun = combustibleComun.calcularMonto(25);
		double montoCombustibleSuper = combustibleSuper.calcularMonto(24);

	}

}
