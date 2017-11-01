package PaqueteDominio;

public abstract class Punto {

	private Double coordX;
	private Double coordY;
	private String nombre;
	private Object tipoPunto;
	
	protected void setTipoPunto(Object tipoPunto){
		this.tipoPunto = tipoPunto;
	}
	
	public Object getTipoPunto(){
		return tipoPunto;
	}
	
	
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
	
	public int getClave(){
		String clave = coordX*2+","+coordY;
		int disp = 0;
		for(int i = 0; i<clave.length();i++)
			disp+=(int)clave.charAt(i);
		return disp;
	}
	
	@Override
	public boolean equals(Object o){
		try {
			Punto p = (Punto)o;
			return p.getCoordX() == coordX && p.getCoordY() == coordY;
		} catch(Exception ex){
			System.out.println("Excepción: " +ex.getMessage());
			return false;
		}
	}
	
	
}
