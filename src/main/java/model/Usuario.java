package model;

public class Usuario {

	public static enum Tipo {CLIENTE, ADMINISTRATIVO, PROFESIONAL};
	
    private int id;
    private String nombre;
    private Tipo tipo;

    public Usuario(){
        id = 0;
        nombre = "";
        tipo = Tipo.CLIENTE;
    }

    public Usuario(int id, String nombre, Tipo tipo){
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + "]";
	}
}