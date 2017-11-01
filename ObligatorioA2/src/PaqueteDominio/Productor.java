package PaqueteDominio;

public class Productor {

	private String cedula;
	private String nombre;
	private String direccion;
	private String email;
	private String celular;
	
	public String getCedula() {
		return cedula;
	}
	
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Productor(String cedula, String nombre, String direccion, String email, String celular) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.direccion = direccion;
		this.email = email;
		this.celular = celular;
	}
	
	public int validar(){
		//TO-DO
		//0 si todo OK
//		1. Si la cédula cédula no cumple el formato N.NNN.NNN-N
//		2. Si el número de celular celular no cumple el formato 09NNNNNNN
//		3. Si el email email no cumple el formato de direcciones de e-mail
		return 0;
	}
	
	public int cedulaSoloNumeros(){
		String retorno = this.cedula;
		retorno = cedula.replace("-","");
		retorno = cedula.replace(".","");
		return Integer.parseInt(retorno);
	}
	
	@Override
	public String toString(){
		return cedulaSoloNumeros() + ";" + nombre +  ";" + celular;
	}
	
}
