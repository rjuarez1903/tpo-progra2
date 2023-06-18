package tda;

public interface PilaTDA {

	void inicializarPila();
	
	// La pila debe estar inicializada
	void apilar(int x); 
	
	// La pila debe estar inicializada y no vacía
	void desapilar();
	
	// La pila debe estar inicializada y no vacía
	int tope();
	
	// La pila debe estar inicializada
	boolean pilaVacia();

}
