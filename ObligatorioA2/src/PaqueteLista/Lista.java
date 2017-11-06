package PaqueteLista;



public class Lista implements ILista{
	private NodoLista inicio;
	
	public Lista(NodoLista inicio){
		this.inicio = inicio;
	}
	
	public Lista(){
		
	}

	public NodoLista getInicio(){
		return inicio;
	}
	
	@Override
//	public void insertar(Object dato) {
//		inicio = new NodoLista(dato, inicio);
//	}
	
	public void insertar(Object dato) {
		NodoLista nuevo = new NodoLista(dato);
		nuevo.setSig(inicio);
		this.inicio = nuevo;
	}


	@Override
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

	@Override
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

	@Override
	public Object recuperar(Object dato) {
		if(inicio == null)
			return null;
		if(inicio.getDato().equals(dato))
			return inicio.getDato();
		else {
			NodoLista aux = inicio;
			while(aux.getSig() != null) {
				if(aux.getDato().equals(dato))
					return aux.getDato();
				aux = aux.getSig();
			}
			return null;
		}
	}

	@Override
	public void destruir() {
		while(inicio != null)
			inicio = inicio.getSig();
	}

	@Override
	public int largo() {
		int largo = 0;
		NodoLista aux = inicio;
		while(aux != null){
			largo++;
			aux = aux.getSig();
		}
		return largo;
	}

	@Override
	public Object recuperarUltimo() {
		NodoLista aux = inicio;
		if (inicio != null) {
			while (aux.getSig() != null) {
				aux = aux.getSig();
			}
		}
		return aux;
	}

	@Override
	public void insertarUltimo(Object dato) {
		NodoLista aux = inicio;
		if (inicio != null) {
			while (aux.getSig() != null) {
				aux = aux.getSig();
			}
			aux.setSig(new NodoLista(dato, aux.getSig()));
		} else {
			inicio = new NodoLista(dato, inicio);
		}		
	}
	
	@Override
	public boolean esVacia() {
		return inicio == null;
	}
}
