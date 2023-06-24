package db_manager;

import java.util.ArrayList;

import model.Capacitacion;

public interface CapacitacionDAO {
	
	public ArrayList<Capacitacion> getCapacitacionList();
	public Capacitacion getCapacitacionById(int id);
	public void addCapacitacion(Capacitacion cap);
	public void deleteCapacitacionById(int id);
	public void updateCapacitacion(Capacitacion cap);

}
