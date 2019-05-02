package grafo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Lista<T> extends Grafo<T>{

	private ArrayList<T> vertices;
	private ArrayList< ArrayList < Arista> > lista = new ArrayList< ArrayList <Arista> >();
	private static int INF = 999999;
	
	public boolean addVertice(T v) {
		
		vertices.add(v);
		return true;
	}

	
	public boolean addArista(T origen, T destino, int peso) {
		
		int o = numVertice(origen);
		int d = numVertice(destino);
		Arista a = new Arista(o , d, peso);
		lista.get(o).add(a);
		return false;
	}
	
	private int numVertice(T v) {
		for(int i = 0 ; i < vertices.size() ; ++i) {
			if(vertices.get(i).equals(v)) {
				return i;
			}
			
		}
		return -1;
		
	}
	
	
	public void dfs(int ini) {
		Queue<Integer> cola = new LinkedList<>();
		cola.add(ini);
		boolean visitado[] = new boolean[lista.size()];
		for(int i = 0 ; i < lista.size() ; ++i){
			visitado[i]=false;;
		}
		int aux;
		visitado[ini] = true;
		while(!cola.isEmpty()) {
			
			aux = cola.peek();
			if(visitado[aux] == true) {
				continue;
			}
			visitado[aux] = true;
			System.out.println(aux);
			cola.remove();
			for(int i = 0 ; i<lista.get(aux).size() ; ++i) {
				int temp = lista.get(aux).get(i).getDestino();
				
				if(visitado[temp]==false) {
					
					cola.add(temp);
				}
			}
			
			
			
		}
	}
	
	public int[] dijkstra(T v) {
		int ini = numVertice(v);
		int res[] = new int[lista.size()];
		for(int i = 0 ; i<lista.size(); ++i) {
			res[i] =INF;
		}
		Heap pq = new Heap();

		for(int i = 0 ; i <lista.get(ini) .size(); ++i) {
			pq.push(lista.get(ini).get(i));
			res[lista.get(ini).get(i).getDestino()] = lista.get(ini).get(i).getPeso();
		}
		res[ini] = 0;
		Arista aux;
		while(!pq.empty()) {
			
			aux = pq.sacar();
			
			for(int i = 0 ; i<lista.get(aux.getDestino()).size() ; ++i) {
				Arista v1 = lista.get(aux.getDestino()).get(i);
				if( res[v1.getDestino()] > res[aux.getDestino()] + v1.getPeso()){
					res[v1.getDestino()] = res[aux.getDestino()] + v1.getPeso();
					Arista nueva = new Arista(0, v1.getDestino() , res[v1.getDestino()]);
					
				}
			}
			
			
		}
		
		
		return res;
		
		
	}
	

}
