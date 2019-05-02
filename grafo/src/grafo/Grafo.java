package grafo;

public abstract class Grafo<T> {


	public abstract boolean addVertice(T v);
	public abstract boolean addArista(T origen , T destino , int peso);
}
