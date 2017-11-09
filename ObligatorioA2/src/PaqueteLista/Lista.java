package PaqueteLista;



public class Lista {
	private NodoLista inicio;
	
	public Lista(NodoLista inicio){
		this.inicio = inicio;
	}
	
	public Lista(){
		
	}

	public NodoLista getInicio(){
		return inicio;
	}
	
	public void insertar(Object dato) {
		NodoLista nuevo = new NodoLista(dato);
		if(inicio != null)
			nuevo.setSig(inicio);
		this.inicio = nuevo;
	}

	public void borrar(Object dato) {
		if(inicio == null)
			return;
		if(inicio.getDato().equals(dato))
			inicio = inicio.getSig();
		else
		{
			NodoLista aux = inicio;
			while(aux.getSig() != null) {
				if(aux.getSig().getDato().equals(dato)) {
					aux.setSig(aux.getSig().getSig());
					return;
				}
				aux = aux.getSig();
			}
		}
	}

	public boolean existe(Object dato) {
		NodoLista aux = inicio;
		while(aux!=null)
		{
			if(aux.getDato().equals(dato))
				return true;
			else
				aux = aux.getSig();
		}
		return false;
	}

	public Object recuperar(Object dato) {
		if(inicio == null)
			return null;
		if(inicio.getDato().equals(dato))
			return inicio.getDato();
		else {
			NodoLista aux = inicio;
			while(aux.getSig() != null && !aux.getDato().equals(dato)) {
				aux = aux.getSig();
			}
			if(aux.getDato().equals(dato))
				return dato;
			return null;
		}
	}

	public void destruir() {
		while(inicio != null)
			inicio = inicio.getSig();
	}

	public boolean esVacia() {
		return inicio == null;
	}
}
