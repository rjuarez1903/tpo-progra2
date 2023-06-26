package impl;

import auxiliar.Respuesta;
import tda.ConjuntoEspecialTDA;
import tda.ConjuntoTDA;

public class ConjuntoEspecial implements ConjuntoEspecialTDA {
    private ConjuntoTDA conjunto;
    
    
    /** 
     * @tarea Inicializar el conjunto especial.
     * @parámetros -
     * @precondiciones -
     * @postcondiciones El conjunto especial queda inicializado y listo para su uso.
     * @costo El costo es constante.
     */
    public void inicializarConjunto() {
        conjunto = new ConjuntoSt(); // Se crea una instancia de ConjuntoSt para implementar las operaciones
        conjunto.inicializarConjunto(); // Se inicializa el conjunto interno utilizando la implementación ConjuntoSt
    }
    
    
    /** 
     * @tarea Agrega un elemento al conjunto especial.
     * @parámetros valor El valor a agregar al conjunto.
     * @precondiciones El conjunto especial debe estar inicializado.
     * @postcondiciones El valor queda agregado al conjunto especial, si no pertenecía previamente.
     * @devuelve Una instancia de Respuesta que indica si se pudo agregar el valor correctamente.
     * @costo El costo es lineal, dado que en el método pertenece al que se llama, se recorre los elementos del conjunto.
     */
    public Respuesta agregar(int valor) {
        Respuesta respuesta = new Respuesta(); // Se crea una instancia de Respuesta para almacenar el resultado
        if (conjunto.pertenece(valor)) { // Si el valor ya pertenece al conjunto interno
            respuesta.error = true; // Se establece el error en true
        } else {
            conjunto.agregar(valor); // Se agrega el valor al conjunto interno
            respuesta.error = false; // No hay error
        }
        return respuesta; // Se retorna la respuesta
    }
    
    
    /**
     * @tarea Elimina un elemento del conjunto especial.
     * @parámetros valor El valor a eliminar del conjunto.
     * @precondiciones El conjunto especial debe estar inicializado.
     * @postcondiciones El valor queda eliminado del conjunto especial, si pertenecía previamente.
     * @devuelve Una instancia de Respuesta que indica si se pudo eliminar el valor correctamente.
     * @costo El costo es lineal, dado que en el método pertenece al que se llama, se recorre los elementos del conjunto.
     */
    public Respuesta sacar(int valor) {
        Respuesta respuesta = new Respuesta(); // Se crea una instancia de Respuesta para almacenar el resultado
        if (conjunto.pertenece(valor)) { // Si el valor pertenece al conjunto interno
            conjunto.sacar(valor); // Se elimina el valor del conjunto interno
            respuesta.error = false; // No hay error
        } else {
            respuesta.error = true; // Se establece el error en true
        }
        return respuesta; // Se retorna la respuesta
    }
    
    
    /**
     * @tarea Devuelve un valor elegido aleatoriamente del conjunto especial.
     * @parámetros -
     * @precondiciones El conjunto especial debe estar inicializado y no estar vacío.
     * @postcondiciones El conjunto no se ve alterado
     * @devuelve Una instancia de Respuesta que contiene el valor elegido, si el conjunto no está vacío.
     *          Si el conjunto está vacío, la instancia de Respuesta indica un error.
     * @costo El costo es constante, ya que simplemente se elige un valor del conjunto interno.
     */
    public Respuesta elegir() {
        Respuesta respuesta = new Respuesta(); // Se crea una instancia de Respuesta para almacenar el resultado
        if (!conjunto.conjuntoVacio()) { // Si el conjunto interno no está vacío
            respuesta.error = false; // No hay error
            respuesta.rta = conjunto.elegir(); // Se obtiene el valor elegido del conjunto interno
        } else {
            respuesta.error = true; // Se establece el error en true
        }
        return respuesta; // Se retorna la respuesta
    }
    
    
    /**
     * @tarea Verifica si un valor dado pertenece al conjunto especial.
     * @parámetros valor El valor a verificar.
     * @precondiciones El conjunto especial debe estar inicializado.
     * @devuelve true si el valor pertenece al conjunto especial, false en caso contrario.
     * @costo El costo es lineal, dado que en el método pertenece al que se llama, se recorre los elementos del conjunto.
     */
    public boolean pertenece(int valor) {
        return conjunto.pertenece(valor); // Se verifica si el valor pertenece al conjunto interno
    }

    /**
     * @tarea Verifica si el conjunto especial está vacío.
     * @precondiciones El conjunto especial debe estar inicializado.
     * @postcondiciones El conjunto especial no se modifica.
     * @retorna true si el conjunto especial está vacío, false en caso contrario.
     * @costo El costo es constante.
     */
    public boolean conjuntoVacio() {
        return conjunto.conjuntoVacio(); // Se verifica si el conjunto interno está vacío
    }
}
