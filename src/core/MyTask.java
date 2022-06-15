package core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class MyTask {
	static ArrayList <Persona> listaEmpleats = new ArrayList<Persona>();
	static ArrayList <Plato> listaPlatos = new ArrayList<Plato>() ;
	static ArrayList <Pedido> listaPedidos = new ArrayList<Pedido>();
	public static int numerador = 0;
	
	
	
	public static void main (String [] args) throws IOException {
		Camarer camarer = new Camarer("Jordi ");
		Cuiner cuiner = new Cuiner("Miquel");
		listaEmpleats.add(camarer);
		listaEmpleats.add(cuiner);
		System.out.println(listaEmpleats.get(0).toString());
		System.out.println(listaEmpleats.get(1).toString());
		
		Scanner teclat = new Scanner (System.in);
		System.out.println("Cargando platos");
		Plato.cargarPlatos();
		System.out.println("Platos cargados");
		
		System.out.println("Introduce tu ID");
		int identifier = teclat.nextInt();
		
		for (int i = 0; i < listaEmpleats.size(); i++) {
			if (identifier == listaEmpleats.get(i).getId()) {
				System.out.println("Hola, " + listaEmpleats.get(i).getNombre());
				if (listaEmpleats.get(i).getClass().getName()=="core.Camarer") {
					boolean menu = true;
					while (menu == true) {
						System.out.println("Menú de camarero");
						System.out.println("1.- Crear pedido");
						System.out.println("2.- Editar pedido");
						System.out.println("3.- Actuar");
						System.out.println("4.- Sacar tickets");
						System.out.println("5.- Ver pendientes");
						System.out.println("6.- Calcular caja");
						System.out.println("7.- Salir");
						
						int eleccion = teclat.nextInt();
						
						switch (eleccion) {
						case 1:
							Camarer.crearPedido();
							break;
						case 2:
							Camarer.editarPedido();
							break;
						case 3:
							((Camarer) listaEmpleats.get(i)).actuar();
							break;
						case 4:
							Camarer.sacarTicket();
							break;
						case 5:
							Persona.verPendientes();
							break;
						case 6:
							Persona.calcularCaja();
							break;
						case 7:
							menu = false;
							break;
					}
				}
			}
			if (listaEmpleats.get(i).getClass().getName()=="core.Cuiner") {
				boolean menu = true;
				while (menu == true) {
					System.out.println("Menú de cocinero");
					System.out.println("1.- Ver pendientes");
					System.out.println("2.- Actuar");
					System.out.println("3.- Salir");
					
					int eleccion = teclat.nextInt();
					
					switch(eleccion) {
					case 1:
						Cuiner.verPendientes();
						break;
					case 2:
						((Cuiner) listaEmpleats.get(i)).actuar();
						break;
					case 3:
						menu = false;
						break;
					}
				}
			}
		}
	}
	}
}
