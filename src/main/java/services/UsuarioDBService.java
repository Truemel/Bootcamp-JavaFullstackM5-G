package services;

import java.util.ArrayList;

import db_manager.UsuarioManager;
import model.Usuario;

public class UsuarioDBService {
	
	private UsuarioManager manager = new UsuarioManager();
	
	public ArrayList<Usuario> getUsuarioList(){
		return manager.getUsuarioList();
	}
	
	public Usuario getUsuarioById(int id) {
		return manager.getUsuarioById(id);
	}
	
	public void addUsuario(Usuario usu) {
		manager.addUsuario(usu);
	}
	
	public void deleteUsuarioById(int id) {
		manager.deleteUsuarioById(id);
	}
	
	public void updateUsuario(Usuario usu) {
		manager.updateUsuario(usu);
	}
}