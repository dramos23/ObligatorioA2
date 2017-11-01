package PaqueteGrafo;

import PaqueteDominio.Punto;
import PaqueteHash.Hash;
import PaqueteLista.Lista;
import PaqueteLista.NodoLista;

public class GrafoLista implements IGrafo{
	private int size; //actualmente
	private int cantNodos; //maximo
	private Lista[] listaAdyacencia;
	private Punto[] vertices;
	private Hash hash;
	
	//Crea el grafo vacio (sin nodos ni aristas) con capacidad de almacenamiento de n vértices
	public GrafoLista(int n){
		this.size = 0;
		this.cantNodos = n;
		this.hash = new Hash(n);
		this.listaAdyacencia = new Lista[hash.getTamanio()];
		for (int i = 0; i<hash.getTamanio(); i++)
			this.listaAdyacencia[i]= new Lista();		
		this.vertices = new Punto[hash.getTamanio()];
	}
	
	@Override
	public void agregarVertice(Object v) {
		//this.nodosUsados[v]=true;
		Punto p = (Punto)v;
		if(size + 1 != cantNodos) {
			int indiceInsertado = hash.Insertar(p);
			vertices[indiceInsertado] = p;
			this.size++;
		}
	}
	@Override
	public void agregarArista(int origen, int destino, int peso) {
		this.listaAdyacencia[origen].insertar(new Arista(destino,peso));		
	}
	@Override
	public void eliminarVertice(Object v) {
		Punto p = (Punto)v;
		//this.nodosUsados[v]=false;
		int indiceBorrado = hash.Borrar(p);
		if(indiceBorrado != -1) {
			vertices[indiceBorrado] = null;
			this.size --;
			
			//Borrar aristas que salen de v
			this.listaAdyacencia[indiceBorrado] = new Lista();
			//Borrar aristas que llegan a v
			for (int i = 0; i<hash.getTamanio(); i++)
				this.listaAdyacencia[i].borrar(indiceBorrado);	
		}	
	}
	@Override
	public void eliminarArista(int origen, int destino) {
		
	}
	@Override
	public Lista verticesAdyacentes(Object v) {
		Punto p = (Punto)v;
		//return listaAdyacencia[v];
		return null;
	}
	@Override
	public boolean sonAdyacentes(Object a, Object b) {
		//return a <= cantNodos && listaAdyacencia[a].existe(new Arista(b));
		return false;
	}
	@Override
	public boolean existeVertice(Object v) {
		//return v <= cantNodos && nodosUsados[v];
		return false;
	}
	@Override
	public boolean esVacio() {
		return size == 0;
	}
	
	public void caminoMinimo(int verticeInicial) {
		boolean[] visitados = new boolean[cantNodos];
		int[] costos = new int[cantNodos];
		int[] predecesores = new int[cantNodos];
		visitados[verticeInicial] = true;
		predecesores[verticeInicial] = -1;
		
		//para todos los vértices del gráfo
		for(int i = 0; i < cantNodos; i++) { 
			//i sea adyancente a verticeInicial
			if(sonAdyacentes(verticeInicial,i)){
				//obtengo peso de la arista.
				costos[i] = obtenerArista(verticeInicial,i).getPeso(); 
				predecesores[i] = verticeInicial;
			} else {
				costos[i] = Integer.MAX_VALUE;
			}
		}
		
		for(int j = 0; j < cantNodos; j++) {
			int w = buscarVerticeCostoMinimoSinVisitar(costos,visitados);
			//siempre voy a encontrar w. no es necesario revisar si encontré o no
			visitados[w] = true; //en el momento que se marca true es que obtuve el camino minimo desde verticeInicial a w. opcionalmente puedo frenar acá si estaba buscando el camino minimo de verticeInicial a un w.
			NodoLista n = listaAdyacencia[w].getInicio();
			while(n != null) {
				Arista a = (Arista)n.getDato();
				if(!visitados[a.getDestino()]) {
					costos[a.getDestino()] = Math.min(costos[a.getDestino()],costos[w] + a.getPeso());
					predecesores[a.getDestino()] = w;
				}
				n = n.getSig();
			}
		}
	}

	public int buscarVerticeCostoMinimoSinVisitar(int[] costos, boolean[] visitados) {
		int costoMinimo = Integer.MAX_VALUE;
		int retorno = -1;
		for(int i = 0; i < costos.length; i++){
			if(costos[i] <= costoMinimo && !visitados[i]) {
				costoMinimo = costos[i];
				retorno = i;
			}
		}
		return retorno;
	}
	
	public Arista obtenerArista(int origen, int destino) {
		return ((Arista)listaAdyacencia[origen].recuperar(destino));
	}
}
