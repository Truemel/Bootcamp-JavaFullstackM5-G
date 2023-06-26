package services;

import java.util.List;

import db_manager.CapacitacionManager;
import model.Capacitacion;

public class CapacitacionDBService {
	
	private CapacitacionManager manager = new CapacitacionManager();
	
	public List<Capacitacion> getCapacitacionList(){
		return manager.getCapacitacionList();
	}
	
	public Capacitacion getCapacitacionById(int id) {
		return manager.getCapacitacionById(id);
	}
	
	public void addCapacitacion(Capacitacion cap) {
		manager.addCapacitacion(cap);
	}
	
	public void deleteCapacitacionById(int id) {
		manager.deleteCapacitacionById(id);
	}
	
	public void updateCapacitacion(Capacitacion cap) {
		manager.updateCapacitacion(cap);
	}
}