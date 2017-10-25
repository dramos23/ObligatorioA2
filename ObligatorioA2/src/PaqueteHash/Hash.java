package PaqueteHash;

import java.util.Arrays;

public class Hash implements IHash{

	private int tamanio;
	private int[] arregloA;
	private int[] arregloB;
	
	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = numeroPrimoMenorA(tamanio);
	}
	
	public Hash (int tam) {
		this.tamanio = tam;
		this.arregloA = new int[tam];
		this.arregloB = new int[tam];
		Arrays.fill(this.arregloA, 0);
	}
	
	public void Insertar(int n){
		int indice = n % this.tamanio;
		int R = numeroPrimoMenorA(this.tamanio-1);
		int j = 0;
		while(this.arregloA[indice] != 1 && j < this.tamanio) {
			indice = (indice + j*( R - n % R )) % this.tamanio;
			j++;		
		}
		this.arregloB[indice] = n;
		this.arregloA[indice] = 1;
	};
		
	public void Borrar(int n){
		int R = numeroPrimoMenorA(this.tamanio-1);
		int indice = n % this.tamanio;
		boolean encontrado = true;
		int j = 0;
		while ( encontrado ) {
			if (this.arregloA[indice] == 1 && this.arregloB[indice] == n) {
				this.arregloB[indice] = 0;
				this.arregloA[indice] = -1;
			}	
			indice = (indice + j*( R - n % R )) % this.tamanio;
			j++;
			if (j >= this.arregloA.length && j < this.tamanio) {
				break;
			}
		}
		
	};
	
	public void Modificar(int n, int m){
		this.Borrar(n);
		this.Insertar(m);	
	};
	
	public int Buscar(int n) {
		int R = numeroPrimoMenorA(this.tamanio-1);
		int indice = n % this.tamanio;
		boolean encontrado = true;
		int j = 0;
		while ( encontrado ) {
			if (this.arregloA[indice] == 1 && this.arregloB[indice] == n) {
				return	this.arregloB[indice];
			}	
			indice = (indice + j*( R - n % R )) % this.tamanio;
			j++;
			if (j >= this.arregloA.length  && j < this.tamanio) {
				break;
			}
		}
		return -1;
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
			ent = 0;
		}
		return n;
	}
	
	public void Pertenece(int i){}; //no se para que sirve
	
}
