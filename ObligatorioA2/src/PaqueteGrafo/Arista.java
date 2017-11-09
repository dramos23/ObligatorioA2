package PaqueteGrafo;

public class Arista{
	private int destino;
	private int peso;
	
	public Arista(int destino, int peso) {
		this.destino = destino;
		this.peso = peso;
	}
	
	public Arista(int destino) {
		this.destino = destino;
	}
	
	public Arista(){
		
	}
	
	public int getDestino(){
		return destino;
	}
	
	public int getPeso(){
		return peso;
	}
	
	public void setDestino(int destino){
		this.destino = destino;
	}
	
	public void setPeso(int peso){
		this.peso = peso;
	}
	
	@Override
	public boolean equals(Object o) {
		try {
			Arista a = (Arista)o;
			return a.destino == this.destino;
		} catch(Exception e) {
			return false;
		}
	}
}
