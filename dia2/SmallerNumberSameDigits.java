package com.roshka.bootcamp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallerNumberSameDigits {

    public static void main(String[] args) {
        System.out.println("El numero es "+nextSmaller(907));;
    }

    public static long nextSmaller(long n)
    {
        List<Integer> digits = getDigits(n);
        int size = digits.size();

        // Empezamos desde el último dígito y buscamos el primer par de dígitos consecutivos
        // donde el primer dígito sea menor que el siguiente
        int i = size - 1;
        while (i > 0 && digits.get(i) >= digits.get(i - 1)) {
            i--;
        }

        // Si no encontramos tal par, significa que no hay un número más pequeño con los mismos dígitos
        if (i == 0) {
            return -1;
        }

        // Encontramos el índice donde el dígito es menor que el siguiente
        int pivote = i - 1;

        // Encontramos el dígito más grande a la derecha del dígito pivote, pero menor que él
        int j = size - 1;
        while (digits.get(j) >= digits.get(pivote)) {
            j--;
        }

        // Intercambiamos el dígito pivote con el dígito encontrado
        Collections.swap(digits, pivote, j);

        // Ordenamos los dígitos a la derecha del pivote en orden descendente
        Collections.sort(digits.subList(pivote + 1, size), Collections.reverseOrder());

        // Construimos el número a partir de la lista de dígitos
        long result = 0;
        for (int k = 0; k < size; k++) {
            result = result * 10 + digits.get(k);
        }

        // Si el número comienza con cero no es válido
        if (String.valueOf(result).length() < size) {
            return -1;
        }

        return result;
    }

    // Metodo para convertir un número en una lista de dígitos
    private static List<Integer> getDigits(long num) {
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add((int) (num % 10));
            num /= 10;
        }
        Collections.reverse(digits);
        return digits;
    }
}
