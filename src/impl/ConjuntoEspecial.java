package impl;

import tda.ConjuntoEspecialTDA;
import tda.ConjuntoTDA;
import aux.Respuesta;

public class ConjuntoEspecial implements ConjuntoEspecialTDA {
    private ConjuntoTDA conjunto;

    public void inicializarConjunto() {
        conjunto = new ConjuntoSt(); // Se crea una instancia de ConjuntoSt para implementar las operaciones
        conjunto.inicializarConjunto(); // Se inicializa el conjunto interno utilizando la implementación ConjuntoSt
    }

    public Respuesta agregar(int valor) {
        Respuesta respuesta = new Respuesta(); // Se crea una instancia de Respuesta para almacenar el resultado
        if (conjunto.pertenece(valor)) { // Si el valor ya pertenece al conjunto interno
            respuesta.error = true; // Se establece el error en true
            respuesta.rta = 0; // Se asigna un valor por defecto en caso de error
        } else {
            conjunto.agregar(valor); // Se agrega el valor al conjunto interno
            respuesta.error = false; // No hay error
        }
        return respuesta; // Se retorna la respuesta
    }

    public Respuesta sacar(int valor) {
        Respuesta respuesta = new Respuesta(); // Se crea una instancia de Respuesta para almacenar el resultado
        if (conjunto.pertenece(valor)) { // Si el valor pertenece al conjunto interno
            conjunto.sacar(valor); // Se elimina el valor del conjunto interno
            respuesta.error = false; // No hay error
        } else {
            respuesta.error = true; // Se establece el error en true
            respuesta.rta = 0; // Se asigna un valor por defecto en caso de error
        }
        return respuesta; // Se retorna la respuesta
    }

    public Respuesta elegir() {
        Respuesta respuesta = new Respuesta(); // Se crea una instancia de Respuesta para almacenar el resultado
        if (!conjunto.conjuntoVacio()) { // Si el conjunto interno no está vacío
            respuesta.error = false; // No hay error
            respuesta.rta = conjunto.elegir(); // Se obtiene el valor elegido del conjunto interno
        } else {
            respuesta.error = true; // Se establece el error en true
            respuesta.rta = 0; // Se asigna un valor por defecto en caso de error
        }
        return respuesta; // Se retorna la respuesta
    }

    public boolean pertenece(int valor) {
        return conjunto.pertenece(valor); // Se verifica si el valor pertenece al conjunto interno
    }

    public boolean conjuntoVacio() {
        return conjunto.conjuntoVacio(); // Se verifica si el conjunto interno está vacío
    }
}
