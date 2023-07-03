package interfaces;

import java.util.ArrayList;

import modelo.Administrativo;
import modelo.Cliente;
import modelo.Profesional;
import modelo.Usuario;

public interface UsuarioDAO {
	public ArrayList<Usuario> getUsuarioList();
	public Usuario getUsuarioById(int id);
	public void addUsuario(Usuario usu);
	public void deleteUsuarioById(int id);
	public void updateUsuario(Usuario usu);
	public ArrayList<Cliente> getClienteList();
	public ArrayList<Profesional> getProfesionalList();
	public ArrayList<Administrativo> getAdministrativoList();
	public Cliente getClienteById(int id);
	public Profesional getProfesionalById(int id);
	public Administrativo getAdministrativoById(int id);
	public void addCliente(Cliente cli);
	public void addProfesional(Profesional profe);
	public void addAdministrativo(Administrativo admin);
	public void deleteClienteById(int id);
	public void deleteProfesionalById(int id);
	public void deleteAdministrativoById(int id);
	public void updateCliente(Cliente cli);
	public void updateProfesional(Profesional profe);
	public void updateAdministrativo(Administrativo admin);
}