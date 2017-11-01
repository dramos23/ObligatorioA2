package PaqueteGrafo;

import PaqueteLista.Lista;

public interface IGrafo {
	//Pre: v no pertenece al grafo. 
		// 0<v<=capacidad grafo
		//Post: Agrega el v�rtice v al grafo
		public int agregarVertice(Object v);
		
		//Pre: origen y destino son los �ndices de v�rtices ya ingresados en el grafo
		//Post: Agrega la arista origen-destino de peso "peso" en el grafo
		public void agregarArista(int origen, int destino, int peso);
		
		//Pre: El v�rtice v existe en el grafo
		//Post: Elimina el v�rtice y todas las aristas a las que pertenezca
		public boolean eliminarVertice(Object v);
		
		//Pre: La arista origen - destino existe en el grafo
		//Post: Elimina la arista origen - destino
		public void eliminarArista(Object a, Object b);

		//Pre: El v�rtice v existe en el grafo
		//Post: Retorna una lista con los v�rtices adyacentes de v.
		// Si v no tiene adyacentes retorna la lista vac�a
		public Lista verticesAdyacentes(Object v);
		
		//Pre:  a y b son v�rtices del grafo
		//Post: Retorna true sii los v�rtices a y b son adyacentes. 
		public boolean sonAdyacentes(Object x, Object y);

		//Post: Retorna true sii el v�rtice fue ingresado al grafo
		public boolean existeVertice(Object v);
		
		//Post: Retorna true sii el grafo esta vac�o
		public boolean esVacio();
		
}
