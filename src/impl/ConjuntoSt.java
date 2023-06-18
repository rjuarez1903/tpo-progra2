package impl;

import tda.ConjuntoTDA;

public class ConjuntoSt implements ConjuntoTDA {

	int[] arr;
	int indice;
	
	@Override
	public void inicializarConjunto() {
		arr = new int[100];
		indice = 0;
	}

	@Override
	public void agregar(int x) {
		if (!this.pertenece(x)) {
			arr[indice] = x;
			indice++;
		}
	}

	@Override
	public void sacar(int x) {
		if (pertenece(x)) {
			for (int i = indice -1; i >= 0; i--) {
				if (arr[i] == x) {
					arr[i] = arr[indice - 1];
					indice--;
				} 
			}
		}
		
	}

	@Override
	public int elegir() {
		return arr[indice -1];
	}

	@Override
	public boolean conjuntoVacio() {
		return indice == 0;
	}

	@Override
	public boolean pertenece(int x) {
		boolean pertenece = false;
		for (int i = 0; i < indice; i++) {
			if (arr[i] == x) {
				pertenece = true;
			}
		}
		return pertenece;
	}
		
}