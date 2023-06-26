package db_manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.ConnectionClient;
import model.Usuario;
import model.Usuario.Tipo;

public class UsuarioManager implements UsuarioDAO {

	@Override
	public ArrayList<Usuario> getUsuarioList() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		Connection conCli = ConnectionClient.getClient();
		try {
			ResultSet result = conCli.createStatement().executeQuery("SELECT * FROM usuarios");
			while(result.next()) {
				lista.add(new Usuario(result.getInt("id"), result.getString("nombre"), Tipo.valueOf(result.getString("tipo"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Usuario getUsuarioById(int id) {
		Usuario user = null;
		Connection conCli = ConnectionClient.getClient();
		try {
			ResultSet result = conCli.createStatement().executeQuery("SELECT * FROM usuarios WHERE id = "+id);
			while(result.next()) {
				user = new Usuario(result.getInt("id"), result.getString("nombre"), Tipo.valueOf(result.getString("tipo")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void addUsuario(Usuario usu) {
		Connection conCli = ConnectionClient.getClient();
		try {
			conCli.createStatement().execute("INSERT INTO usuarios (nombre, tipo) VALUES ('"+usu.getNombre()+"', '"+usu.getTipo()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUsuarioById(int id) {
		Connection conCli = ConnectionClient.getClient();
		try {
			conCli.createStatement().execute("DELETE FROM usuarios WHERE id = "+id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateUsuario(Usuario usu) {
		Connection conCli = ConnectionClient.getClient();
		try {
			conCli.createStatement().execute("UPDATE usuarios SET nombre = '"+usu.getNombre()+"', tipo = '"+usu.getTipo()+"' "
					+ "WHERE id = "+usu.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
