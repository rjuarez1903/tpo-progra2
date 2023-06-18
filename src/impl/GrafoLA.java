package impl;

import tda.ConjuntoTDA;
import tda.GrafoTDA;

public class GrafoLA implements GrafoTDA {
	
	class NodoGrafo{ 
		int nodo;
		NodoArista arista;
		NodoGrafo sigNodo;
	}
	
	class NodoArista{ 
		int etiqueta;
		NodoGrafo nodoDestino;
		NodoArista sigArista; 
	}
	
	NodoGrafo origen;

	@Override
	public void inicializarGrafo() {
		origen = null;
		
	}

	@Override
	public void agregarVertice(int v) {
		//El vertice se inserta al inicio de la lista de nodos 
		NodoGrafo aux = new NodoGrafo();
		aux.nodo = v;
		aux.arista = null;
		aux.sigNodo = origen;
		origen = aux;
		
	}

	@Override
	public void eliminarVertice(int v) {
		//Se recorre la lista de ve ́rtices para remover el nodo v //y las aristas con este ve ́rtice.
		//Distingue el caso que sea el primer nodo
		if (origen.nodo == v) { 
			origen = origen.sigNodo;
		}
		NodoGrafo aux = origen; 
		while (aux != null) {
		//remueve de aux todas las aristas hacia v
			this.eliminarAristaNodo(aux, v);
			if (aux.sigNodo!=null && aux.sigNodo.nodo == v) { 
				//Si el siguiente nodo de aux es v, lo elimina 
				aux.sigNodo = aux.sigNodo.sigNodo;
			}
		aux = aux.sigNodo; 
		}
	}
	
	
	/*
	* Si en las aristas del nodo existe * una arista hacia v, la elimina
	*/
	private void eliminarAristaNodo(NodoGrafo nodo, int v) { 
		NodoArista aux = nodo.arista;
		if (aux!=null) {
			//Si la arista a eliminar es la primera en //la lista de nodos adyacentes
			if (aux.nodoDestino.nodo == v) { 
				nodo.arista = aux.sigArista;
			} else {
				while (aux.sigArista != null && aux.sigArista.nodoDestino.nodo != v) {
					aux = aux.sigArista; 
				}
				if (aux.sigArista!=null) {
					//Quita la referencia a la arista hacia v 
					aux.sigArista = aux.sigArista.sigArista;
				} 
			}
		}
	}

	@Override
	public ConjuntoTDA vertices() {
		ConjuntoTDA c = new ConjuntoSt(); 
		c.inicializarConjunto();
		NodoGrafo aux = origen;
		while (aux != null) { 
			c.agregar(aux.nodo);
			aux = aux.sigNodo;
		}
		return c; 
	}
	

	/*
	* Para agregar una nueva arista al grafo, primero se deben
	* buscar los nodos entre los cuales se va agregar la arista,
	* y luego se inserta sobre la lista de adyacentes del nodo
	* origen (en este caso nombrado como v1) 
	* */
	@Override
	public void agregarArista(int v1, int v2, int peso) {
		NodoGrafo n1 = vert2Nodo(v1);
		NodoGrafo n2 = vert2Nodo(v2);
		//La nueva arista se inserta al inicio de la lista //de nodos adyacentes del nodo origen
		NodoArista aux = new NodoArista();
		aux.etiqueta = peso;
		aux.nodoDestino = n2; aux.sigArista = n1.arista; n1.arista = aux;
	}
	
	private NodoGrafo vert2Nodo(int v) { 
		NodoGrafo aux = origen;
		while (aux!=null && aux.nodo!=v){
		aux = aux.sigNodo; }
		return aux; 
	}

	/*
	* Se elimina la arista que tiene como origen al vértice v1
	* y destino al vértice v2 
	*/
	@Override
	public void eliminarArista(int v1, int v2) {
		NodoGrafo n1 = vert2Nodo(v1); 
		eliminarAristaNodo(n1,v2);
		
	}

	@Override
	public boolean existeArista(int v1, int v2) {
		NodoGrafo n1 = vert2Nodo(v1);
		NodoArista aux = n1.arista;
		while (aux != null && aux.nodoDestino.nodo!=v2) {
			aux = aux.sigArista; 
		}
		//Solo si se encontro la arista buscada, aux no es null
		return aux != null;
	}

	@Override
	public int pesoArista(int v1, int v2) {
		NodoGrafo n1 = vert2Nodo(v1);
		NodoArista aux = n1.arista;
		while (aux.nodoDestino.nodo != v2) {
			aux = aux.sigArista; 
		}
		//Se encontró́ la arista entre los dos nodos
		return aux.etiqueta;
	}

}
