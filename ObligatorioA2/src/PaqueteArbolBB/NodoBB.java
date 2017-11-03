package PaqueteArbolBB;

public class NodoBB {
    //Atributos
    private int valor;
    private Object objeto;
	private NodoBB der;
	private NodoBB izq;

    //Constructores
    public NodoBB(Object objeto, int valor){
        this.objeto = objeto;
        this.valor = valor;
        izq = null;
        der = null;
     }

    public NodoBB(){
       
    }

    public Object getObjeto(){
        return objeto;
    }
    public void setDato(Object o){
        objeto = o;
    }
    
    public int getValor(){
    	return valor;
    }
    
    public void setValor(int valor){
    	this.valor = valor;
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
