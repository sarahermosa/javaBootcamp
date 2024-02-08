/*
=============
Vacas y Toros
 100 Puntos
=============
El programa elige un número al azar, de cuatro dígitos, cuyos dígitos no se repitan.
El número debe:
 * Debe tener 4 dígitos (sin ceros adelante)
 * Los dígitos no se pueden repetir. 1234 es un número válido. 1224, no.
El programa pregunta a el usuario por un número y le desafía a adivinar el número que la computadora ha pensado.
El programa controla la cadena (string) ingresada por el usuario, y si es un número de 4 dígitos, analiza el número:
Toros: Dígitos acertados en el mismo lugar.
Vacas: Dígitos acertados, pero en un lugar diferente.
Número de la computadora:    1   2  [3] [4]
Número de ingreso de user:  [4] [3]  8   0
** 2 vacas, 0 toros.
Número de la computadora:   [1]  2  [3] [4]
Número de ingreso de user:  [1] [3]  8  [4]
** 1 vaca, 2 toros.
El programa luego debe imprimir: 2 vacas, 0 toros y permitir el ingreso de un nuevo intento:
"Por favor, intente de nuevo: "
El programa termina cuando el usuario gana el juego, obteniendo 4 toros.
"Felicidaes! El número secreto era: <number>"
 */

import java.util.Scanner;

public class VacasAndToros {
    public static void main(String[] args) {
        boolean bandera = false;

        int rango = 9;
        int longitud = 4; //longitud del array de numeros randoms


        //la idea es usar este metodo que me retorne un array de digitos
        //despues me di cuenta que me lie grande, podria haber ido por otro camino y generar un numero de 4 digitos
        // en vez de un array
        int[] array = getRandomNumbersWithNoDuplicates(rango, longitud);

        Scanner scanner = new Scanner(System.in);

        while (!bandera){
            System.out.println("\nIngrese un numero: ");
            String input = scanner.next();

            int numero = Integer.parseInt(input);
            char[] digitos = String.valueOf(numero).toCharArray();

            if (digitos.length != longitud) {
                System.out.println("Ingrese un numero con 4 digitos");
            } else {
                System.out.println("Valor ingresado: ");
                for (int i = 0; i < digitos.length ; i++) {
                    System.out.print(digitos[i]+ " ");
                }
            }

            int toros = getToros (array, digitos);
            int vacas = getVacas (array, digitos);

            System.out.println("\ntoros " + toros + " vacas " + vacas);

            if (toros == 4) {
                bandera = true;
                System.out.println("¡Felicidades! ¡Ha adivinado el número secreto!");
                System.out.println("\nNumero secreto: ");
                for (int i = 0; i < array.length; i++) {
                    System.out.print(array[i] + " ");
                }
            } else {
                System.out.println("Por favor, intente de nuevo: ");
            }

        }

    }

    public static int getToros(int[] computadora, char[] digitos){
        int toros = 0;
        for (int i=0; i < computadora.length; i++){
            if (computadora[i] == Character.getNumericValue(digitos [i]))
                toros ++;
        }
        return toros;
    }

    public static int getVacas(int[] computadora, char[] digitos){
        int vacas = 0;
        for (int i=0; i < computadora.length; i++) {
            for (int j = 0; j < computadora.length; j++) {
                if (computadora[i] == Character.getNumericValue(digitos [j]))
                    vacas++;
            }
        }
        return vacas;
    }


    public static int[] getRandomNumbersWithNoDuplicates(int range, int length){
        if (length<range){
            // this is where all the random numbers
            int[] randomNumbers = new int[length];

            // loop through all the random numbers to set them
            for (int q = 0; q < randomNumbers.length; q++){

                // get the remaining possible numbers
                int remainingNumbers = range-q;

                // get a new random number from the remainingNumbers
                int newRandSpot = (int) (Math.random()*remainingNumbers);

                newRandSpot++;

                // loop through all the possible numbers
                for (int t = 1; t < range+1; t++){

                    // check to see if this number has already been taken
                    boolean taken = false;
                    for (int number : randomNumbers){
                        if (t==number){
                            taken = true;
                            break;
                        }
                    }

                    // if it hasnt been taken then remove one from the spots
                    if (!taken){
                        newRandSpot--;

                        // if we have gone though all the spots then set the value
                        if (newRandSpot==0){
                            randomNumbers[q] = t;
                        }
                    }
                }
            }
            return randomNumbers;
        } else {
            // invalid can't have a length larger then the range of possible numbers
        }
        return null;
    }
}

