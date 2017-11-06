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
	
	public boolean disminuirCapacidadRemanente(int capacidadPlantacion) {
		if(capacidadRemanente >= capacidadPlantacion) {
			this.capacidadRemanente -= capacidadPlantacion;
			return true;
		}
		return false;
	}

	public Silo(String nombre, Double coordX, Double coordY, int capacidad) {
		super(coordX, coordY, nombre);
		this.capacidad = capacidad;
		this.capacidadRemanente = capacidad;
		this.setTipoPunto(Sistema.TipoPunto.SILO);
	}

	
}
