package PaqueteDominio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Productor {

	private String cedula;
	private String nombre;
	private String direccion;
	private String email;
	private String celular;
	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String PATTERN_CELULAR = "^[09]{2}\\d{7}$";
	private static final String PATTERN_CEDULA = "^\\d{1}.\\d{3}.\\d{3}-\\d{1}$";
	
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
	
	public Productor(){
		
	}
	
	//0 si todo OK
	//	1. Si la cédula cédula no cumple el formato N.NNN.NNN-N
	//	2. Si el número de celular celular no cumple el formato 09NNNNNNN
	//	3. Si el email email no cumple el formato de direcciones de e-mail
	public int validar(){

		if (!validarCedula(this.cedula))
			return 1;
		if (!validarCelular(this.celular))
			return 2;
		if (!validarEmail(this.email))
			return 3;
		return 0;
	}
	
	public int cedulaSoloNumeros(){
		String retorno = this.cedula;
		retorno = retorno.replace("-","");
		retorno = retorno.replace(".","");
		return Integer.parseInt(retorno);
	}
	
	@Override
	public String toString(){
		return cedulaSoloNumeros() + ";" + nombre +  ";" + celular;
	}
	
    
 
    private boolean validarEmail(String email) {
 
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
 
    }
    
    private boolean validarCelular(String celular) {
    	 
        Pattern pattern = Pattern.compile(PATTERN_CELULAR);
        Matcher matcher = pattern.matcher(celular);
        return matcher.matches();
 
    }
	
    private boolean validarCedula(String cedula) {
   	 
        Pattern pattern = Pattern.compile(PATTERN_CEDULA);
        Matcher matcher = pattern.matcher(cedula);
        return matcher.matches();
 
    }
    
    public boolean validarMiCedula(){
    	return validarCedula(this.cedula);
    }
}
