package interfaces;

import java.util.ArrayList;

import modelo.Usuario;

public interface UsuarioDAO {
	public ArrayList<Usuario> getUsuarioList();
	public Usuario getUsuarioById(int id);
	public void addUsuario(Usuario usu);
	public void deleteUsuarioById(int id);
	public void updateUsuario(Usuario usu);
}