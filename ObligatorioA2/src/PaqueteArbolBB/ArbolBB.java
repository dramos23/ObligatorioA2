package PaqueteArbolBB;

import PaqueteDominio.Productor;

public class ArbolBB{
	
    private NodoBB raiz;
    	
	public ArbolBB() {
		this.raiz = null;
	}

    public boolean esArbolVacio() {
		return (raiz == null) ;
	}

    public String obtenerObjetosInOrder(){
    	return obtenerObjetosInOrder(this.raiz);
    }
    
    public String obtenerObjetosInOrder(NodoBB a){
    	String retorno = "";
    	String valor = "";
        if (a != null){
        	valor = obtenerObjetosInOrder(a.getIzq());
        	if ( valor != "" )
        		retorno += valor + " | "; 
            
        	retorno += a.getObjeto();
             
            valor = obtenerObjetosInOrder(a.getDer());
            if ( valor != "" )
        		retorno += " | " + valor;
        }
        return retorno;
    }

    public boolean existeProductor(String cedula){
    	Productor p = new Productor();
    	p.setCedula(cedula);
    	if(p.validarMiCedula()){
    		int cedulaSoloNumeros = p.cedulaSoloNumeros();
    		return existe(cedulaSoloNumeros,raiz);
    	} else {
    		return false;
    	}
    }

    public boolean existe(int e, NodoBB a) {
	   boolean existe;
        if(a == null)
			existe = false;
		else
        {
            if( e == a.getValor() )
				existe=true;
			else if( e < a.getValor() )
				existe = existe(e, a.getIzq());
			else
				existe = existe(e, a.getDer());
		}
        return existe;
	}
    
    public boolean insertar(int x, Object o) {
    	if(raiz == null) {
    		raiz = new NodoBB(o,x);
    		return true;
    	}
    	
    	if(existe(x,raiz)) {
    		return false;
    	} else {
    		insertar(x,o,raiz);
    		return true;
    	}
    }

    //pre: el valor no esta en el arbol
    //post: nodo insertado
    private void insertar(int x, Object o, NodoBB n) {
    	if(n.getValor() > x) {
    		if(n.getIzq() == null)
    			n.setIzq(new NodoBB(o,x));
    		else
    			insertar(x,o, n.getIzq());
    	} else {
    		if(n.getDer() == null)
    			n.setDer(new NodoBB(o,x));
    		else
    			insertar(x, n.getDer());
    	}
    }
 
    //POST: Retorna 0 si pudo agregar el productor al árbol
    //		Retorna 1,2 o 3 si no pudo validar formato
    //		Retorna 4 si ya existe el productor con esa cédula
    public int insertarProductor(String cedula, String nombre, String direccion, String email, String celular){
    	Productor p = new Productor(cedula,nombre,direccion,email,celular);
    	int retorno = p.validar();
    	if(retorno == 0){
    		if(!insertar(p.cedulaSoloNumeros(),p))
    			retorno = 4;
    	}
    	return retorno;
    }
    
}
