package com.roshka.bootcamp;

import java.util.Scanner;

class Jugador {
    private String nombre;

    private Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public static Jugador crearJugador(Scanner scanner, String numeroJugador) {
        System.out.print("Jugador " + numeroJugador + ", ingresa tu nombre: ");
        String nombre = scanner.nextLine();
        return new Jugador(nombre);
    }
}
