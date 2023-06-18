package tda;

public interface DiccionarioSimple {
	
	void inicializarDiccionario();
	
	// El diccionario debe estar inicializado
	void agregar(int cla, int val);
	
	// El diccionario debe estar inicializado
	void eliminar(int clave);
	
	// El diccionario está inicializado y la clave pertenece al mismo
	int recuperar(int clave);
	
	// El diccionario está inicializado
	ConjuntoTDA claves();
	
}
