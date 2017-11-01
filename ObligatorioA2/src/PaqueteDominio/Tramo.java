package PaqueteDominio;

public class Tramo {

	private Punto puntoI;
	private Punto puntoF;
	private int peso;
	
	public Punto getPuntoI() {
		return puntoI;
	}
	
	public void setPuntoI(Punto puntoI) {
		this.puntoI = puntoI;
	}
	
	public Punto getPuntoF() {
		return puntoF;
	}
	
	public void setPuntoF(Punto puntoF) {
		this.puntoF = puntoF;
	}
	
	public int getPeso() {
		return peso;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Tramo(Punto puntoI, Punto puntoF, int peso) {
		this.puntoI = puntoI;
		this.puntoF = puntoF;
		this.peso = peso;
	}
}
