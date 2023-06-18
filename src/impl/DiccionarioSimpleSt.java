package impl;

import tda.ConjuntoTDA;
import tda.DiccionarioSimple;

public class DiccionarioSimpleSt implements DiccionarioSimple {
	
	private class Estructura {
		int clave; 
		int valor;
	}
	
	Estructura[] arr;
	int indice;

	@Override
	public void inicializarDiccionario() { // Costo Constante
		arr = new Estructura[100];
		indice = 0;
	}

	@Override
	public void agregar(int clave, int valor) {
		int pos = clave2Indice(clave);
		if (pos == -1) { // No existe la clave
			arr[indice] = new Estructura();
			arr[indice].clave = clave;
			arr[indice].valor = valor;
			indice++;
		} else {
			arr[pos].valor = valor;
		}	
	}

	@Override
	public void eliminar(int clave) { // Costo Lineal
		int pos = clave2Indice(clave);
		if (pos != -1) {
			arr[pos] = arr[indice -1];
			indice--;
		}
	}

	@Override
	public int recuperar(int clave) {
		int pos = clave2Indice(clave);
		return arr[pos].valor;
	}

	@Override
	public ConjuntoTDA claves() {
		ConjuntoTDA claves = new ConjuntoSt();
		claves.inicializarConjunto();
		for (int i = 0; i < indice; i++) {
			claves.agregar(arr[i].clave);
		}
		return claves;
	}
	
	private int clave2Indice(int clave) { // Costo Lineal
		int pos = indice - 1;
		while (pos >= 0 && arr[pos].clave != clave) {
			pos--;
		}
		return pos;
	}

}


