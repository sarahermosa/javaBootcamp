package com.roshka.bootcamp;

import java.util.*;
import java.util.stream.Collectors;


public class Poker {
    public static void main(String[] args) {
        ArrayList<Carta> cartas = new ArrayList<>();

        generarCartas(cartas);

        imprimirCartas(cartas);

        jugada(cartas);
    }


    public static void generarCartas(ArrayList cartas){
        Random rd = new Random();
        ArrayList<String> valoresNum = new ArrayList<String>
                (Arrays.asList("A","2","3","4","5","6","7","8","9","T","J","Q","K"));
        ArrayList<String> palo = new ArrayList<String>(Arrays.asList("S","C","H","D"));


        String valorNum, valorPalo;

        for (int i=0; i < 5 ; i++){
            valorNum = valoresNum.get(rd.nextInt(valoresNum.size()));
            valorPalo = palo.get(rd.nextInt(palo.size()));
            cartas.add(new Carta(valorNum + valorPalo));
        }

//        cartas.add(new Carta("1H"));
//        cartas.add(new Carta("3S"));
//        cartas.add(new Carta("2D"));
//        cartas.add(new Carta("AC"));
//        cartas.add(new Carta("5S"));


    }


    public static void jugada(ArrayList<Carta> cartas) {
        long contador = contarValoresDistintos(cartas);

        if (contador == 2 && listDuplicates(cartas).size() == 2) {
            System.out.println("\nFULL");
        } else if (contador == 2) {
            System.out.println("\nPOKER");
        } else if (isEscaleraColor(cartas)) {
            System.out.println("\nESCALERA DE COLOR: " + getValor(cartas));
        } else if (isEscalera(cartas)) {
            System.out.println("\nESCALERA: " + getValor(cartas));
        } else if (isColor(cartas)) {
            System.out.println("\nCOLOR");
        } else if (contador == 3 && listDuplicates(cartas).size() == 1) {
            System.out.println("\nTRIO");
        } else if (contador == 3 && listDuplicates(cartas).size() == 2) {
            System.out.println("\nPAR DOBLE");
        } else if (contador > 3 && listDuplicates(cartas).size() == 1) {
            System.out.println("\nPAREJA");
        } else {
            System.out.println("\nCARTA ALTA: " + getCartaAlta(cartas).valorPalo());
        }

    }

    public static long contarValoresDistintos(ArrayList<Carta> cartas) {
        //se usa SET para garantizar que solo se guardaran los valores no repetidos
        Set<Integer> valoresUnicos = new HashSet<>();

        for (int i = 0; i < cartas.size(); i++) {
            valoresUnicos.addAll(getValor(cartas));
        }

        return valoresUnicos.size();
    }


    public static List<Integer> listDuplicates(ArrayList<Carta> cartas) {
        List<Integer> list = getValor(cartas);
        List<Integer> duplicates = new ArrayList<>();

        Set<Integer> set = list.stream()
                .filter(i -> Collections.frequency(list, i) > 1)
                .collect(Collectors.toSet());
        duplicates.addAll(set);

        return duplicates;
    }

    public static boolean isColor(ArrayList<Carta> cartas){

        long contadorPalo = getPalo(cartas).stream().distinct().count();

        if (contadorPalo <= 1)
            return true;

        return false;
    }


    public static boolean isEscalera(ArrayList<Carta> cartas){

        List<Integer> list = getValor(cartas);

        int size = list.size();

        // Verificar si las cartas estan en orden secuencial
        for (int i = 0; i < size - 1; i++) {
            if (list.get(i + 1) - list.get(i) != 1) {
                return false;
            }
        }

        return true;

    }

    public static boolean isEscaleraColor(ArrayList<Carta> cartas){
        return isEscalera(cartas) && isColor(cartas);
    }

    public static ArrayList<String> getPalo(ArrayList<Carta> cartas){
        ArrayList<String> palo = new ArrayList<String>();

        for (int i = 0; i < cartas.size(); i++) {
            palo.add(cartas.get(i).palo);
        }

        return palo;
    }

    public static Carta getCartaAlta (ArrayList<Carta> cartas){
        int valorMasAlto = -1;
        Carta cartaMasAlta = null;
        for (Carta carta : cartas) {
            List<Carta> listaCartas = Arrays.asList(carta);
            ArrayList<Carta> arrayListCartas = new ArrayList<>(listaCartas);
            List<Integer> valoresCarta = getValor(arrayListCartas);
            int valorCarta = valoresCarta.get(0); // Obtener el valor num de la carta
            if (valorCarta > valorMasAlto) {
                valorMasAlto = valorCarta;
                cartaMasAlta = carta;
            }
        }
        return cartaMasAlta;
    }


    public static ArrayList<Integer> getValor(ArrayList<Carta> cartas){
        ArrayList<Integer> valor = new ArrayList<>();

        for (Carta carta : cartas) {
            String valorCarta = carta.valor;
            // Convertir las cartas con valores A, T, J, Q, K a sus valores numericos correspondientes
            switch (valorCarta) {
                case "A":
                    valor.add(14);
                    break;
                case "T":
                    valor.add(10);
                    break;
                case "J":
                    valor.add(11);
                    break;
                case "Q":
                    valor.add(12);
                    break;
                case "K":
                    valor.add(13);
                    break;
                default:
                    valor.add(Integer.parseInt(valorCarta));
            }
        }

        Collections.sort(valor);

        return valor;
    }



    public static void imprimirCartas(ArrayList<Carta> cartas) {

        // Imprimir el valor de cada elemento del ArrayList
        for (int i = 0; i < cartas.size(); i++) {
            System.out.println("Valor de la carta " + (i + 1) + ": " + cartas.get(i).valorPalo());
        }
    }

}
