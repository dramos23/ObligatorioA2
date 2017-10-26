package PaqueteArbolBB;

public class Nodo {
    //Atributos
    private int dato;
	private Nodo der ;
	private Nodo izq ;

    //Constructores
    public Nodo(int n){
        dato = n;
        izq = null;
        der = null;
     }

    public Nodo(int n, Nodo i, Nodo d){
        dato = n;
        izq = i;
        der = d;
     }

    //Dato
    int getDato(){
        return dato;
    }
    void setDato(int n){
        dato = n;
    }
    
    //Derecho
    Nodo getDer(){
        return der;
    }
    void setDer(Nodo d){
       der = d;
    }
    
    //Izquierdo
    Nodo getIzq(){
        return izq;
    }
    void setIzq(Nodo i){
        izq = i;
    }

}
