package impl;

import tda.ColaPrioridadTDA;

public class ColaPrioridadDyn implements ColaPrioridadTDA {
	
	private class NodoPrioridad {
		public int info;
		public int prioridad;
		public NodoPrioridad sig;
	}
	
	NodoPrioridad mayorPrioridad;
	int suma;
	
	@Override
	public void inicializarColaPrioridad() {
		mayorPrioridad = null;
		suma = 0;
	}
	@Override
	public void acolarPrioridad(int valo, int prior) {
		suma += prior;
		// Creo el nuevo nodo que voy a acolar
		NodoPrioridad nuevo = new NodoPrioridad();
		nuevo.info = valo;
		nuevo.prioridad = prior;
		
		// Si la cola está vacía o bien es más prioritario que el primero, hay que agregarlo al principio
		if (mayorPrioridad == null || prior > mayorPrioridad.prioridad) {
			nuevo.sig = mayorPrioridad;
			mayorPrioridad = nuevo;
		} else {
			// Sabemos que mayorPrioridad no es null
			NodoPrioridad aux = mayorPrioridad; 
			while (aux.sig != null && aux.sig.prioridad >= prior) {
				aux = aux.sig;
				nuevo.sig = aux.sig;
				aux.sig = nuevo;
			}
		}
	}
	
	@Override
	public void desacolar() {
		suma -= mayorPrioridad.prioridad;
		mayorPrioridad = mayorPrioridad.sig;
	}
	
	@Override
	public boolean colaVacia() {
		return mayorPrioridad == null;
	}
	
	@Override
	public int primero() {
		return mayorPrioridad.info;
	}
	
	@Override
	public int prioridad() {
		return mayorPrioridad.prioridad;
	}
	@Override
	public int sumaPrioridades() {
		return suma;
	} 
	
}
