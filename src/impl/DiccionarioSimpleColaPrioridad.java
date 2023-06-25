package impl;

import tda.ColaPrioridadTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioSimple;

public class DiccionarioSimpleColaPrioridad implements DiccionarioSimple {

    private ColaPrioridadTDA colaPrioridad;
    
    
    /**
     * @tarea Inicializa el diccionario.
     * @parámetros -
     * @precondiciones -
     * @postcondiciones El diccionario queda inicializado y listo para su uso.
     * @costo El costo es constante.
     */
    // Inicializa el diccionario
    public void inicializarDiccionario() {
        colaPrioridad = new ColaPrioridadSt();
        colaPrioridad.inicializarColaPrioridad();
    }

    /**
     * @tarea Agrega un par clave-valor al diccionario.
     * @parámetros 
     * 		clave La clave del par a agregar.
     * 		valor El valor asociado a la clave.
     * @precondiciones El diccionario debe estar inicializado.
     * @postcondiciones El par clave-valor queda agregado al diccionario.
     * @costo El costo es lineal.
     */
    // Agrega un par clave-valor al diccionario
    public void agregar(int clave, int valor) {
        colaPrioridad.acolarPrioridad(valor, clave);
    }
    
    
    /**
     * @tarea Elimina un par clave-valor del diccionario.
     * @parámetros clave La clave del par a eliminar.
     * @precondiciones El diccionario debe estar inicializado.
     * @postcondiciones El par clave-valor con la clave especificada queda eliminado del diccionario.
     * @costo El costo es lineal, dependiendo del número de elementos en el diccionario.
     */
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
    
    
    /**
     * @tarea Recupera el valor asociado a una clave en el diccionario.
     * @parámetros clave La clave del par cuyo valor se desea recuperar.
     * @precondiciones El diccionario debe estar inicializado y la clave deben pertenece al mismo
     * @postcondiciones El diccionario no se ve alterado.
     * @devuelve El valor asociado a la clave especificada
     * @costo El costo es polinómico, dado que se ejecuta un ciclo dentro de otro ciclo.
     */
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
    
    
    /**
     * @tarea Devuelve un conjunto con las claves del diccionario.
     * @parámetros -
     * @precondiciones El diccionario debe estar inicializado.
     * @postcondiciones El conjunto de claves no se ve alterado.
     * @devuelve Un conjunto que contiene las claves del diccionario.
     * @costo El costo es polinómico, dado que se ejecuta un ciclo dentro de otro ciclo.
     */
    // Devuelve un conjunto con las claves del diccionario
    public ConjuntoTDA claves() {
        ConjuntoTDA conjuntoClaves = new ConjuntoSt();
        ColaPrioridadTDA colaAuxiliar = new ColaPrioridadSt();
        
        conjuntoClaves.inicializarConjunto();
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
