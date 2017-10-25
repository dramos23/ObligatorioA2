package PaqueteLista;

public interface ILista extends Iterable{
	
	public void insertar(Object dato);
	
	public void borrar(Object dato);
	
	public boolean existe(Object dato);
	
	public Object recuperar(Object dato);
	
	public void destruir();
	
	public int largo();
	
	public Object recuperarUltimo();
	
	public void insertarUltimo(Object dato);
	
}