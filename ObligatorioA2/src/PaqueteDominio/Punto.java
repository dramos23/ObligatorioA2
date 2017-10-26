package PaqueteDominio;

public abstract class Punto {

	private Double coordX;
	private Double coordY;
	private String nombre;
	
	public Double getCoordX() {
		return coordX;
	}
	
	public void setCoordX(Double coordX) {
		this.coordX = coordX;
	}
	
	public Double getCoordY() {
		return coordY;
	}
	
	public void setCoordY(Double coordY) {
		this.coordY = coordY;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Punto(Double coordX, Double coordY, String nombre) {
		this.coordX = coordX;
		this.coordY = coordY;
		this.nombre = nombre;
	}
	
	
	
}
