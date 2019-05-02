package grafo;

public class Arista {

	private int origen;
	private int destino;
	private int peso;
	
	public Arista(int o , int d , int p) {
		setOrigen(o);
		setDestino(d);
		setPeso(p);
	}

	public int getOrigen() {
		return origen;
	}

	public void setOrigen(int origen) {
		this.origen = origen;
	}

	public int getDestino() {
		return destino;
	}

	public void setDestino(int destino) {
		this.destino = destino;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	
	
}
