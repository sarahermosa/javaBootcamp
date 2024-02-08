package com.roshka.bootcamp;

import java.util.Scanner;

public class Nim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Jugador jugador1 = Jugador.crearJugador(scanner, "1");
        Jugador jugador2 = Jugador.crearJugador(scanner, "2");

        Pila pilaA = new Pila(3);
        Pila pilaB = new Pila(4);
        Pila pilaC = new Pila(5);

        Jugador jugadorActual = jugador1;
        Jugador jugadorSiguiente = jugador2;

        mostrarEnPantalla(pilaA.getCantidad(), pilaB.getCantidad(), pilaC.getCantidad());

        while (!juegoTerminado(pilaA, pilaB, pilaC)) {
            getTurno(scanner, jugadorActual, pilaA, pilaB, pilaC);
            mostrarEnPantalla(pilaA.getCantidad(), pilaB.getCantidad(), pilaC.getCantidad());
            Jugador[] jugadores = cambiarJugadores(jugadorActual, jugadorSiguiente);
            jugadorActual = jugadores[0];
            jugadorSiguiente = jugadores[1];
        }

        getGanador(jugadorActual, jugadorSiguiente);
    }

    private static void getTurno(Scanner scanner, Jugador jugador, Pila pilaA, Pila pilaB, Pila pilaC) {
        String pilaSeleccionada;
        int cantidad;

        do {
            System.out.print("\n" + jugador.getNombre() + ", elige una pila (A, B, C): ");
            pilaSeleccionada = scanner.nextLine().toUpperCase();
        } while (!validarPila(pilaSeleccionada, pilaA, pilaB, pilaC));

        do {
            System.out.print("¿Cuantos quieres quitar de la pila " + pilaSeleccionada + "?: ");
            cantidad = scanner.nextInt();
        } while (!validarCantidad(pilaSeleccionada, cantidad, pilaA, pilaB, pilaC));

        scanner.nextLine();
        quitarDePila(pilaSeleccionada, cantidad, pilaA, pilaB, pilaC);
    }

    private static boolean validarPila(String pilaSeleccionada, Pila pilaA, Pila pilaB, Pila pilaC) {
        switch (pilaSeleccionada) {
            case "A":
                return pilaA.getCantidad() > 0;
            case "B":
                return pilaB.getCantidad() > 0;
            case "C":
                return pilaC.getCantidad() > 0;
            default:
                System.out.println("Nombre de pila incorrecto. Por favor, intenta nuevamente.");
                return false;
        }
    }

    private static boolean validarCantidad(String pilaSeleccionada, int cantidad, Pila pilaA, Pila pilaB, Pila pilaC) {
        switch (pilaSeleccionada) {
            case "A":
                return cantidad > 0 && cantidad <= pilaA.getCantidad();
            case "B":
                return cantidad > 0 && cantidad <= pilaB.getCantidad();
            case "C":
                return cantidad > 0 && cantidad <= pilaC.getCantidad();
            default:
                return false;
        }
    }

    private static void quitarDePila(String pilaSeleccionada, int cantidad, Pila pilaA, Pila pilaB, Pila pilaC) {
        switch (pilaSeleccionada) {
            case "A":
                pilaA.pop(cantidad);
                break;
            case "B":
                pilaB.pop(cantidad);
                break;
            case "C":
                pilaC.pop(cantidad);
                break;
        }
    }

    private static boolean juegoTerminado(Pila pilaA, Pila pilaB, Pila pilaC) {
        return pilaA.getCantidad() == 0 && pilaB.getCantidad() == 0 && pilaC.getCantidad() == 0;
    }

    private static Jugador[] cambiarJugadores(Jugador jugadorActual, Jugador jugadorSiguiente) {
        Jugador temp = jugadorActual;
        jugadorActual = jugadorSiguiente;
        jugadorSiguiente = temp;
        return new Jugador[]{jugadorActual, jugadorSiguiente};
    }

    private static void getGanador(Jugador jugadorActual, Jugador jugadorSiguiente) {
        System.out.println(jugadorSiguiente.getNombre() + ", has hecho el último movimiento, ¡ganaste! " +
                jugadorActual.getNombre() + " pierde!");
        System.out.println("FIN DEL JUEGO");
    }

    private static void mostrarEnPantalla(int cantidadA, int cantidadB, int cantidadC) {
        int mayorCantidad = Math.max(Math.max(cantidadA, cantidadB), cantidadC);

        System.out.println("\nA: " + cantidadA + "\tB: " + cantidadB + "\tC: " + cantidadC + "\n");

        for (int i = mayorCantidad; i > 0; i--) {
            System.out.print((i <= cantidadA ? "\t* " : "\t  "));
            System.out.print((i <= cantidadB ? "* " : "  "));
            System.out.print((i <= cantidadC ? "* " : "  "));
            System.out.println();
        }
        System.out.println("\tA B C");
    }
}