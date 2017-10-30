package PaqueteHash;

import java.util.Arrays;

import PaqueteDominio.Punto;

public class Hash {

	private int tamanio;
	private String[] estados; //O - ocupado, V - vacío, E - eliminado
	private Punto[] datos;
	
	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}
	
	public Hash (int tam) {
		this.tamanio = numeroPrimoMayorA(tam);
		this.estados = new String[tam];
		this.datos = new Punto[tam];
		Arrays.fill(this.estados, "V"); //debugear y ver si estan en 0 antes
	}
	
	public void Insertar(Punto p) {
		int n = p.coordenadasAInt();
		
		int indice = n % this.tamanio; //indice: 89 % 10 = 9
		int R = numeroPrimoMenorA(this.tamanio-1); //R: numeroPrimoMenorA(10) = 7
		int j = 0;
		while(this.estados[indice].equals("O") && j < this.tamanio) { //estados[9] = "V", 0 < 10. no entra
			indice = (indice + j*( R - n % R )) % this.tamanio; 
			j++;		
		}
		this.datos[indice] = p; //datos[9] = 89 . dato
		this.estados[indice] = "O"; //estados[9] = 1 . ocupado
	}
	
//	public void Insertar(Object o){ //n: 89
//		this.Insertar((Punto)o);
//	};
//		
	public void Borrar(Punto p){
		int R = numeroPrimoMenorA(this.tamanio-1);
		int n = p.coordenadasAInt();
		int indice = n % this.tamanio;
		boolean encontrado = false;
		int j = 0;
		while ( !encontrado ) {
			if (this.estados[indice].equals("O") && this.datos[indice].equals(p)) {
				this.datos[indice] = p; //reinicializo en 0
				this.estados[indice] = "E";
			}	
			indice = (indice + j*( R - n % R )) % this.tamanio;
			j++;
			if (j >= this.estados.length && j < this.tamanio) {
				encontrado = true;
			}
		}
		
	};
	
	public Punto Buscar(Punto p) {
		int R = numeroPrimoMenorA(this.tamanio-1);
		int n = p.coordenadasAInt();
		int indice = n % this.tamanio;
		boolean encontrado = false;
		int j = 0;
		while ( !encontrado ) {
			if (this.estados[indice].equals("O") && this.datos[indice].equals(p)) {
				return	this.datos[indice];
			}	
			indice = (indice + j*( R - n % R )) % this.tamanio;
			j++;
			if (j >= this.estados.length  && j < this.tamanio) {
				encontrado = true;
			}
		}
		return null;
	}
	
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
