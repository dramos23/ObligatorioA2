package PaqueteHash;

import java.util.Arrays;

import PaqueteDominio.Punto;

public class Hash implements IHash {

	private int tamanio;
	private String[] estados; //O - ocupado, V - vac�o, E - eliminado
	private int[] claves;
	
	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}
	
	public Hash (int tam) {
		this.tamanio = numeroPrimoMayorA(tam);
		this.estados = new String[tam];
		this.claves = new int[tam];
		Arrays.fill(this.estados, "V");
	}
	
	//PRE: Punto validado
	//POST: Punto insertado en una posici�n que se retorna. Estado en esa posici�n en "O"
	public int Insertar(Object o) {
		Punto p = (Punto)o;
		int n = p.getClave();
		
		int indice = n % this.tamanio;
		int R = numeroPrimoMenorA(this.tamanio-1); 
		int j = 0;
		while(this.estados[indice].equals("O") && j < this.tamanio) { 
			indice = (indice + j*( R - n % R )) % this.tamanio; 
			j++;		
		}
		this.claves[indice] = n;
		this.estados[indice] = "O";
		return indice;
	}
	
	//PRE: Punto validado
	//POST: Punto borrado en una posici�n que se retorna. Estado en esa posici�n en "E"
	public int Borrar(Object o){
		Punto p = (Punto)o;
		int R = numeroPrimoMenorA(this.tamanio-1);
		int n = p.getClave();
		int indice = n % this.tamanio;
		int j = 0;
		while ( j < this.tamanio ) {
			if (this.estados[indice].equals("O") && this.claves[indice] == n) {
				this.claves[indice] = 0; //reinicializo en 0
				this.estados[indice] = "E";
				return indice;
			}	
			indice = (indice + j*( R - n % R )) % this.tamanio;
			j++;
		}
		return -1;		
	};
	
	private int numeroPrimoMenorA(int n) {
		int contador = 1;
		int ent = 0;
		for (int i = 0; i < n; i++) {
			while (contador != n-i){
				if (n-i % contador == 0) {
					ent++;					
				}
				contador++;
			}
			if ( ent == 2 ){
				return n-i;
			}
			contador = 1;
			ent = 0;
		}
		return n;
	}
	
	private int numeroPrimoMayorA(int n) {
		int contador = 1;
		int ent = 0;
		for (int i = 0; i < n; i++) {
			while (contador != n+i){
				if (n+i % contador == 0) {
					ent++;					
				}
				contador++;
			}
			if ( ent == 2 ){
				return n+i;
			}
			contador = 1;
			ent = 0;
		}
		return n;
	}
	
}
