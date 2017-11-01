package PaqueteGrafo;

import PaqueteLista.Lista;

public interface IGrafo {
	//Pre: v no pertenece al grafo. 
		// 0<v<=capacidad grafo
		//Post: Agrega el vértice v al grafo
		public int agregarVertice(Object v);
		
		//Pre: origen y destino son los índices de vértices ya ingresados en el grafo
		//Post: Agrega la arista origen-destino de peso "peso" en el grafo
		public void agregarArista(int origen, int destino, int peso);
		
		//Pre: El vértice v existe en el grafo
		//Post: Elimina el vértice y todas las aristas a las que pertenezca
		public boolean eliminarVertice(Object v);
		
		//Pre: La arista origen - destino existe en el grafo
		//Post: Elimina la arista origen - destino
		public void eliminarArista(Object a, Object b);

		//Pre: El vértice v existe en el grafo
		//Post: Retorna una lista con los vértices adyacentes de v.
		// Si v no tiene adyacentes retorna la lista vacía
		public Lista verticesAdyacentes(Object v);
		
		//Pre:  a y b son vértices del grafo
		//Post: Retorna true sii los vértices a y b son adyacentes. 
		public boolean sonAdyacentes(Object x, Object y);

		//Post: Retorna true sii el vértice fue ingresado al grafo
		public boolean existeVertice(Object v);
		
		//Post: Retorna true sii el grafo esta vacío
		public boolean esVacio();
		
}
