package PaqueteDominio;

import PaqueteSistema.Sistema;

public class Silo extends Punto{

	private int capacidad;
	private int capacidadRemanente;
	
	public int getCapacidadRemanente(){
		return capacidadRemanente;
	}
	
	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	public void setCapacidadRemanente(int capacidadRemanente){
		this.capacidadRemanente = capacidadRemanente;
	}

	public Silo(String nombre, Double coordX, Double coordY, int capacidad) {
		super(coordX, coordY, nombre);
		this.capacidad = capacidad;
		this.setTipoPunto(Sistema.TipoPunto.SILO);
	}

	
}
