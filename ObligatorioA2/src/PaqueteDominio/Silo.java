package PaqueteDominio;

public class Silo extends Punto {

	private int capacidad;
	
	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Silo(String nombre, Double coordX, Double coordY, int capacidad) {
		super(coordX, coordY, nombre);
		this.capacidad = capacidad;
	}
	
}
