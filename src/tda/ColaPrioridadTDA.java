package tda;

public interface ColaPrioridadTDA {

	void inicializarColaPrioridad();

	// cola inicializada
	void acolarPrioridad(int valor, int prioridad);
	
	//cola inicializada y no vacía
	void desacolar();
	
	//cola incializada y no vacía
	int primero();
	
	//cola inicializada y no vacía
	int prioridad();
	
	//cola inicializada
	boolean colaVacia();
	
	//inicializada
	int sumaPrioridades();
	
}
