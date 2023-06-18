package impl;

import tda.PilaTDA;

public class PilaDyn implements PilaTDA {
	
	private class Nodo {
		int info;
		Nodo sig;
	}
	
	Nodo primero;
	

	@Override
	public void inicializarPila() { //C
		primero = new Nodo(); //C
	}

	@Override
	public void apilar(int x) { //C
		Nodo aux = new Nodo(); //C
		aux.info = x; //C
		aux.sig = primero; //C
		primero = aux; //C
	}

	@Override
	public void desapilar() { //C
		primero = primero.sig; //C
	}

	@Override
	public int tope() { //C
		return primero.info; //C
	}

	@Override
	public boolean pilaVacia() { //C
		return primero == null; //C
	}
	
}
