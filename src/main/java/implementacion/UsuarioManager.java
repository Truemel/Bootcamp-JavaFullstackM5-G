package implementacion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.ConnectionClient;
import interfaces.UsuarioDAO;
import modelo.Administrativo;
import modelo.Cliente;
import modelo.Profesional;
import modelo.Usuario;

public class UsuarioManager implements UsuarioDAO {

	@Override
	public ArrayList<Usuario> getUsuarioList() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		Connection conCli = ConnectionClient.getClient();
		try {
			ResultSet result = conCli.createStatement().executeQuery("SELECT * FROM usuarios");
			while(result.next()) {
				lista.add(new Usuario(result.getInt("id"), result.getString("nombre"), result.getString("apellido"),
						result.getString("correo"), result.getString("rut")));
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
				user = new Usuario(result.getInt("id"), result.getString("nombre"), result.getString("apellido"),
						result.getString("correo"), result.getString("rut"));
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
			conCli.createStatement().execute("INSERT INTO usuarios (nombre, apellido, correo, rut) VALUES ('"+usu.getNombre()+"', '"
		+usu.getApellido()+"', '"+usu.getCorreo()+"', '"+usu.getRut()+"')");
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
			conCli.createStatement().execute("UPDATE usuarios SET nombre = '"+usu.getNombre()+"', apellido = '"+usu.getApellido()
			+"', correo = '"+usu.getCorreo()+"', rut = '"+usu.getRut()+"' "
					+ "WHERE id = "+usu.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Cliente> getClienteList() {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		Connection conCli = ConnectionClient.getClient();
		try {
			ResultSet result = conCli.createStatement().executeQuery("SELECT * FROM cliente INNER JOIN usuario ON "
					+ "cliente.usuario_id = usuario.id");
			while(result.next()) {
				lista.add(new Cliente(result.getInt("usuario.id"), result.getString("nombre"), result.getString("apellido"),
						result.getString("correo"), result.getString("rut"), result.getInt("cliente.id"), result.getShort("edad"),
						result.getString("telefono"), result.getString("direccion"), result.getInt("capaci_id")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public ArrayList<Profesional> getProfesionalList() {
		ArrayList<Profesional> lista = new ArrayList<Profesional>();
		Connection conCli = ConnectionClient.getClient();
		try {
			ResultSet result = conCli.createStatement().executeQuery("SELECT * FROM profesional INNER JOIN usuario ON "
					+ "profesional.usuario_id = usuario.id");
			while(result.next()) {
				lista.add(new Profesional(result.getInt("usuario.id"), result.getString("nombre"), result.getString("apellido"), 
						result.getString("correo"), result.getString("rut"), result.getInt("profesional.id"),
						result.getString("telefono"), result.getString("cargo")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public ArrayList<Administrativo> getAdministrativoList() {
		ArrayList<Administrativo> lista = new ArrayList<Administrativo>();
		Connection conCli = ConnectionClient.getClient();
		try {
			ResultSet result = conCli.createStatement().executeQuery("SELECT * FROM administrativo INNER JOIN usuario ON "
					+ "administrativo.usuario_id = usuario.id");
			while(result.next()) {
				lista.add(new Administrativo(result.getInt("usuario.id"), result.getString("nombre"), result.getString("apellido"),
						result.getString("correo"), result.getString("rut"), result.getInt("administrativo.id"), 
						result.getString("area")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Cliente getClienteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profesional getProfesionalById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrativo getAdministrativoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCliente(Cliente cli) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProfesional(Profesional profe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAdministrativo(Administrativo admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteClienteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProfesionalById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAdministrativoById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCliente(Cliente cli) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProfesional(Profesional profe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAdministrativo(Administrativo admin) {
		// TODO Auto-generated method stub
		
	}
}
