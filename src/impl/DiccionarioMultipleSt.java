package impl;

import tda.ConjuntoTDA;
import tda.DiccionarioMultipleTDA;

public class DiccionarioMultipleSt implements DiccionarioMultipleTDA {

	private class Estructura {
		int clave;
		int[] valores;
		int cantValores;
	}
	
	Estructura[] elementos;
	int cantClaves;
	
	@Override
	public void inicializarDiccionario() {
		elementos = new Estructura[100];
		cantClaves = 0;
		
	}

	@Override
	public void agregar(int cla, int val) {
		int posC = clave2Indice(cla);
		if (posC == -1) {
			posC = cantClaves;
			elementos[posC] = new Estructura();
			elementos[posC].clave = cla;
			elementos[posC].cantValores = 0;
			elementos[posC].valores = new int[100];
			cantClaves++;
		}
		Estructura e = elementos[posC];
		int posV = valor2Indice(e, val);
		if (posV == -1) { // el valor no existe
			e.valores[e.cantValores] = val;
			e.cantValores++;
		}
		
	}
	
//	private int clave2Indice(int cla) {
//		int i = cantClaves -1;
//		while (i >= 0 &&  elementos[i].clave != cla)
//			i--;
//		return i;
//	}
	
	private int clave2Indice(int cl) {
		int pos = cantClaves - 1;
		while (pos >= 0 && elementos[pos].clave != cl) {
			pos--;
		}
		if (pos == -1) {
			return -1; // La clave no existe
		} else {
			return pos;
		}
	}

	@Override
	public void eliminar(int cla) {
		int pos = clave2Indice(cla);
		if (pos != -1) {
			elementos[pos] = elementos[cantClaves -1];
			cantClaves--;
		}
		
	}

	@Override
	public void eliminarValor(int cla, int val) {
		int posC = clave2Indice(cla);
		if (posC != -1) {
			Estructura e = elementos[posC];
			int posV = valor2Indice(e, val);
			if (posV != -1) {
				e.valores[posV] = e.valores[e.cantValores -1];
				e.cantValores--;
				if (e.cantValores == 0) {
					eliminar(cla);
				}
			}
		}	
	}
	
	private int valor2Indice(Estructura e, int val) {
		int i = e.cantValores -1;
		while (i >= 0 && e.valores[i] != val)
			i--;
		return i;
	}

	@Override
	public ConjuntoTDA recuperar(int cla) {
		ConjuntoTDA c = new ConjuntoSt();
		c.inicializarConjunto();
		int pos = clave2Indice(cla);
		if (pos != -1) {
			Estructura e = elementos[pos];
			for (int i = 0; i < e.cantValores; i++) {
				c.agregar(e.valores[i]);
			}
		}
		return c;
	}

	@Override
	public ConjuntoTDA claves() {
		ConjuntoTDA claves = new ConjuntoSt();
		claves.inicializarConjunto();
		for (int i = 0; i < cantClaves; i++) {
			claves.agregar(elementos[i].clave);
		}
		return claves;
	}
	
}
