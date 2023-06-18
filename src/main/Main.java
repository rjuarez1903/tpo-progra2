package main;

import impl.*;

import aux.*;
import metodosExternos.MetodosExternos;
import tda.*;

public class Main {
	public static void main(String[] args) {
	    PilaTDA pila = new PilaSt();
	    pila.inicializarPila();
	    pila.apilar(10);
	    pila.apilar(10);
	    pila.apilar(5);
	    pila.apilar(20);
	    pila.apilar(15);
	    pila.apilar(15);
	    
	    PilaTDA pila2 = new PilaSt();
	    pila2.inicializarPila();
	    pila2.apilar(100);
	    pila2.apilar(200);
	    pila2.apilar(300);
	    
//	    Ejercicio 4
//	    System.out.println(MetodosPila.porcentajeDePares(pila));
	    ConjuntoTDA conjuntoRepe = metodosExternos.MetodosExternos.conjuntoRepetidos(pila);
	    metodosExternos.MetodosExternos.imprimirConjunto(conjuntoRepe);
	    
//	    Ejercicio 5
//	    
//	    DiccionarioSimple diccionario = MetodosExternos.pilaADiccionario(pila);
//	    System.out.println(diccionario.recuperar(10));
//	    System.out.println(diccionario.recuperar(5));
//	    System.out.println(diccionario.recuperar(20));
//	    System.out.println(diccionario.recuperar(15));
	    
//	    MultiPilaTDA multipila = new MultiPila();
//	    multipila.inicializarPila();
//	    multipila.apilar(pila);
//	    multipila.apilar(pila2);
	    
//	    Conjunto Especial
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
//	    Multipila	    
//	    PilaTDA pilaResultado = multipila.tope(2);
//	    while (!pilaResultado.pilaVacia()) {
//	        System.out.println(pilaResultado.tope());
//	        pilaResultado.desapilar();
//	    }
//	    
//	    System.out.println(multipila.pilaVacia());
	    
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
	    
//	    Ejercicio 8
	    
//	    ABBTDA arbol = new ABB();
//	    arbol.inicializarArbol();
	    
	    // Agregar elementos al árbol
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
	}

}
