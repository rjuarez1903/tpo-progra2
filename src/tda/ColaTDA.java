package tda;

public interface ColaTDA {
	
	void inicializarCola();
	
	// La cola debe estar inicializada
	void acolar(int x);
	
	// La cola debe estar inicializada y no vacía
	void desacolar();
	
	// La cola debe estar incializada y no vacía
	int primero();
	
	//La cola debe estar incializada
	boolean colaVacia();

}
