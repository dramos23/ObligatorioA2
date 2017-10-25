package PaqueteHash;

import java.util.Arrays;

public class Hash implements IHash{

	private int tamanio;
	private String[] arreglo;
	
	public Hash (int tam) {
		this.tamanio = tam;
		this.arreglo = new String[tam];
		Arrays.fill(this.arreglo, "0");
	}
	
	public void Insertar(int i){
		
	};
	
	public void Borrar(int i){};
	
	public void Modificar(int i, int j){};
	
	public void Pertenece(int i){};
	
}
