package main;

import impl.*;

import aux.*;
import metodosExternos.MetodosExternos;
import tda.*;

public class Main {
	public static void main(String[] args) {
		
//		Data de testeo  
//	    PilaTDA pila = new PilaSt();
//	    pila.inicializarPila();
//	    pila.apilar(10);
//	    pila.apilar(10);
//	    pila.apilar(5);
//	    pila.apilar(20);
//	    pila.apilar(15);
//	    pila.apilar(15);
//	    
//	    PilaTDA pila2 = new PilaSt();
//	    pila2.inicializarPila();
//	    pila2.apilar(100);
//	    pila2.apilar(200);
//	    pila2.apilar(300);
		
//	    Ejercicio 1 Conjunto Especial
//      ConjuntoEspecialTDA conjunto = new ConjuntoEspecial();
//      conjunto.inicializarConjunto();
//
//      Respuesta respuesta1 = conjunto.agregar(5);
//      Respuesta respuesta2 = conjunto.agregar(10);
//      Respuesta respuesta3 = conjunto.sacar(8);
//      Respuesta respuesta4 = conjunto.sacar(5);
//      Respuesta respuesta5 = conjunto.elegir();
//      boolean pertenece = conjunto.pertenece(10);
//      boolean conjuntoVacio = conjunto.conjuntoVacio();
//
//      System.out.println(respuesta1.error);
//      System.out.println(respuesta2.error);
//      System.out.println(respuesta3.error);
//      System.out.println(respuesta4.error);
//      System.out.println(respuesta5.error);
//      System.out.println(pertenece);
//      System.out.println(conjuntoVacio);
//      System.out.println(respuesta5.rta);
//
//	    Ejercicio 2 Multipila
		
//	    MultiPilaTDA multipila = new MultiPila();
//	    multipila.inicializarPila();
//	    multipila.apilar(pila);
//	    multipila.apilar(pila2);
	    	    
//	    PilaTDA pilaResultado = multipila.tope(2);
//	    while (!pilaResultado.pilaVacia()) {
//	        System.out.println(pilaResultado.tope());
//	        pilaResultado.desapilar();
//	    }
//	    
//	    System.out.println(multipila.pilaVacia());
		
//	    Ejercicio 3 Diccionario Simple Cola Prioridad
//	    Diccionario Simple Cola Prioridad
	    
//        DiccionarioSimpleColaPrioridad diccionario = new DiccionarioSimpleColaPrioridad();
//        diccionario.inicializarDiccionario();
//
//        diccionario.agregar(1, 10);
//        diccionario.agregar(2, 20);
//        diccionario.agregar(3, 30);
//        diccionario.agregar(4, 40);
//
//        int valorRecuperado = diccionario.recuperar(2);
//        System.out.println("Valor asociado a la clave 2: " + valorRecuperado);
//
//        diccionario.eliminar(3);
//
//        ConjuntoTDA claves = diccionario.claves();
//        System.out.println("Claves en el diccionario:");
//        while (!claves.conjuntoVacio()) {
//            int clave = claves.elegir();
//            System.out.println("Clave: " + clave);
//            claves.sacar(clave);
//        }
		    
//	    Ejercicio 4
//	    System.out.println(metodosExternos.MetodosExternos.porcentajeDePares(pila));
	    
//	    Ejercicio 5
//	    ConjuntoTDA conjuntoRepe = metodosExternos.MetodosExternos.conjuntoRepetidos(pila);
//	    metodosExternos.MetodosExternos.imprimirConjunto(conjuntoRepe);
	    
//	    Ejercicio 6
//	    DiccionarioSimple diccionario = metodosExternos.MetodosExternos.pilaADiccionario(pila);
//	    System.out.println(diccionario.recuperar(10));
//	    System.out.println(diccionario.recuperar(5));
//	    System.out.println(diccionario.recuperar(20));
//	    System.out.println(diccionario.recuperar(15));
		
		
//		Ejercicio 7
//		DiccionarioMultipleTDA diccionarioMultiple = new DiccionarioMultipleSt();
//		diccionarioMultiple.inicializarDiccionario();
//
//		diccionarioMultiple.agregar(1, 10);
//		diccionarioMultiple.agregar(1, 20);
//		diccionarioMultiple.agregar(2, 20);
//		diccionarioMultiple.agregar(3, 20);
//		diccionarioMultiple.agregar(1, 10);
//		diccionarioMultiple.agregar(3, 50);
//
//		ColaTDA cola = metodosExternos.MetodosExternos.diccionarioMultipleAColaSinRepe(diccionarioMultiple);
//
//		while (!cola.colaVacia()) {
//		    System.out.println(cola.primero());
//		    cola.desacolar();
//		}
//	    Ejercicio 8
	    
//	    ABBTDA arbol = new ABB();
//	    arbol.inicializarArbol();
	    
//	    Agregar elementos al árbol
//	    arbol.agregarElem(5);
//	    arbol.agregarElem(3);
//	    arbol.agregarElem(8);
//	    arbol.agregarElem(2);
//	    arbol.agregarElem(6);
//	    arbol.agregarElem(10);
//	    arbol.agregarElem(7);
	    
	    // Calcular la suma de los elementos impares
//	    int sumaImpares = metodosExternos.MetodosExternos.sumaElementosImpares(arbol);
//	    
//	    System.out.println("La suma de los elementos impares es: " + sumaImpares);
	    
//	    Ejercicio 9
//	    ABBTDA arbol = new ABB();
//	    arbol.inicializarArbol();
//	    arbol.agregarElem(20);
//	    arbol.agregarElem(10);
//	    arbol.agregarElem(30);
//	    arbol.agregarElem(5);
//	    arbol.agregarElem(15);
//	    arbol.agregarElem(25);
//	    arbol.agregarElem(35);
//	    arbol.agregarElem(2);
//	    arbol.agregarElem(4);
//	    arbol.agregarElem(6);
//	    arbol.agregarElem(8);
//	    arbol.agregarElem(22);
//	    arbol.agregarElem(24);
//	    arbol.agregarElem(26);
//	    arbol.agregarElem(28);
//
//	    // Imprimir el árbol en orden
//	    System.out.println("Árbol en orden:");
//	    metodosExternos.MetodosExternos.imprimirEnOrden(arbol);
//
//	    // Calcular la cantidad de hojas con valor par
//	    int hojasPares = metodosExternos.MetodosExternos.cantidadHojasPares(arbol);
//	    System.out.println("Cantidad de hojas con valor par: " + hojasPares);
	    
//	    Ejercicio 10
	    GrafoMA grafo = new GrafoMA();
        grafo.inicializarGrafo();

        // Agregar vértices
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);

        // Agregar aristas
        grafo.agregarArista(1, 2, 1);
        grafo.agregarArista(1, 3, 1);
        grafo.agregarArista(2, 4, 1);
        grafo.agregarArista(3, 4, 1);
        grafo.agregarArista(4, 5, 1);

        // Origen y destino
        int origen = 1;
        int destino = 4;

        // Obtener vértices puente
        ConjuntoTDA verticesPuente = metodosExternos.MetodosExternos.verticesPuente(grafo, origen, destino);

        // Imprimir vértices puente
        System.out.println("Vértices puente entre " + origen + " y " + destino + ": ");
        while (!verticesPuente.conjuntoVacio()) {
            int vertice = verticesPuente.elegir();
            verticesPuente.sacar(vertice);
            System.out.print(vertice + " ");
        }
        
//        Ejercicio 11
        
        GrafoTDA grafo2 = new GrafoLA();
        grafo2.inicializarGrafo();
        grafo2.agregarVertice(1);
        grafo2.agregarVertice(2);
        grafo2.agregarVertice(3);
        grafo2.agregarVertice(4);
        grafo2.agregarVertice(5);
        grafo2.agregarVertice(6);
        grafo2.agregarArista(4, 2, 0); // Arista de 1 a 2
        grafo2.agregarArista(4, 3, 0); // Arista de 1 a 3
        grafo2.agregarArista(4, 1, 0); // Arista de 2 a 4
        grafo2.agregarArista(3, 6, 0); // Arista de 3 a 4
        grafo2.agregarArista(4, 5, 0); // Arista de 4 a 5

        // Calcular el grado del vértice 4
        int gradoVertice4 = metodosExternos.MetodosExternos.calcularGradoVertice(grafo2, 4);
        System.out.println("Grado del vértice 4: " + gradoVertice4); // Salida esperada: 2
	}

}
