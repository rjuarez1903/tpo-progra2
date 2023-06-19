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
	
	public static void imprimirEnOrden(ABBTDA a) {
	    if (!a.arbolVacio()) {
	        imprimirEnOrden(a.hijoIzq());
	        System.out.print(a.raiz() + " ");
	        imprimirEnOrden(a.hijoDer());
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
	    PilaTDA pilaAux = new PilaSt(); 
	    pilaAux.inicializarPila();
	    double total = 0;
	    double pares = 0;
	    double resultado = 0;

	    while (!pila.pilaVacia()) {
	        if (pila.tope() % 2 == 0) 
	            pares++; 
	        total++; 
	        pilaAux.apilar(pila.tope()); 
	        pila.desapilar(); 
	    }

	    while (!pilaAux.pilaVacia()) {
	        pila.apilar(pilaAux.tope()); 
	        pilaAux.desapilar(); 
	    }

	    if (pares != 0) 
	        resultado = pares / total * 100;

	    return resultado; 
	}

	
//	Ejercicio 5
	/**
	 * Obtiene un conjunto de elementos repetidos en una pila.
	 *
	 * @param pila La PilaTDA de la cual se obtendrán los elementos repetidos.
	 * @return Un ConjuntoTDA que contiene los elementos repetidos en la pila.
	 * @precondiciones La pila no debe ser nula y debe estar inicializada.
	 * @postcondiciones La pila no se modifica.
	 * @costo El costo de este método es polinómico.
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
	 * @postcondiciones La pila no se modifica.
	 * @costo El costo es polinómico.
	 */
	public static DiccionarioSimple pilaADiccionario(PilaTDA pila) {
		PilaTDA pilaAux = new PilaSt();
		DiccionarioSimple diccionario = new DiccionarioSimpleSt();
		pilaAux.inicializarPila();
		diccionario.inicializarDiccionario();
		while (!pila.pilaVacia()) {
			if (!diccionario.claves().pertenece(pila.tope())) {
				diccionario.agregar(pila.tope(), 1);
			} else {
				diccionario.agregar(pila.tope(), diccionario.recuperar(pila.tope()) + 1);
			}
			pilaAux.apilar(pila.tope());
			pila.desapilar();
		}
		
	    while (!pilaAux.pilaVacia()) {
	        pila.apilar(pilaAux.tope()); 
	        pilaAux.desapilar(); 
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
	 * @postcondiciones El DiccionarioMultipleTDA y su estructura interna no se modifican.
	 * @costo El costo es polinómico.
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
//	TODO
	/**
	 * Calcula la suma de los elementos con un valor impar en un árbol binario de búsqueda.
	 *
	 * @param a el árbol binario de búsqueda del cual se desea obtener la suma de los elementos impares
	 * @return la suma de los elementos impares del árbol
	 * @precondiciones El árbol 'a' no debe ser nulo.
	 * @postcondiciones El árbol 'a' no se ve modificado.
	 * @costo
	 */
	public static int sumaElementosImpares(ABBTDA a) {
	    if (a.arbolVacio()) {
	        return 0;
	    } else {
	        int suma = 0;
	        if (a.raiz() % 2 != 0) 
	            suma += a.raiz();
	        suma += sumaElementosImpares(a.hijoIzq());
	        suma += sumaElementosImpares(a.hijoDer()); 
	        return suma;
	    }
	}
	
//	Ejercicio 9
//	TODO
    /**
     * Este método cuenta la cantidad de hojas en un árbol binario de búsqueda que tienen un valor par.
     * @param a El árbol binario de búsqueda.
     * @return La cantidad de hojas con un valor par en el árbol.
     * @pre El parámetro 'a' debe ser un árbol binario de búsqueda válido.
     * @post El árbol binario de búsqueda 'a' no se modifica.
     * @costo
     */
	public static int cantidadHojasPares(ABBTDA a) {
	    if (a.arbolVacio()) {
	        return 0; // El árbol está vacío, no hay hojas
	    } else if (a.hijoIzq().arbolVacio() && a.hijoDer().arbolVacio()) {
	        // Nodo hoja, verifica si su valor es par
	        if (a.raiz() % 2 == 0) 
	            return 1;
	         else 
	            return 0;
	    } else {
	        // Nodo interno, suma las hojas con valor par de los subárboles izquierdo y derecho
	        int cantIzq = cantidadHojasPares(a.hijoIzq());
	        int cantDer = cantidadHojasPares(a.hijoDer());

	        return cantIzq + cantDer;
	    }
	}
	
    public static ConjuntoTDA verticesPuente(GrafoTDA grafo, int origen, int destino) {
        ConjuntoTDA verticesPuente = new ConjuntoSt();
        verticesPuente.inicializarConjunto();

        ConjuntoTDA vertices = grafo.vertices();

        while (!vertices.conjuntoVacio()) {
            int vertice = vertices.elegir();
            vertices.sacar(vertice);

            if (vertice != origen && vertice != destino) {
                if (grafo.existeArista(origen, vertice) && grafo.existeArista(vertice, destino)) {
                    verticesPuente.agregar(vertice);
                }
            }
        }

        return verticesPuente;
    }
    
    public static int calcularGradoVertice(GrafoTDA grafo, int vertice) {
        int aristasSalientes = 0;
        int aristasEntrantes = 0;

        ConjuntoTDA vertices = grafo.vertices();
        while (!vertices.conjuntoVacio()) {
            int v = vertices.elegir();
            vertices.sacar(v);

            if (vertice != v && grafo.existeArista(vertice, v)) {
                aristasSalientes++;
            }

            if (vertice != v && grafo.existeArista(v, vertice)) {
                aristasEntrantes++;
            }
        }

        return aristasSalientes - aristasEntrantes;
    }

}
