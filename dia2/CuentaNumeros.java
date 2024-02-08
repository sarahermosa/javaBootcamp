package com.roshka.bootcamp;

import java.util.*;

public class CuentaNumeros {

    public static List<Long> findAll(final int sumDigits, final int numDigits) {

        List<Long> lista = new ArrayList<>();

        if (sumDigits < 1 || sumDigits > 9 * numDigits) {
            return lista; // No hay números posibles
        }

        //Ejemplo, si numDigits=3 el minimo es 100 y el max 999
        long rangoMin = (long) Math.pow(10, numDigits-1);
        long rangoMax = (long) Math.pow(10, numDigits)-1;

        long contador = 0; //contador de numeros posibles
        long minNumber = -1;
        long maxNumber = -1;

        for (long i = rangoMin; i <= rangoMax; i++) {
            if (getDigitsCrecientes(i) && sumaDeDigitos(i) == sumDigits) {
                contador++;
                if (minNumber == -1) //en este if solo entrara una vez
                    minNumber = i;   // y guardara el primer minimo que encuentre
                maxNumber = i;
            }
        }

        lista.add(contador);
        lista.add(minNumber);
        lista.add(maxNumber);

        return lista;
    }

//metodo para validar si el numero esta ordenado de forma creciente
    private static boolean getDigitsCrecientes(long num) {
        String numStr = Long.toString(num);
        for (int i = 0; i < numStr.length() - 1; i++) {
            if (numStr.charAt(i) > numStr.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

//  Metodo para calcular la suma de los dígitos de un número
    private static long sumaDeDigitos(long num) {
        long sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
