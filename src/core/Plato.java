package core;

public class Plato {
	private int id;
	private String nombre;
	private float precio;
	private static int contadorpl = 0;
	
	// Setters i getters
	
	public int getId() {
		return id;
	}
	public void setId() {
		contadorpl++;
		this.id = contadorpl;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public static int getContador() {
		return contadorpl;
	}
	
	// Constructors
	
	public Plato() {}
	
	public Plato(String nombre, float precio) {
		this.setId();
		this.setNombre(nombre);
		this.setPrecio(precio);
	}
	
	// Mètodes 
	
	@Override
	public String toString() {
		return "Plato [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	
	public void cargarPlatos () {
		
	}
	
	
	
	
}
