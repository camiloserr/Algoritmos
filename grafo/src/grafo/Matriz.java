package grafo;

import java.util.ArrayList;
import java.util.HashMap; // import the HashMap class


public class Matriz<T> extends Grafo<T> {

	private int mat[][];
	private HashMap<T ,Integer > vertices = new HashMap<T , Integer  > ();
	private int cuenta = 0 ;
	
	public void Grafo(int tam) {
		mat = new int[tam][tam];
		
		for(int i = 0 ; i < tam ; ++i) {
			for (int j = 0 ; j < tam ; ++j) {
				mat[i][j]=0;
			}
		}
		
	}
	
	public boolean addVertice( T v) {
		if(cuenta > mat[0].length) {
			return false;
		}
		if(vertices.containsValue(v) == false) {
			vertices.put(v, cuenta);
			cuenta++;
			return true;
		}
		return false;
	}


	public boolean addArista(T origen, T destino, int peso) {
		int a = vertices.get(origen);
		int b = vertices.get(destino);
		if(mat[a][b] !=0) {
			mat[a][b] = peso;
			return false;
		}
		else {
			mat[a][b] = peso;
					return true;
		}
	}

	
	public int[][] Floyd(){
		int tam = mat.length;
		int dist[] [] = mat;
		
		for (int k = 0; k < tam; k++) {    
            for (int i = 0; i < tam; i++){ 
               for (int j = 0; j < tam; j++){ 
                    if (dist[i][k] + dist[k][j] < dist[i][j]) 
                        dist[i][j] = dist[i][k] + dist[k][j]; 
                } 
            } 
        } 
		
		return dist;
	}

	
	
}

