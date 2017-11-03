package PaqueteDominio;

import PaqueteSistema.Sistema;

public class Plantacion extends Punto{

	private int capacidad;
	private String cedula_productor;

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getCedula_productor() {
		return cedula_productor;
	}

	public void setCedula_productor(String cedula_productor) {
		this.cedula_productor = cedula_productor;
	}

	public Plantacion(String nombre, Double coordX, Double coordY, String cedula_productor, int capacidad) {
		super(coordX, coordY, nombre);
		this.capacidad = capacidad;
		this.cedula_productor = cedula_productor;
		this.setTipoPunto(Sistema.TipoPunto.PLANTACIÓN);
	}
	
	@Override
	public String toString(){
		return this.getCoordX() + ";"+ this.getCoordY();
	}
	
	
}
