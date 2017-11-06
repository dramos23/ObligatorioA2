package PaqueteGrafo;


import PaqueteDominio.Punto;
import PaqueteHash.Hash;
import PaqueteLista.Lista;
import PaqueteLista.NodoLista;

public class GrafoLista {
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
	
	//POST: Si retorna 1 es que ya hay registrados cantPuntos puntos
	//		Si retorna 2 es que ya existe un punto en esas coordenadas
	//		Si retorna 0 es que pudo insertarse el punto

	public int agregarVertice(Object v) {
		//this.nodosUsados[v]=true;
		if(!sePuedeInsertarPunto()){
			return 1;
		} else {
			Punto p = (Punto)v;
			int indiceInsertado = hash.Insertar(p);
			if(indiceInsertado != -1) {
				vertices[indiceInsertado] = p;
				this.size++;
				return 0;
			}
			return 2;
		}
	}

	//POST: Retorna 0 si se pudo agregar la arista
	//		Retorna 1 si no existe uno de los dos puntos
	//		Retorna 2 si ya existe la arista de ida o vuelta en el gráfo
	public int agregarArista(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int peso) {
		int origen = hash.Existe(coordXi,coordYi);
		int destino = hash.Existe(coordXf,coordYf);
		if(origen == -1 || destino == -1)
			return 1;
		Arista ida = new Arista(destino,peso);
		Arista vuelta = new Arista(origen,peso);
		if(listaAdyacencia[origen].existe(ida) || listaAdyacencia[destino].existe(vuelta))
			return 2;
		this.listaAdyacencia[origen].insertar(ida);
		this.listaAdyacencia[destino].insertar(vuelta);
		return 0;				
	}
	
	public boolean eliminarVertice(Double coordX, Double coordY) {
		
		int indiceBorrado = hash.Borrar(coordX,coordY);
		boolean retorno = false;
		if(indiceBorrado != -1) {
			vertices[indiceBorrado] = null;
			this.size --;
			
			//Borrar aristas que salen de v
			this.listaAdyacencia[indiceBorrado] = new Lista();
			//Borrar aristas que llegan a v
			Arista a = new Arista(indiceBorrado);
			for (int i = 0; i<hash.getTamanio(); i++)
				this.listaAdyacencia[i].borrar(a);
			
			retorno = true;
		}	
		return retorno;
	}
	
	//POST: Retorna 0 si pudo eliminar la arista
	//		Retorna 1 si no existe uno de los dos puntos
	//		Retorna 2 si no existe la arista de ida o vuelta en el gráfo
	public int eliminarArista(Double coordXi, Double coordYi, Double coordXf, Double coordYf) {
		int origen = hash.Existe(coordXi,coordYi);
		int destino = hash.Existe(coordXf,coordYf);
		if(origen == -1 || destino == -1)
			return 1;
		else {
			Arista ida = new Arista(destino);
			Arista vuelta = new Arista(origen);
			
			if(!listaAdyacencia[origen].existe(ida) || !listaAdyacencia[destino].existe(vuelta)) //la segunda condición no es necesaria?
				return 2;
			listaAdyacencia[origen].borrar(ida);
			listaAdyacencia[destino].borrar(vuelta);
			return 0;
		}
	}
	
	public Lista verticesAdyacentes(Object v) {
//		Punto p = (Punto)v;
//		ArrayList<Punto> misAdyacentes = new ArrayList<Punto>();
//		//return listaAdyacencia[v];
//		for(int i = 0; i < cantNodos; i++) { 
//			if(sonAdyacentes(v,i)){
//				//obtengo peso de la arista.
//				costos[i] = obtenerArista(verticeInicial,i).getPeso(); 
//				predecesores[i] = verticeInicial;
//			}
//		}
		return null;
	}
	
	public boolean sonAdyacentes(int a, int b) {
		if(!listaAdyacencia[a].esVacia()){
			Arista arista = new Arista(b);
			return listaAdyacencia[a].existe(arista);
		}
		return false;
	}
	
	//Retorna -1 si no está. 
	public int existeVertice(Object v) {
		Punto p = (Punto)v;
		return hash.Existe(p.getCoordX(), p.getCoordY());
	}
	
	public boolean esVacio() {
		return size == 0;
	}
	
	public int getSize(){
		return size;
	}
	
	public boolean sePuedeInsertarPunto(){
		return size < cantNodos;
	}
	
//	public void caminoMinimo(int verticeInicial) {
//		boolean[] visitados = new boolean[hash.getTamanio()]; //cantNodos
//		int[] costos = new int[hash.getTamanio()]; //cantNodos
//		int[] predecesores = new int[hash.getTamanio()]; //cantNodos
//		visitados[verticeInicial] = true;
//		predecesores[verticeInicial] = -1;
//		
//		//para todos los vértices del gráfo
//		for(int i = 0; i < hash.getTamanio(); i++) { 
//			//i sea adyancente a verticeInicial
//			if(sonAdyacentes(verticeInicial,i)){
//				//obtengo peso de la arista.
//				//costos[i] = obtenerArista(verticeInicial,i).getPeso();
//				NodoLista nodoArista = listaAdyacencia[i].getInicio();
//				Arista arista = (Arista)nodoArista.getDato();
//				costos[i] = arista.getPeso();
//				predecesores[i] = verticeInicial;
//			} else {
//				costos[i] = Integer.MAX_VALUE;
//			}
//		}
//		
//		for(int j = 0; j < cantNodos; j++) {
//			int w = buscarVerticeCostoMinimoSinVisitar(costos,visitados);
//			//siempre voy a encontrar w. no es necesario revisar si encontré o no
//			visitados[w] = true; //en el momento que se marca true es que obtuve el camino minimo desde verticeInicial a w. opcionalmente puedo frenar acá si estaba buscando el camino minimo de verticeInicial a un w.
//			NodoLista n = listaAdyacencia[w].getInicio();
//			while(n != null) {
//				Arista a = (Arista)n.getDato();
//				if(!visitados[a.getDestino()]) {
//					costos[a.getDestino()] = Math.min(costos[a.getDestino()],costos[w] + a.getPeso());
//					predecesores[a.getDestino()] = w;
//				}
//				n = n.getSig();
//			}
//		}
//	}
	
	public void caminoMinimo(int verticeInicial) {
		boolean[] visitados = new boolean[hash.getTamanio()]; //cantNodos
		int[] costos = new int[hash.getTamanio()]; //cantNodos
		int[] camino = new int[hash.getTamanio()]; //cantNodos
		visitados[verticeInicial] = true;
		camino[verticeInicial] = -1;
		
		//para todos los vértices del gráfo
		for(int i = 0; i < hash.getTamanio(); i++) { 
			//i sea adyancente a verticeInicial
			if(sonAdyacentes(verticeInicial,i)){ //problema en la adyacencia me indica que p1 es adyacente de p3, no!!! p1 es adyacente a c1 y c1 a p3
				//obtengo peso de la arista.
				//costos[i] = obtenerArista(verticeInicial,i).getPeso();
				NodoLista nodoArista = listaAdyacencia[i].getInicio(); //new line
				Arista arista = (Arista)nodoArista.getDato(); // new line
				costos[i] = arista.getPeso(); // new line
				camino[i] = verticeInicial;
			} else {
				costos[i] = Integer.MAX_VALUE;
			}
		}
		
		for(int j = 0; j < hash.getTamanio(); j++) {
			int w = buscarVerticeCostoMinimoSinVisitar(costos,visitados);
			//siempre voy a encontrar w. no es necesario revisar si encontré o no
			visitados[w] = true; //en el momento que se marca true es que obtuve el camino minimo desde verticeInicial a w. opcionalmente puedo frenar acá si estaba buscando el camino minimo de verticeInicial a un w.
			NodoLista n = listaAdyacencia[w].getInicio();
			if (n != null) {
				Arista a = (Arista)n.getDato();
				Punto p = (Punto)vertices[a.getDestino()];
				if (p.getTipoPunto() != "SILO") {
					while(n != null) {
						if(!visitados[a.getDestino()]) {
							costos[a.getDestino()] = Math.min(costos[a.getDestino()],costos[w] + a.getPeso());
							camino[a.getDestino()] = w;
						}
						n = n.getSig();
					}
				} else {
					costos[a.getDestino()] = Math.min(costos[a.getDestino()],costos[w] + a.getPeso());
					camino[a.getDestino()] = w;
				}
			}
		}
		costos.notify();
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
	
	public String obtenerUrlEstado() {
		String url = "";
		String rojo = "";
		String amarillo = "";
		String verde = "";
		String trayecto = "";
		if(size != 0) {
			url = "https://maps.googleapis.com/maps/api/staticmap?zoom=11&size=640x640&maptype=roadmap";
			for(int i = 0; i < vertices.length; i++) {
				if(vertices[i] != null) {
					String coordenadasOrigen = vertices[i].coordsToStr();
					String marker = "&markers=color:";
					String label = "%7Clabel:";
					switch(vertices[i].getTipoPunto().toString()) {
					case "CIUDAD":
						rojo += marker + "red" + label + "C%7C" + coordenadasOrigen;
						break;
					case "PLANTACIÓN":
						amarillo += marker + "yellow" + label + "P%7C" + coordenadasOrigen;
						break;
					case "SILO":
						verde += marker + "green" + label + "S%7C" + coordenadasOrigen;
						break;
					}
					
					
					if(!listaAdyacencia[i].esVacia()) {
						NodoLista nodoArista = listaAdyacencia[i].getInicio();
						while(nodoArista != null) {
							Arista a = (Arista)nodoArista.getDato();
							int indiceDestino = a.getDestino();
							String coordenadasDestino = vertices[indiceDestino].coordsToStr();
							trayecto += "&path=color:0xff0000ff|weight:2|" + coordenadasOrigen + "|" + coordenadasDestino;
							nodoArista = nodoArista.getSig();
						}
					}
				}
			}
		}
		url += rojo + amarillo + verde + trayecto + "&key=AIzaSyDuTm6HHsuZQBmCte-uLBf0XxMCfxvjuwE";
		return url;
	}
	
	public String rSilomasCercano(double coordX, double coordY) {
		int origen = hash.Existe(coordX,coordY);
		caminoMinimo(origen);
		return null;
	}
}
