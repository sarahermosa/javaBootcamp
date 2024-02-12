package com.roshka.bootcamp;

import java.util.Objects;

public class Carta {
    public String valor;
    public String palo;
    public Carta() {
    }

    public Carta(String completo)
    {
        this.valor = String.valueOf(completo.charAt(0));
        this.palo = String.valueOf(completo.charAt(1));
    }

    String valorPalo() {
        return this.valor + this.palo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carta carta = (Carta) o;
        return Objects.equals(valor, carta.valor) && Objects.equals(palo, carta.palo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, palo);
    }


}


