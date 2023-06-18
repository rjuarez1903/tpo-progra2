package impl;

import tda.ColaPrioridadTDA;

public class ColaPrioridadSt implements ColaPrioridadTDA {
	
	private class Estructura {
		int valor;
		int prioridad;
	}
	private Estructura[] arr;
	private int indice;
	private int suma;
	

	@Override
	public void inicializarColaPrioridad() {
		arr = new Estructura[100];
		indice = 0;
		suma = 0;
	}

	@Override
	public void acolarPrioridad(int val, int prio) {
		int i = indice;
		while (i > 0 && prio <= arr[i - 1].prioridad) {
			arr[i] = new Estructura();
			arr[i].valor = arr[i - 1].valor;
			arr[i].prioridad = arr[i - 1].prioridad;
			i--;
		}
		arr[i] = new Estructura();
		arr[i].valor = val;
		arr[i].prioridad = prio;
		indice++;
		suma += prio;
	}
	
	@Override
	public void desacolar() {
		suma -= arr[indice -1].prioridad;
		arr[indice - 1] = null;
		indice--;
	}

	@Override
	public int primero() {
		return arr[indice - 1].valor;
	}

	@Override
	public int prioridad() {
		return arr[indice -1].prioridad;
	}

	@Override
	public boolean colaVacia() {
		return indice == 0;
	}

	@Override
	public int sumaPrioridades() {
		return suma;
	}
	
}
