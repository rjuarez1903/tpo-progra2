package tda;

public interface ConjuntoTDA {

	void inicializarConjunto();
	
	// El conjunto está inicializado
	void agregar(int x);
	
	// El conjunto está inicializado y no vacío
	int elegir();
	
	// El conjunto está inicializado
	void sacar(int x);
	
	// El conjunto está inicializado
	boolean pertenece(int x);
	
	// El conjunto está inicializado
	boolean conjuntoVacio();
	
}
