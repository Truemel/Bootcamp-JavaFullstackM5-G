package implementacion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			ResultSet result = conCli.createStatement().executeQuery("SELECT * FROM usuario");
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
			ResultSet result = conCli.createStatement().executeQuery("SELECT * FROM usuario WHERE id = "+id);
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
			conCli.createStatement().execute("INSERT INTO usuario (nombre, apellido, correo, rut) VALUES ('"+usu.getNombre()+"', '"
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
			conCli.createStatement().execute("DELETE FROM usuario WHERE id = "+id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateUsuario(Usuario usu) {
		Connection conCli = ConnectionClient.getClient();
		try {
			conCli.createStatement().execute("UPDATE usuario SET nombre = '"+usu.getNombre()+"', apellido = '"+usu.getApellido()
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
			ResultSet result = conCli.createStatement().executeQuery("SELECT usuario.id as usuId, nombre, apellido, correo,"
					+ "rut, cliente.id as cliId, edad, telefono, direccion, capaci_id FROM cliente INNER JOIN usuario ON "
					+ "cliente.usuario_id = usuario.id");
			while(result.next()) {
				lista.add(new Cliente(result.getInt("usuId"), result.getString("nombre"), result.getString("apellido"),
						result.getString("correo"), result.getString("rut"), result.getInt("cliId"), result.getShort("edad"),
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
			ResultSet result = conCli.createStatement().executeQuery("SELECT usuario.id as usuId, nombre, apellido, correo,"
					+ "rut, profesional.id as proId, telefono, cargo FROM profesional INNER JOIN usuario ON "
					+ "profesional.usuario_id = usuario.id");
			while(result.next()) {
				lista.add(new Profesional(result.getInt("usuId"), result.getString("nombre"), result.getString("apellido"), 
						result.getString("correo"), result.getString("rut"), result.getInt("proId"),
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
			ResultSet result = conCli.createStatement().executeQuery("SELECT usuario.id as usuId, nombre, apellido, correo,"
					+ "rut, administrativo.id as admId, area FROM administrativo INNER JOIN usuario ON "
					+ "administrativo.usuario_id = usuario.id");
			while(result.next()) {
				lista.add(new Administrativo(result.getInt("usuId"), result.getString("nombre"), result.getString("apellido"),
						result.getString("correo"), result.getString("rut"), result.getInt("admId"), 
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
		Cliente user = null;
		Connection conCli = ConnectionClient.getClient();
		try {
			ResultSet result = conCli.createStatement().executeQuery("SELECT usuario.id as usuId, nombre, apellido, correo,"
					+ "rut, cliente.id as cliId, edad, telefono, direccion, capaci_id FROM cliente INNER JOIN usuario ON "
					+ "cliente.usuario_id = usuario.id WHERE id = "+id);
			while(result.next()) {
				user = new Cliente(result.getInt("usuId"), result.getString("nombre"), result.getString("apellido"),
						result.getString("correo"), result.getString("rut"), result.getInt("cliId"), result.getShort("edad"),
						result.getString("telefono"), result.getString("direccion"), result.getInt("capaci_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Profesional getProfesionalById(int id) {
		Profesional user = null;
		Connection conCli = ConnectionClient.getClient();
		try {
			ResultSet result = conCli.createStatement().executeQuery("SELECT usuario.id as usuId, nombre, apellido, correo,"
					+ "rut, profesional.id as proId, telefono, cargo FROM profesional INNER JOIN usuario ON "
					+ "profesional.usuario_id = usuario.id WHERE id = "+id);
			while(result.next()) {
				user = new Profesional(result.getInt("usuId"), result.getString("nombre"), result.getString("apellido"), 
						result.getString("correo"), result.getString("rut"), result.getInt("proId"),
						result.getString("telefono"), result.getString("cargo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Administrativo getAdministrativoById(int id) {
		Administrativo user = null;
		Connection conCli = ConnectionClient.getClient();
		try {
			ResultSet result = conCli.createStatement().executeQuery("SELECT usuario.id as usuId, nombre, apellido, correo,"
					+ "rut, administrativo.id as admId, area FROM administrativo INNER JOIN usuario ON "
					+ "administrativo.usuario_id = usuario.id WHERE id = "+id);
			while(result.next()) {
				user = new Administrativo(result.getInt("usuId"), result.getString("nombre"), result.getString("apellido"),
						result.getString("correo"), result.getString("rut"), result.getInt("admId"), 
						result.getString("area"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void addCliente(Cliente cli) {
		Connection conCli = ConnectionClient.getClient();
		try {
			ResultSet result = conCli.prepareStatement("INSERT INTO usuario (nombre, apellido, correo, rut) VALUES"
					+ " ('"+cli.getNombre()+"', '"+cli.getApellido()+"', '"+cli.getCorreo()+"', '"+cli.getRut()+"')", 
					Statement.RETURN_GENERATED_KEYS).getGeneratedKeys();
			if(result.next()) {
				conCli.createStatement().execute("INSERT INTO cliente (telefono, direccion, edad, usuario_id, capaci_id) VALUES"
						+ " ('"+cli.getTelefono()+"', '"+cli.getDireccion()+"', "+cli.getEdad()+", "+result.getInt("id")+", "+
						cli.getIdCapac()+")");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addProfesional(Profesional profe) {
		Connection conCli = ConnectionClient.getClient();
		try {
			conCli.createStatement().execute("INSERT INTO usuario (nombre, apellido, correo, rut) VALUES"+" ('"+profe.getNombre()+
					"', '"+profe.getApellido()+"', '"+profe.getCorreo()+"', '"+profe.getRut()+"')");
			ResultSet result = conCli.createStatement().executeQuery("SELECT id FROM usuario WHERE rut = '"+profe.getRut()+"'");
			if(result.next()) {
				conCli.createStatement().execute("INSERT INTO profesional (telefono, cargo, usuario_id) VALUES"
						+ " ('"+profe.getTelefono()+"', '"+profe.getCargo()+"', "+result.getInt("id")+")");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addAdministrativo(Administrativo admin) {
		Connection conCli = ConnectionClient.getClient();
		try {
			conCli.createStatement().execute("START TRANSACTION;\nINSERT INTO usuario (nombre, apellido, correo, rut) VALUES ('"
					+admin.getNombre()+"', '"+admin.getApellido()+"', '"+admin.getCorreo()+"', '"+admin.getRut()+"');\n"
					+ "INSERT INTO administrativo (area, usuario_id) VALUES ('"+admin.getArea()+"', (SELECT id FROM usuario "
					+ "WHERE rut = '"+admin.getRut()+"'));\nCOMMIT;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteClienteById(int id) {
		Connection conCli = ConnectionClient.getClient();
		try {
			ResultSet result = conCli.createStatement().executeQuery("SELECT usuario_id FROM cliente WHERE id = "+id);
			if(result.next()){
				conCli.createStatement().execute("DELETE FROM cliente WHERE id = "+id);
				conCli.createStatement().execute("DELETE FROM usuario WHERE id = "+result.getInt("usuario_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProfesionalById(int id) {
		Connection conCli = ConnectionClient.getClient();
		try {
			ResultSet result = conCli.createStatement().executeQuery("SELECT usuario_id FROM profesional WHERE id = "+id);
			if(result.next()){
				conCli.createStatement().execute("DELETE FROM profesional WHERE id = "+id);
				conCli.createStatement().execute("DELETE FROM usuario WHERE id = "+result.getInt("usuario_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAdministrativoById(int id) {
		Connection conCli = ConnectionClient.getClient();
		try {
			ResultSet result = conCli.createStatement().executeQuery("SELECT usuario_id FROM administrativo WHERE id = "+id);
			if(result.next()){
				conCli.createStatement().execute("DELETE FROM administrativo WHERE id = "+id);
				conCli.createStatement().execute("DELETE FROM usuario WHERE id = "+result.getInt("usuario_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateCliente(Cliente cli) {
		Connection conCli = ConnectionClient.getClient();
		try {
			conCli.createStatement().execute("UPDATE cliente SET telefono = '"+cli.getTelefono()+"', direccion = '"+
					cli.getDireccion()+"', edad = "+cli.getEdad()+", capaci_id = "+cli.getIdCapac()+" WHERE id = "+cli.getIdCliente());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateProfesional(Profesional profe) {
		Connection conCli = ConnectionClient.getClient();
		try {
			conCli.createStatement().execute("UPDATE profesional SET telefono = '"+profe.getTelefono()+"', cargo = '"+
					profe.getCargo()+"' WHERE id = "+profe.getIdProfes());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateAdministrativo(Administrativo admin) {
		Connection conCli = ConnectionClient.getClient();
		try {
			conCli.createStatement().execute("UPDATE administrativo SET area = '"+admin.getArea()+"' WHERE id = "+admin.getIdAdmin());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
