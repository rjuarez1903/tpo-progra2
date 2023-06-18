package impl;

import tda.ColaTDA;

public class ColaSt implements ColaTDA {
	
	private int[] arr;
	private int indice;

	@Override
	public void inicializarCola() { //C
		arr = new int[100]; //C
		indice = 0; //C
	}

	@Override
	public void acolar(int x) {
		for (int i = indice; i > 0; i--) {
			arr[i] = arr[i -1];
		}
		arr[0] = x;
		indice++;
	}

	@Override
	public void desacolar() {
		indice--; //C
	}

	@Override
	public int primero() { //C
		return arr[indice - 1]; //C
	}

	@Override
	public boolean colaVacia() { //C
		return indice == 0; //C
	}

}
