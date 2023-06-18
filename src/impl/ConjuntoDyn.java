package impl;

import tda.ConjuntoTDA;

public class ConjuntoDyn implements ConjuntoTDA {
	
	private class Nodo {
		int info;
		Nodo sig;
	}
	
	Nodo c;

	@Override
	public void inicializarConjunto() { // Costo lineal
		c = null;

	}

	@Override
	public void agregar(int x) { // Costo lineal
		if (!this.pertenece(x)) {
			Nodo nuevo = new Nodo();
			nuevo.info = x;
			nuevo.sig = c;
			c = nuevo;
		}
	}

	@Override
	public void sacar(int x) { // Costo lineal
		if (c != null) {
			if (c.info == x) {
				c = c.sig;
			} else {
				Nodo aux = c;
				while (aux.sig != null && aux.sig.info != x) {
					aux = aux.sig;
				} 
				if (aux.sig != null) {
					aux.sig = aux.sig.sig;
				}
			}
		}
	}

	@Override
	public int elegir() { // Costo constante
		return c.info;
	}

	@Override
	public boolean conjuntoVacio() { // Costo constante
		return c == null;
	}

	@Override
	public boolean pertenece(int x) { // Costo lineal
		Nodo aux = c;
		while (aux != null && aux.info != x) {
			aux = aux.sig;
		}
		return aux != null;
	}

}
