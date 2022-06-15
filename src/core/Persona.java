package core;

public abstract class Persona {
	private int id;
	private String nombre;
	private static int contador = 0;
	
	// 	Setters i getters
	
	public int getId() {
		return id;
	}
	
	public void setId() {
		contador++;
		this.id = contador;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public static int getContador() {
		return contador;
	}
	
	// Constructors
	
	public Persona() {
	}
	
	public Persona (String nombre) {
		this.setId();
		this.setNombre(nombre);
	}
	
	// Mètodes
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + "]";
	}
	
	public static void verPendientes() {
		for (int i = 0; i < MyTask.listaPedidos.size(); i++) {
			for (int x = 0; x < (int) MyTask.listaPedidos.get(i).getLineasPedido().size(); x++) {
				if (((LineaPedido) MyTask.listaPedidos.get(i).getLineasPedido().get(x)).getEstado() == "Pedido" || ((LineaPedido) MyTask.listaPedidos.get(i).getLineasPedido().get(x)).getEstado() ==  "Cocina" || ((LineaPedido) MyTask.listaPedidos.get(i).getLineasPedido().get(x)).getEstado() ==  "Listo") {
					System.out.println(MyTask.listaPedidos.get(i).getLineasPedido().get(x));
				}
			}
		}
	}
	
	public static void calcularCaja() {
		int total = 0;
		for (int o = 0; o < MyTask.listaPlatos.size(); o++) {
			for (int i = 0; i < MyTask.listaPedidos.size(); i++) {
				if (o == MyTask.listaPedidos.get(i).getId()) {
					for (int x = 0; x < MyTask.listaPedidos.get(i).getLineasPedido().size(); x++) {
						int b = (int) ((LineaPedido) MyTask.listaPedidos.get(i).getLineasPedido().get(x)).getPlato().getPrecio();
						int c = (int) ((LineaPedido) MyTask.listaPedidos.get(i).getLineasPedido().get(x)).getCantidad();
						int d = b * c;
						total = total + d;
					}	
				}
			}
		}
		System.out.println("Total de caja: "+total);
	}
	
	public abstract void actuar();
	}
	
	
