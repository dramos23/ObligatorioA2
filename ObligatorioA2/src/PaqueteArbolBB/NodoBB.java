package PaqueteArbolBB;

public class NodoBB {
    //Atributos
    private int valor;
    //private Object dato;
	private NodoBB der;
	private NodoBB izq;

    //Constructores
    public NodoBB(int n){
        valor = n;
        izq = null;
        der = null;
     }

    public NodoBB(int n, NodoBB i, NodoBB d){
        valor = n;
        izq = i;
        der = d;
     }

    //Dato
    public int getDato(){
        return valor;
    }
    public void setDato(int n){
        valor = n;
    }
    
    //Derecho
    public NodoBB getDer(){
        return der;
    }
    public void setDer(NodoBB d){
       der = d;
    }
    
    //Izquierdo
    public NodoBB getIzq(){
        return izq;
    }
    public void setIzq(NodoBB i){
        izq = i;
    }

}
