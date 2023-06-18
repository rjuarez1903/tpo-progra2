package impl;

import tda.ColaPrioridadTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioSimple;

public class DiccionarioSimpleColaPrioridad implements DiccionarioSimple {

    private ColaPrioridadTDA colaPrioridad;

    // Inicializa el diccionario
    public void inicializarDiccionario() {
        colaPrioridad = new ColaPrioridadSt();
        colaPrioridad.inicializarColaPrioridad();
    }

    // Agrega un par clave-valor al diccionario
    public void agregar(int clave, int valor) {
        colaPrioridad.acolarPrioridad(valor, clave);
    }

    // Elimina un par clave-valor del diccionario
    public void eliminar(int clave) {
        ColaPrioridadTDA colaAuxiliar = new ColaPrioridadSt();
        colaAuxiliar.inicializarColaPrioridad();

        // Mueve los elementos de la cola original a una cola auxiliar, excepto aquellos con la clave a eliminar
        while (!colaPrioridad.colaVacia()) {
            int valor = colaPrioridad.primero();
            int claveActual = colaPrioridad.prioridad();
            colaPrioridad.desacolar();

            if (clave != claveActual) {
                colaAuxiliar.acolarPrioridad(valor, claveActual);
            }
        }

        colaPrioridad = colaAuxiliar; // La cola original ahora es la cola auxiliar
    }

    // Recupera el valor asociado a una clave en el diccionario
    public int recuperar(int clave) {
        ColaPrioridadTDA colaAuxiliar = new ColaPrioridadSt();
        colaAuxiliar.inicializarColaPrioridad();
        int valorRecuperado = 0;

        // Busca el elemento con la clave deseada y guarda su valor
        while (!colaPrioridad.colaVacia()) {
            int valor = colaPrioridad.primero();
            int claveActual = colaPrioridad.prioridad();
            colaPrioridad.desacolar();
            colaAuxiliar.acolarPrioridad(valor, claveActual);

            if (clave == claveActual) {
                valorRecuperado = valor;
            }
        }

        // Restaura la cola original a partir de la cola auxiliar
        while (!colaAuxiliar.colaVacia()) {
            int valor = colaAuxiliar.primero();
            int claveActual = colaAuxiliar.prioridad();
            colaAuxiliar.desacolar();
            colaPrioridad.acolarPrioridad(valor, claveActual);
        }

        return valorRecuperado;
    }

    // Devuelve un conjunto con las claves del diccionario
    public ConjuntoTDA claves() {
        ConjuntoTDA conjuntoClaves = new ConjuntoSt();
        conjuntoClaves.inicializarConjunto();

        ColaPrioridadTDA colaAuxiliar = new ColaPrioridadSt();
        colaAuxiliar.inicializarColaPrioridad();

        // Mueve los elementos de la cola original a una cola auxiliar y agrega las claves al conjunto
        while (!colaPrioridad.colaVacia()) {
            int valor = colaPrioridad.primero();
            int claveActual = colaPrioridad.prioridad();
            colaPrioridad.desacolar();
            colaAuxiliar.acolarPrioridad(valor, claveActual);
            conjuntoClaves.agregar(claveActual);
        }

        colaPrioridad = colaAuxiliar; // La cola original ahora es la cola auxiliar
        return conjuntoClaves;
    }
}
