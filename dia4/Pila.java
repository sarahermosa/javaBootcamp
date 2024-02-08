package com.roshka.bootcamp;

class Pila {
    private int cantidad;

    public Pila(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void pop(int cantidad) {
        this.cantidad -= cantidad;
    }
}