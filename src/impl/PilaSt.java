package impl;

import tda.PilaTDA;

public class PilaSt implements PilaTDA {
	
	private int[] arr;
	private int indice;

	@Override
	public void inicializarPila() { //C
		arr = new int[100]; //C
		indice = 0; //C
	}

	@Override
	public void apilar(int x) { //C
		arr[indice] = x; //C
		indice++; //C
	}

	@Override
	public void desapilar() { //C
		indice--; //C
	}

	@Override
	public int tope() { //C
		return arr[indice -1]; //C
	}

	@Override
	public boolean pilaVacia() { //C
		return indice == 0; //C 
	}
	
}
