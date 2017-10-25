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
		this.tamanio = tamanio;
	}
	
	public Hash (int tam) {
		this.tamanio = tam;
		this.arregloA = new int[tam];
		this.arregloB = new int[tam];
		Arrays.fill(this.arregloA, 0);
	}
	
	public void Insertar(int n){
		int indice = n % 10;
		int j = 0;
		while(this.arregloA[indice] != 1) {
			indice = (indice + j*( 7 - n % 7 )) % 10;
			j++;		
		}
		this.arregloB[indice] = n;
		this.arregloA[indice] = 1;
	};
		
	public void Borrar(int n){
		
		int indice = n % 10;
		boolean encontrado = true;
		int j = 0;
		while ( encontrado ) {
			if (this.arregloA[indice] == 1 && this.arregloB[indice] == n) {
				this.arregloB[indice] = 0;
				this.arregloA[indice] = -1;
			}	
			indice = (indice + j*( 7 - n % 7 )) % 10;
			j++;
			if (j > this.arregloA.length) {
				break;
			}
		}
		
	};
	
	public void Modificar(int i, int j){};
	
	public int Buscar(int n) {
		
		int indice = n % 10;
		boolean encontrado = true;
		int j = 0;
		while ( encontrado ) {
			if (this.arregloA[indice] == 1 && this.arregloB[indice] == n) {
				return	this.arregloB[indice];
			}	
			indice = (indice + j*( 7 - n % 7 )) % 10;
			j++;
			if (j > this.arregloA.length) {
				break;
			}
		}
		return -1;
	}
	
	public void Pertenece(int i){};
	
}
