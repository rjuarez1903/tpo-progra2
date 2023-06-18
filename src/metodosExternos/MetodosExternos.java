package metodosExternos;

import impl.*;
import tda.*;


public class MetodosExternos {
	
	public static void imprimirConjunto(ConjuntoTDA conjunto) {
		while (!conjunto.conjuntoVacio()) {
			int valor = conjunto.elegir();
			System.out.println(valor);
			conjunto.sacar(valor);
		} 
	}
	
//	Ejercicio 4
	/**
	 * Calcula el porcentaje de números pares en una pila.
	 *
	 * @param pila La PilaTDA de la cual se calculará el porcentaje de números pares.
	 * @return El porcentaje de números pares en la pila, como un valor de tipo double.
	 * @precondiciones La pila no debe ser nula y debe estar inicializada.
	 * @postcondiciones La pila no se modifica.
	 * @costo El costo de este método el lineal.
	 */
	
	
	public static double porcentajeDePares(PilaTDA pila) {
	    PilaTDA pilaAux = new PilaSt(); // Pila auxiliar para realizar operaciones
	    pilaAux.inicializarPila();
	    double total = 0;
	    double pares = 0;
	    double resultado = 0;

	    while (!pila.pilaVacia()) {
	        if (pila.tope() % 2 == 0) 
	            pares++; // Incrementa el contador de números pares
	        total++; // Incrementa el contador total
	        pilaAux.apilar(pila.tope()); // Apila el elemento en la pila auxiliar
	        pila.desapilar(); // Desapila el elemento de la pila original
	    }

	    while (!pilaAux.pilaVacia()) {
	        pila.apilar(pilaAux.tope()); // Restaura la pila original apilando los elementos desde la pila auxiliar
	        pilaAux.desapilar(); // Desapila el elemento de la pila auxiliar
	    }

	    if (pares != 0) 
	        resultado = pares / total * 100; // Calcula el resultado como el porcentaje de números pares

	    return resultado; // Devuelve el resultado
	}

	
//	Ejercicio 5
	/**
	 * Obtiene un conjunto de elementos repetidos en una pila.
	 *
	 * @param pila La PilaTDA de la cual se obtendrán los elementos repetidos.
	 * @return Un ConjuntoTDA que contiene los elementos repetidos en la pila.
	 * @precondiciones La pila no debe ser nula y debe estar inicializada.
	 * @postcondiciones La pila no se modifica.
	 * @costo El costo de este método es lineal
	 */
	public static ConjuntoTDA conjuntoRepetidos(PilaTDA pila) {
	    PilaTDA pilaAux = new PilaSt(); 
	    ConjuntoTDA conjuntoAux = new ConjuntoSt();
	    ConjuntoTDA conjuntoRepetidos = new ConjuntoSt();
	    pilaAux.inicializarPila();
	    conjuntoAux.inicializarConjunto();
	    conjuntoRepetidos.inicializarConjunto();
	    

	    while (!pila.pilaVacia()) {
	        int elemento = pila.tope();
	       
	        if (conjuntoAux.pertenece(elemento)) 
	            conjuntoRepetidos.agregar(elemento);
	        else  
	        	conjuntoAux.agregar(elemento);

	        pilaAux.apilar(elemento); 
	        pila.desapilar(); 
	    }

	    
	    while (!pilaAux.pilaVacia()) {
	        pila.apilar(pilaAux.tope()); 
	        pilaAux.desapilar(); 
	    }

	    return conjuntoRepetidos; 
	}
	
//	Ejercicio 6
	/**
	 * Convierte una pila en un diccionario simple que cuenta la cantidad de apariciones de cada elemento.
	 *
	 * @param pila La PilaTDA que se convertirá en el diccionario.
	 * @return Un DiccionarioSimple que contiene los elementos de la pila y su cantidad de apariciones.
	 * @precondiciones La pila no debe ser nula y debe estar inicializada.
	 * @postcondiciones La pila y su contenido no se modifican.
	 * @costo El costo de este método depende del tamaño de la pila y del diccionario resultante.
	 */
	public static DiccionarioSimple pilaADiccionario(PilaTDA pila) {
		DiccionarioSimple diccionario = new DiccionarioSimpleSt();
		diccionario.inicializarDiccionario();
		while (!pila.pilaVacia()) {
			if (!diccionario.claves().pertenece(pila.tope())) {
				diccionario.agregar(pila.tope(), 1);
			} else {
				diccionario.agregar(pila.tope(), diccionario.recuperar(pila.tope()) + 1);
			}
			pila.desapilar();
		}
		return diccionario;
	}
	
//	Ejercicio 7
	/**
	 * Convierte un DiccionarioMultipleTDA a una ColaTDA sin elementos repetidos.
	 *
	 * @param diccionarioMultiple El DiccionarioMultipleTDA a convertir.
	 * @return Una ColaTDA que contiene todos los valores del DiccionarioMultipleTDA sin repeticiones.
	 * @precondiciones El DiccionarioMultipleTDA no debe ser nulo y debe estar inicializado.
	 * @postcondiciones El DiccionarioMultipleTDA y sus estructuras internas no se modifican.
	 * @costo El costo de este método depende del tamaño del DiccionarioMultipleTDA y de los conjuntos
	 *        y colas utilizados en las implementaciones de las estructuras.
	 */
	public static ColaTDA diccionarioMultipleAColaSinRepe(DiccionarioMultipleTDA diccionarioMultiple) {
		ConjuntoTDA conjunto = new ConjuntoSt();
		ColaTDA cola = new ColaSt();
		conjunto.inicializarConjunto();
		cola.inicializarCola();
		
		ConjuntoTDA claves = diccionarioMultiple.claves();
		while (!claves.conjuntoVacio()) {
			int clave = claves.elegir();
			ConjuntoTDA valores = diccionarioMultiple.recuperar(clave);
			while (!valores.conjuntoVacio()) {
				int valor = valores.elegir();
				conjunto.agregar(valor);
				valores.sacar(valor);
			}
			claves.sacar(clave);
		}
		
		while (!conjunto.conjuntoVacio()) {
			int valor = conjunto.elegir();
			cola.acolar(valor);
			conjunto.sacar(valor);
		}
		
		return cola;
	}
	
//	Ejercicio 8
	/**
	 * Calcula la suma de los elementos con un valor impar en un árbol binario de búsqueda.
	 *
	 * @param a el árbol binario de búsqueda del cual se desea obtener la suma de los elementos impares
	 * @return la suma de los elementos impares del árbol
	 * 
	 * @precondiciones El árbol `a` no debe ser nulo.
	 * @postcondiciones El árbol `a` no se ve modificado.
	 * @costo La complejidad de este método es O(n), donde n es el número total de elementos en el árbol.
	 */
	public static int sumaElementosImpares(ABBTDA a) {
	    if (a.arbolVacio()) {
	        return 0; // Árbol vacío, suma igual a 0
	    } else {
	        int suma = 0;
	        if (a.raiz() % 2 != 0) { // Valor impar, se suma
	            suma += a.raiz();
	        }
	        suma += sumaElementosImpares(a.hijoIzq()); // Suma elementos impares del subárbol izquierdo
	        suma += sumaElementosImpares(a.hijoDer()); // Suma elementos impares del subárbol derecho
	        return suma;
	    }
	}
	
//	Ejercicio 9
    /**
     * Calcula la cantidad de hojas con un valor par en un árbol binario de búsqueda.
     *
     * Este método cuenta la cantidad de hojas en un árbol binario de búsqueda que tienen un valor par.
     *
     * @param a El árbol binario de búsqueda.
     * @return La cantidad de hojas con un valor par en el árbol.
     * @pre El parámetro 'a' debe ser un árbol binario de búsqueda válido.
     * @post El árbol binario de búsqueda 'a' no se modifica.
     * @costo Tiempo: O(n), donde 'n' es el número de nodos en el árbol binario de búsqueda.
     */
	public static int cantidadHojasPares(ABBTDA a) {
	    if (a.arbolVacio()) {
	        return 0; // El árbol está vacío, no hay hojas
	    } else if (a.hijoIzq().arbolVacio() && a.hijoDer().arbolVacio()) {
	        // Nodo hoja, verifica si su valor es par
	        if (a.raiz() % 2 == 0) {
	            return 1;
	        } else {
	            return 0;
	        }
	    } else {
	        // Nodo interno, suma las hojas con valor par de los subárboles izquierdo y derecho
	        int cantIzq = cantidadHojasPares(a.hijoIzq());
	        int cantDer = cantidadHojasPares(a.hijoDer());

	        return cantIzq + cantDer;
	    }
	}
	
	public static void imprimirEnOrden(ABBTDA a) {
	    if (!a.arbolVacio()) {
	        imprimirEnOrden(a.hijoIzq());
	        System.out.print(a.raiz() + " ");
	        imprimirEnOrden(a.hijoDer());
	    }
	}




}
