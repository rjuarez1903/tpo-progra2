package impl;

import tda.MultiPilaTDA;
import tda.PilaTDA;

public class MultiPila implements MultiPilaTDA {
    private PilaTDA pila;

    @Override
    public void inicializarPila() {
        // Se inicializa la pila principal utilizando una implementación específica
        pila = new PilaSt();
        pila.inicializarPila();
    }

    @Override
    public void apilar(PilaTDA valores) {
        // Se utiliza una pila temporal para almacenar los valores de la pila que se quiere apilar
        PilaTDA pilaTemporal = new PilaSt();
        pilaTemporal.inicializarPila();

        // Se transfieren los elementos de la pila "valores" a la pila temporal en orden inverso
        while (!valores.pilaVacia()) {
            pilaTemporal.apilar(valores.tope());
            valores.desapilar();
        }

        // Se transfieren los elementos de la pila temporal a la pila principal y se restaura la pila "valores"
        while (!pilaTemporal.pilaVacia()) {
            pila.apilar(pilaTemporal.tope());
            valores.apilar(pilaTemporal.tope());
            pilaTemporal.desapilar();
        }
    }

    @Override
    public void desapilar(PilaTDA valores) {
        // Se utiliza una pila temporal para almacenar los valores que no se desapilan
        PilaTDA pilaTemporal = new PilaSt();
        pilaTemporal.inicializarPila();

        // Se verifica si los valores tope de la pila principal coinciden con los valores tope de la pila "valores"
        while (!pila.pilaVacia() && !valores.pilaVacia()) {
            if (pila.tope() == valores.tope()) {
                pila.desapilar();
                valores.desapilar();
            } else {
                pilaTemporal.apilar(pila.tope());
                pila.desapilar();
            }
        }

        // Se transfieren los valores restantes de la pila principal a la pila temporal
        while (!pila.pilaVacia()) {
            pilaTemporal.apilar(pila.tope());
            pila.desapilar();
        }

        // Se transfieren los valores de la pila temporal nuevamente a la pila principal
        while (!pilaTemporal.pilaVacia()) {
            pila.apilar(pilaTemporal.tope());
            pilaTemporal.desapilar();
        }
    }

    @Override
    public PilaTDA tope(int cantidad) {
        // Se crea una nueva pila para almacenar los elementos tope de la pila principal
        PilaTDA pilaTope = new PilaSt();
        pilaTope.inicializarPila();

        // Se utiliza una pila temporal para almacenar los elementos desapilados temporalmente de la pila principal
        PilaTDA pilaTemporal = new PilaSt();
        pilaTemporal.inicializarPila();

        // Se desapilan "cantidad" elementos de la pila principal y se almacenan en la pila temporal
        while (!pila.pilaVacia() && cantidad > 0) {
            pilaTemporal.apilar(pila.tope());
            pila.desapilar();
            cantidad--;
        }

        // Se transfieren los elementos de la pila temporal a la pila tope y se restaura la pila principal
        while (!pilaTemporal.pilaVacia()) {
            pilaTope.apilar(pilaTemporal.tope());
            pila.apilar(pilaTemporal.tope());
            pilaTemporal.desapilar();
        }

        return pilaTope;
    }

    @Override
    public boolean pilaVacia() {
        // Se verifica si la pila principal está vacía
        return pila.pilaVacia();
    }
}
