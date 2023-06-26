package db_manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.ConnectionClient;
import model.Capacitacion;

public class CapacitacionManager implements CapacitacionDAO {

	@Override
	public ArrayList<Capacitacion> getCapacitacionList() {
		ArrayList<Capacitacion> lista = new ArrayList<Capacitacion>();
		Connection conCli = ConnectionClient.getClient();
		try {
			Statement state = conCli.createStatement();
			ResultSet result = state.executeQuery("SELECT id, nombre, detalle from capacitaciones");
			while(result.next()) {
				Capacitacion cap = new Capacitacion();
				cap.setId(result.getInt("id"));
				cap.setNombre(result.getString("nombre"));
				cap.setDetalle(result.getString("detalle"));
				lista.add(cap);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Capacitacion getCapacitacionById(int id) {
		Capacitacion cap = null;
		Connection conCli = ConnectionClient.getClient();
		try {
			Statement state = conCli.createStatement();
			ResultSet result = state.executeQuery("SELECT id, nombre, detalle from capacitaciones WHERE id = "+id);
			while(result.next()) {
				cap = new Capacitacion();
				cap.setId(result.getInt("id"));
				cap.setNombre(result.getString("nombre"));
				cap.setDetalle(result.getString("detalle"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cap;
	}

	@Override
	public void addCapacitacion(Capacitacion cap) {
		try {
			ConnectionClient.getClient().createStatement().execute("INSERT INTO capacitaciones (nombre, detalle) VALUES "
					+ "('"+cap.getNombre()+"', '"+cap.getDetalle()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCapacitacionById(int id) {
		try {
			ConnectionClient.getClient().createStatement().execute("DELETE FROM capacitaciones WHERE id = "+id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateCapacitacion(Capacitacion cap) {
		try {
			ConnectionClient.getClient().createStatement().execute("UPDATE capacitaciones SET nombre = "+cap.getNombre()+", "
					+ "detalle = '"+cap.getDetalle()+"' WHERE id = "+cap.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
