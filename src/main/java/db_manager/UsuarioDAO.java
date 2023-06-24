package db_manager;

import java.util.ArrayList;

import model.Usuario;

public interface UsuarioDAO {
	public ArrayList<Usuario> getUsuarioList();
	public Usuario getUsuarioById(int id);
	public void addUsuario(Usuario usu);
	public void deleteUsuarioById(int id);
	public void updateUsuario(Usuario usu);
}
