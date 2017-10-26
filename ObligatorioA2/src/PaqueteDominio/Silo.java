package PaqueteDominio;

public class Silo extends Punto {

	private int capacidad;
	
	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Silo(Double coordX, Double coordY, String nombre, int capacidad) {
		super(coordX, coordY, nombre);
		this.capacidad = capacidad;
	}
	
}
