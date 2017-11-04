package PaqueteArbolBB;

import PaqueteDominio.Productor;

public class ArbolBB{
	
    private NodoBB raiz;
    	
	public ArbolBB() {
		this.raiz = null;
	}
		
	public NodoBB getRaiz() {
		return raiz;
	}

    public boolean esArbolVacio() {
		return (raiz == null) ;
	}

    public void mostrarPreOrder(){
    	mostrarPreOrder(this.raiz);
    }
    
    public void mostrarPreOrder(NodoBB a){
        if (a!=null){
            System.out.print(a.getValor()+"   ");
            mostrarPreOrder(a.getIzq());
            mostrarPreOrder(a.getDer());
        }
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

    public void mostrarInOrder(){
    	mostrarInOrder(this.raiz);
    }
    
    public void mostrarInOrder(NodoBB a){
        if (a!=null){
            mostrarInOrder(a.getIzq());
            System.out.print(a.getValor()+"  ");
            mostrarInOrder(a.getDer());
        }
    }

    public void mostrarPosOrder(){
    	mostrarPosOrder(this.raiz);
    }
    
    public void mostrarPosOrder(NodoBB a){
        if (a!=null){
            mostrarPosOrder(a.getIzq());
            mostrarPosOrder(a.getDer());
            System.out.print(a.getValor()+"  ");
        }
    }

    public boolean existeElemento(int e) {
		NodoBB nodo = obtenerElemento(e, raiz);
		
		if(nodo != null) {
			return true;
		} else {
			return false;
		}
	}
    
    public boolean existeProductor(String cedula){
    	Productor p = new Productor();
    	p.setCedula(cedula);
    	if(p.validarMiCedula()){
    		int cedulaSoloNumeros = p.cedulaSoloNumeros();
    		return existeElemento(cedulaSoloNumeros);
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

    public NodoBB obtenerElemento(int n, NodoBB nodo) {
		if(nodo == null) {
			return nodo;
		} else {
			if(n == nodo.getValor() ) {
				return nodo;
			} else if( n < nodo.getValor() ) {
				return obtenerElemento(n, nodo.getIzq());
			} else {
				return obtenerElemento(n, nodo.getDer());
			}
		}
	}
	
	public int cantNodos(NodoBB nodo) {
		int cont = 0;
		if(nodo != null)
        {
			cont += cantNodos(nodo.getIzq()); 	//cuenta subarbol izquierdo
			cont++; 							// contabilizar el nodo visitado
			cont += cantNodos(nodo.getDer());	//cuenta subarbol derecho
            
		}
		return cont;
	}

    public int obtenerPeso(NodoBB nodo) {
		int peso     = 0;
		int peso_izq = 0;
		int peso_der = 0;

		if(nodo != null) {
			peso_izq = cantNodos(nodo.getIzq());
			peso_der = cantNodos(nodo.getDer());
			peso = peso_izq + peso_der;
            
		}
		return peso;
	}

    public void insertarElemento(int n, Object o, NodoBB nodo) {
		NodoBB nuevo = null;

        if (this.esArbolVacio())
            this.raiz = new NodoBB(o,n);

        else if( n < nodo.getValor())
        {   // n < dato => insertar en subarbol izq
            if(nodo.getIzq() == null)
            {
                nuevo = new NodoBB(o,n);
                nodo.setIzq(nuevo);
             }
             else
                 insertarElemento(n, o,nodo.getIzq());
        }
        else if( n > nodo.getValor())
        {   // n > dato => insertar en subarbol derecho
			if(nodo.getDer() == null)
            {
				nuevo = new NodoBB(o,n);
				nodo.setDer(nuevo);
			}
            else
				insertarElemento(n, o, nodo.getDer());
		}
	}
    
    public int cantHojas(NodoBB nodo){
    	if (nodo.getDer() == null)
    		if (nodo.getIzq() == null)
    			return 1;
    		else
    			return cantHojas(nodo.getIzq());
    	else if (nodo.getIzq()== null)
    			return cantHojas(nodo.getDer());
    		else 
    			return cantHojas(nodo.getIzq())+cantHojas(nodo.getDer());
    }

    public NodoBB borrarMinimo(NodoBB nodo){
    	if( nodo == null )
            return nodo;
        
        if (nodo.getIzq()!= null ) {
            nodo.setIzq(borrarMinimo( nodo.getIzq() )) ;
            return nodo;
        } else
            return nodo.getDer();
    }
    
//    public boolean insertar( int x, Object o ) {
//    	if(raiz == null){
//    		raiz = new NodoBB(o,x);
//    		return true;
//    	} else {
//    		return insertarSinRepetir(x,o,this.raiz);
//    	}        
//    }
    
//    public NodoBB insertar( int x, Object o ) {
//    	
//    	return insertarSinRepetir(x,o,this.raiz);
//    	
//    }        
    
    public boolean insertar( int x, Object o ) {
    	if(raiz == null){
    		raiz = new NodoBB(o,x);
    		return true;
    	} else {
    		NodoBB n = insertarSinRepetir(x,o,this.raiz);
    		if (n.getObjeto() == null)
    			return false;
    		return true;	
    	}        
    }
    
    
//    private NodoBB insertar( int x, Object o, NodoBB a ) {
//        if( a == null )
//            a = new NodoBB(o,x);
//        else if(x == a.getValor())
//        	
//        else if(x < a.getValor() )
//            a.setIzq( insertar( x, o, a.getIzq()) ); // a.izq = insertar(x, a.izq); con los atributos pÃºblicos
//        else if( x > a.getValor() )
//            a.setDer( insertar( x, o, a.getDer()) );	// a.der = insertar(x, a.der); con los atributos pÃºblicos
//        return a;
//    }
    
    //sin repetir valores
//    private boolean insertarSinRepetir(int valor, Object o, NodoBB a){
//    	if(a == null) {
//    		a = new NodoBB(o,valor);
//    		return true;
//    	}
//    	else {
//    		if(raiz.getValor() > valor)
//    			return insertarSinRepetir(valor,o,a.getIzq());
//    		else if(raiz.getValor() < valor)
//    			return insertarSinRepetir(valor,o,a.getDer());
//    		else
//    			return false;
//    	}
//    }
    
    private NodoBB insertarSinRepetir(int valor, Object o, NodoBB a){
    	NodoBB n = new NodoBB();
    	if (a == null) {
    		n.setDato(o);
    		n.setValor(valor);
    		return n;
    	}
    	else {
    		if (raiz.getValor() > valor) {
    			n = insertarSinRepetir(valor,o,a.getIzq());
    			if (n.getObjeto() != null){
    				a.setIzq(n);
    				return a;
    			}
    			;
    		} else if(raiz.getValor() < valor) {
    			n = insertarSinRepetir(valor,o,a.getDer());
    			if (n.getObjeto() != null){
    				a.setDer(n);
    				return a;
    			}
    		}
    	}
    	return n;
    }
    
    public int altura(){
    	return Altura(raiz);
    }
    
    private int Altura (NodoBB a){
    	int Altder = (a.getDer() == null? 0:1 + Altura (a.getDer()));
    	int Altizq = (a.getIzq() == null? 0:1 + Altura (a.getIzq()));
    	return Math.max(Altder,Altizq);
    }
    
    public void eliminar(int a) {
    	
    	if (raiz == null)
    		return;
    	if (raiz.getValor() == a) {
    		if (raiz.getIzq() == null) {
    			raiz = raiz.getDer();
    		}else {
    			if (raiz.getDer() == null) {
    				raiz = raiz.getIzq();
    			}else {
    				ArbolBB der = this.subADer();
    				raiz = raiz.getIzq();
    				NodoBB max = maximo();
    				max.setDer(der.raiz);
    			}
    		}
    	}else {
    		if (raiz.getValor() > a) {
    			ArbolBB izq = this.subAIzq();
    			izq.eliminar(a);
    			raiz.setIzq(izq.raiz);
    		}else {
    			ArbolBB der = this.subADer();
    			der.eliminar(a);
    			raiz.setDer(der.raiz);
    		}
    	}
    }
    
    private ArbolBB subADer() {
    	ArbolBB subArbol = new ArbolBB();
    	subArbol.raiz = this.raiz.getDer();
    	return subArbol;
    };
    
    private ArbolBB subAIzq() {
    	ArbolBB subArbol = new ArbolBB();
    	subArbol.raiz = this.raiz.getIzq();
    	return subArbol;
    };
    
    private NodoBB maximo() {
    	if (raiz == null)
    		return null;
    	return maximo(raiz);
    };
    
    private NodoBB maximo(NodoBB a) {
    	if (a.getDer() == null) {
    		return a;
    	}else {
    		return maximo(a.getDer());
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
