package core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

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
	
	public static void cargarPlatos () throws IOException {
		try {
		    ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get("C:\\Users\\jordi\\eclipse-workspace\\Examen\\src\\core\\platos.txt")));
		    for (int i = 0; i < lines.size(); i++) {
		    	boolean comprobante = false;
		    	String a = lines.get(i);
		    	String [] pasador = a.split(";");
		    	// Comprobar que no se repitan platos
		    	if (i == 0) {
		    		Plato plato = new Plato (pasador[0], Float.parseFloat(pasador[1]));
				    MyTask.listaPlatos.add(plato);
		    	} else {
		    		while (comprobante == false) {
			    		for (int j = 0; j < MyTask.listaPlatos.size(); j++) {
			    			if (MyTask.listaPlatos.get(j).getNombre().equals(pasador[0])) {
			    				MyTask.listaPlatos.get(j).setPrecio(Float.parseFloat(pasador[1]));
			    				comprobante = true;
			    				break;
			    			}	
		    			}
			    		if (comprobante == false) {
				    		Plato plato = new Plato (pasador[0], Float.parseFloat(pasador[1]));
						    MyTask.listaPlatos.add(plato);
						    break;
			    		}
					    }
		    		}
		    	}
		    	
		    
		
		    for (int x = 0; x < MyTask.listaPlatos.size(); x++) {
		    	System.out.println(MyTask.listaPlatos.get(x));
		    }
		}
		catch (IOException e) {
		    System.out.println(e);
		}
		
	}
	
	
	
}
