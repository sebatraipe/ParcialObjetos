package ar.unrn.parcial.bd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.unrn.parcial.modelo.RepositorioDeVentas;
import ar.unrn.parcial.modelo.Ventas;

public class JdbcVentas implements RepositorioDeVentas {

	private Connection dbConn;

	private Connection setupBaseDeDatos() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/ventas";
		String user = "root";
		String password = "1234";
		return DriverManager.getConnection(url, user, password);
	}

	@Override
	public void registrarVenta(Ventas ventas) {
		try {
			this.dbConn = setupBaseDeDatos();
			PreparedStatement st = dbConn.prepareStatement(
					"insert into ventas_realizadas (fecha, litrosCargados, montoFacturado)values(?,?,?)");
			st.setDate(1, Date.valueOf(ventas.obtenerFecha()));
			st.setInt(2, ventas.obtenerLitrosCargados());
			st.setDouble(3, ventas.obtenerMontoFacturado());

		} catch (SQLException e) {
			throw new RuntimeException("Error. " + e.getMessage());
		}
	}
}