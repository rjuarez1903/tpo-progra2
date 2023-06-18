package impl;

import tda.ColaTDA;

public class ColaDyn implements ColaTDA {
	
	private class Nodo {
		int info;
		Nodo sig;
	}
	
	Nodo primero;
	Nodo ultimo;
 
	@Override
	public void inicializarCola() {
		primero = null;
		ultimo = null;
	}

	@Override
	public void acolar(int x) {
		Nodo aux = new Nodo();
		aux.info = x;
		aux.sig = null;
		
		//Si la cola no está vacía
		if (ultimo != null)
			ultimo.sig = aux;
		ultimo = aux;
		
		//Si la cola estaba vacía
		if (primero == null)
			primero = ultimo;
	}

	@Override
	public void desacolar() {
		primero = primero.sig;
		
		if (primero == null)
			ultimo = null;		
	}

	@Override
	public int primero() {
		return primero.info;
	}

	@Override
	public boolean colaVacia() {
		return ultimo == null;
	}
	
}
