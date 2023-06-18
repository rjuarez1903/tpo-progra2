package tda;

public interface ABBTDA {
	// siempre que el árbol esté inicializado y no esté vacío
	int raiz();
	// siempre que el árbol esté inicializado y no esté vacío
	ABBTDA hijoIzq();
	// siempre que el árbol esté inicializado y no esté vacío
	ABBTDA hijoDer();
	// siempre que el árbol esté inicializado
	boolean arbolVacio();
	void inicializarArbol();
	// siempre que el árbol esté inicializado
	void agregarElem(int x);
	// siempre que el árbol esté inicializado
	void eliminarElem(int x);
}
