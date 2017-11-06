package PaqueteHash;

import java.util.Arrays;

import PaqueteDominio.Punto;

public class Hash {

	private int tamanio;
	private String[] estados; //O - ocupado, V - vacío, E - eliminado
	private int[] claves;
	
	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}
	
	public Hash (int tam) {
		this.tamanio = numeroPrimoMayorA(tam);
		this.estados = new String[tamanio];
		this.claves = new int[tamanio];
		Arrays.fill(this.estados, "V");
	}
	
	//PRE: Punto validado
	//POST: Punto insertado en una posición que se retorna. Estado en esa posición en "O"
	// si indice = 0 ya existe el punto p en hash
	// si indice = -1 no existe en hash
	public int Insertar(Object o) {
		
		Punto p = (Punto)o;
		int indice = Existe(p.getCoordX(),p.getCoordY());
		
		if(indice == -1){
			
			int n = this.getClave(p.getCoordX(),p.getCoordY());
			
			indice = n % this.tamanio;
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
		return -1;
	}
	
	//PRE: Punto validado
	//POST: Punto borrado en una posición que se retorna. Estado en esa posición en "E"
	public int Borrar(Double x, Double y){
		int indice = Existe(x,y);
		if(indice != -1){
			this.claves[indice] = 0; //reinicializo en 0
			this.estados[indice] = "E";
		}
		return indice;
	};
	
	//Retorna -1 si no existe.
	public int Existe(Double coordX,Double coordY) {
		int R = numeroPrimoMenorA(this.tamanio-1);
		int n = this.getClave(coordX,coordY);
		int indice = n % this.tamanio;
		int j = 0;
		while ( j < this.tamanio ) {
			if (this.estados[indice].equals("O") && this.claves[indice] == n) {
				return indice;
			}	
			indice = (indice + j*( R - n % R )) % this.tamanio;
			j++;
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
			contador = 1;
			ent = 0;
		}
		return n;
	}
	
	private int numeroPrimoMayorA(int n) {
		for (int i = n; i <= Integer.MAX_VALUE; i++ ){
			if (esPrimo(i)){
				return i;
			}
		}
		return n;
	}
	
	private boolean esPrimo(int numero){
		  int contador = 2;
		  boolean primo=true;
		  while ((primo) && (contador!=numero)){
		    if (numero % contador == 0)
		      primo = false;
		    contador++;
		  }
		  return primo;
		}
	
//	public int getClave(Double coordX, Double coordY){
//		String clave = coordX*2+","+coordY;
//		int disp = 0;
//		for(int i = 0; i<clave.length();i++)
//			disp+=(int)clave.charAt(i);
//		return disp;
//	}
	
	public int getClave(Double coordX, Double coordY){
		int clave = coordToInt_Clave(coordX.toString()) + coordToInt_Clave(coordY.toString());
		return clave;
	}
	
	private int coordToInt_Clave(String str) {
		int valor = 0;
		for(int i = 0; i< str.length();i++) {
			valor += (int)str.charAt(i)*Math.pow(2, i);
		}
		return valor;
	}
	
}
