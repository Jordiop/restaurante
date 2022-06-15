package core;
import java.util.*;

public class Camarer extends Persona{
	
	public Camarer (String nombre) {
		super(nombre);
	}
	
	// Mètodes
	
	public static void crearPedido () {
		Scanner teclat = new Scanner (System.in);
		System.out.println("Crear pedido");
		System.out.println("Plato deseado");
		int plate = teclat.nextInt();
		System.out.println("Cantidad");
		int cantidad = teclat.nextInt();
		System.out.println("Introduce la mesa");
		int mesa = teclat.nextInt();
		boolean encontrado = false;
		int i = 1;
		while (encontrado == false && i < MyTask.listaPlatos.size()) {
			if (plate == MyTask.listaPlatos.get(i).getId()) {
				Plato plato = new Plato(MyTask.listaPlatos.get(i).getNombre(), MyTask.listaPlatos.get(i).getPrecio());
				LineaPedido lineaPedido = new LineaPedido(plato,"Pedido",cantidad);
				ArrayList <LineaPedido> lineasPedido = new ArrayList<LineaPedido>();
				lineasPedido.add(lineaPedido);
				Pedido pedido = new Pedido (mesa, lineasPedido);
				MyTask.listaPedidos.add(pedido);
				System.out.println("Pedido creado");
				encontrado = true;
			} else {
				i++;
			}
		}	
	}
	
	public static void editarPedido() {
		Scanner teclat = new Scanner(System.in);
		System.out.println("Editar pedido");
		for (int i = 0; i < MyTask.listaPedidos.size();i++) {
			System.out.println(MyTask.listaPedidos.get(i));
		}
		System.out.println("ID del pedido a editar");
		int id = teclat.nextInt();
		for (int x = 0; x < MyTask.listaPedidos.size();x++) {
			if (id == MyTask.listaPedidos.get(x).getId()) {
				System.out.println("Plato a añadir");
				int plate = teclat.nextInt();
				System.out.println("Cantidad");
				int cantidad = teclat.nextInt();
				boolean found = false;
				int i = 1;
				while (found == false && i<MyTask.listaPlatos.size()) {
					if (plate == MyTask.listaPlatos.get(i).getId()) {
						Plato plato = new Plato (MyTask.listaPlatos.get(i).getNombre(), MyTask.listaPlatos.get(i).getPrecio());
						LineaPedido lineaPedido = new LineaPedido (plato, "Pedido", cantidad);
						MyTask.listaPedidos.get(x).getLineasPedido().add(lineaPedido);
						found = true;
					} else {
						i++;
					}
				}
			}
		}		
	}
	
	public void actuar() {
		Scanner teclat = new Scanner(System.in);
		System.out.println("Actualizar pedido");
		// Veure els pedidos
		System.out.println("Pedidos disponibles: ");
		for (int i = 0; i < MyTask.listaPedidos.size();i++) {
			System.out.println(MyTask.listaPedidos.get(i));
		}
		System.out.println("Pedido a actualizar");
		int id = teclat.nextInt();
		for (int x = 0; x < MyTask.listaPedidos.size();x++) {
			if (id == MyTask.listaPedidos.get(x).getId()) {
				System.out.println("Pedido encontrado");
				System.out.println("Linea a pedido a mostrar");
				// Veure les linees de pedido que hi ha a un pedido
				for (int j = 0; j < MyTask.listaPedidos.get(x).getLineasPedido().size(); j++) {
					System.out.println(MyTask.listaPedidos.get(x).getLineasPedido().get(j));
				}
				System.out.println("Seleccionar linea: ");
				int lp = teclat.nextInt();
				for (int q = 0; q < MyTask.listaPedidos.get(x).getLineasPedido().size(); q++) {
					if (lp == ((LineaPedido) MyTask.listaPedidos.get(x).getLineasPedido().get(q)).getId()) {
						System.out.println("Avanzando estado");
						String estado = ((LineaPedido) MyTask.listaPedidos.get(x).getLineasPedido().get(q)).getEstado();
						if (estado == "Listo") {
							((LineaPedido) MyTask.listaPedidos.get(x).getLineasPedido().get(q)).setEstado("Servido");					}
							}
						}
					}
				}
			}
		
	public static void sacarTicket () {
		Scanner teclat = new Scanner (System.in);
		System.out.println("Dame el id del pedido");
		int id = teclat.nextInt();
		int a = 0;
		for (int i = 0; i < MyTask.listaPedidos.size(); i++) {
			if (id == MyTask.listaPedidos.get(i).getId()) {
				for (int x = 0; x < MyTask.listaPedidos.get(i).getLineasPedido().size(); x++) {
					int b = (int) ((LineaPedido) MyTask.listaPedidos.get(i).getLineasPedido().get(x)).getPlato().getPrecio();
					int c = (int) ((LineaPedido) MyTask.listaPedidos.get(i).getLineasPedido().get(x)).getCantidad();
					int d = b * c;
					a = a + d;
				}	
			}
		}
		System.out.println("El precio total es: "+a);
	}
	
}
	