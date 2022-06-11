package core;

import java.util.ArrayList;

public class Pedido {
	private int id;
	private int mesa;
	private ArrayList lineasPedido = new ArrayList<LineaPedido>();
	private static int contadorp = 0;
	
	// Setters i getters
	
	public int getId() {
		return id;
	}
	public void setId() {
		contadorp++;
		this.id = contadorp;
	}
	public int getMesa() {
		return mesa;
	}
	public void setMesa(int mesa) {
		this.mesa = mesa;
	}
	public ArrayList getLineasPedido() {
		return lineasPedido;
	}
	public void setLineaPedido(ArrayList lineasPedido) {
		this.lineasPedido = lineasPedido;
	}
	public static int getContadorp() {
		return contadorp;
	}
	
	// Constructors
	
	public Pedido() {}
	
	public Pedido(int mesa, ArrayList <LineaPedido> lineasPedido) {
		this.setId();
		this.setMesa(mesa);
		this.setLineaPedido(lineasPedido);
	}
	
	// Mètodes
	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", mesa=" + mesa + ", lineasPedido=" + lineasPedido + "]";
	}
	
	
	
	
	
}
