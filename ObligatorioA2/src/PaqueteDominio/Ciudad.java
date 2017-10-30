package PaqueteDominio;

import PaqueteSistema.Sistema;

public class Ciudad extends Punto{

	public Ciudad(String nombre, Double coordX, Double coordY) {
		super(coordX, coordY, nombre);
		this.setTipoPunto(Sistema.TipoPunto.CIUDAD);
	}


}
