package PaqueteArbolBB;



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
            System.out.print(a.getDato()+"   ");
            mostrarPreOrder(a.getIzq());
            mostrarPreOrder(a.getDer());
        }
    }

    public void mostrarInOrder(){
    	mostrarInOrder(this.raiz);
    }
    
    public void mostrarInOrder(NodoBB a){
        if (a!=null){
            mostrarInOrder(a.getIzq());
            System.out.print(a.getDato()+"  ");
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
            System.out.print(a.getDato()+"  ");
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

    public boolean existe(int e, NodoBB a) {
	   boolean existe;
        if(a == null)
			existe = false;
		else
        {
            if( e == a.getDato() )
				existe=true;
			else if( e < a.getDato() )
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
			if(n == nodo.getDato() ) {
				return nodo;
			} else if( n < nodo.getDato() ) {
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

    public void insertarElemento(int n, NodoBB nodo) {
		NodoBB nuevo = null;

        if (this.esArbolVacio())
            this.raiz = new NodoBB(n);

        else if( n < nodo.getDato())
        {   // n < dato => insertar en subarbol izq
            if(nodo.getIzq() == null)
            {
                nuevo = new NodoBB(n);
                nodo.setIzq(nuevo);
             }
             else
                 insertarElemento(n, nodo.getIzq());
        }
        else if( n > nodo.getDato())
        {   // n > dato => insertar en subarbol derecho
			if(nodo.getDer() == null)
            {
				nuevo = new NodoBB(n);
				nodo.setDer(nuevo);
			}
            else
				insertarElemento(n, nodo.getDer());
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
    
    public void insertar( int x ) {
        raiz = insertar( x, raiz );
    }
    
    private NodoBB insertar( int x, NodoBB a ) {
        if( a == null )
            a = new NodoBB( x );
        else if(x < a.getDato() )
            a.setIzq( insertar( x, a.getIzq()) ); // a.izq = insertar(x, a.izq); con los atributos públicos
        else if( x > a.getDato() )
            a.setDer( insertar( x, a.getDer()) );	// a.der = insertar(x, a.der); con los atributos públicos
        return a;
    }
    
    public int altura(){
    	int alt = Altura(raiz);
    	return alt;
    }
    
    public int Altura (NodoBB a){
    	int Altder = (a.getDer() == null? 0:1 + Altura (a.getDer()));
    	int Altizq = (a.getIzq() == null? 0:1 + Altura (a.getIzq()));
    	return Math.max(Altder,Altizq);
    }
    
    public void eliminar(int a) {
    	
    	if (raiz == null)
    		return;
    	if (raiz.getDato() == a) {
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
    		if (raiz.getDato() > a) {
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
}
