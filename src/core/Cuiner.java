package core;

import java.util.Scanner;

public class Cuiner extends Persona{
	
	public Cuiner (String nombre) {
		super(nombre);
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
						if (estado == "Pedido") {
							((LineaPedido) MyTask.listaPedidos.get(x).getLineasPedido().get(q)).setEstado("Cocina");					
							}
						if (estado == "Preparando") {
							((LineaPedido) MyTask.listaPedidos.get(x).getLineasPedido().get(q)).setEstado("Listo");
					}
						}
					}
				}
			}
	}
	public static void verPendientes() {
		for (int i = 0; i < MyTask.listaPedidos.size(); i++) {
			for (int x = 0; x < (int) MyTask.listaPedidos.get(i).getLineasPedido().size(); x++) {
				if (((LineaPedido) MyTask.listaPedidos.get(i).getLineasPedido().get(x)).getEstado() == "Pedido" || ((LineaPedido) MyTask.listaPedidos.get(i).getLineasPedido().get(x)).getEstado() ==  "Cocina") {
					System.out.println(MyTask.listaPedidos.get(i).getLineasPedido().get(x));
				}
			}
		}
	}
	
}
