package grafo;

import java.util.ArrayList;

public class Heap {

	private ArrayList<Arista> a;
	
	//papa x -> a[(x-1)/2
	//hijos de a[n] -> a[(2*n)+1] y a[(2*n)+2] 
	public Heap() {
		
	}
	
	private int papa(int i) {
		return (i-1)/2;
	}
	
	private int hijo1(int i) {
		return (2*i)+1;
	}
	
	private int hijo2(int i) {
		return hijo1(i)+1;
	}
	
	private boolean cumple(int i) {
		if(a.get(papa(i)).getPeso() > a.get(i).getPeso()) {
			return false;
		}
		return true;
	}
	
	private void subir(int i) {
		Arista aux = a.get(i);
		a.set(i, a.get(papa(i)));
		a.set(papa(i), aux);
		
	}
	
	public void push(Arista x) {
		a.set(a.size() ,x);
		int  i = a.size();
		while(!cumple(i)) {
			subir(i);
		}
	}
	
	public Arista sacar() {
		Arista res = a.get(0);
		a.set(0, a.get( a.size()-1 ) );
		
		int i = 0;
		while(a.get(i).getPeso() > a.get(hijo1(i)).getPeso() || a.get(i).getPeso() > a.get(hijo2(i)).getPeso() ) {
			if(a.get(hijo1(i)).getPeso()  < a.get(hijo2(i)).getPeso() ) {
				subir(hijo1(i));
				i = hijo1(i);
			}
			else {
				subir(hijo2(i));
				i = hijo2(i);
			}
		}
		
		
		return res;
	}
	
	public boolean empty() {
		
		if(a.size() > 0) {
			return false;
			
		}
		return true;
	}
	
}
