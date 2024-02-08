
import java.util.*;

public class ArraysDiaDos {
    public static void main(String[] args) {
//        ejercicioUno();
//        ejercicioDos();
//        ejercicioTres();
        ejercicioCuatro();
    }
//1. Cargar un array de manera aleatoria con 10 números enteros del -5 al 5. Imprimirlo en
//pantalla y computar cuál es el mayor elemento del vector.
    public static void ejercicioUno(){
        Random rd = new Random();

        int[] randomArray = new int[10];
        int min = -5, max = 5;

        for (int i = 0; i<randomArray.length;i++){
            randomArray[i] = rd.nextInt(max-min+1) + min;
            System.out.print(randomArray[i] +", ");
        }

        for (int j=0; j<randomArray.length;j++){
            if (randomArray[j] >= min) {
                min = randomArray[j];
            }
        }

        System.out.println("\nEl mayor elemento es:"+min);
    }

// 2. Cargar un array de manera aleatoria con 100 números enteros del -30 al 30. Imprimirlo en
//pantalla y computar cuál es el elemento que más veces se repite, y cuáles son los números
//que no están presentes (si es que hay alguno).
    public static void ejercicioDos(){
        Random rd = new Random();

        int[] randomArray = new int[100];
        int min = -30, max = 30;
        int maxContador = 0;
        int numeroRepetido = 0;

        for (int i = 0; i<randomArray.length;i++){
            randomArray[i] = rd.nextInt(max-min+1) + min;
            System.out.println(randomArray[i]);
        }

        for (int i = 0; i < randomArray.length; i++) {
            int contador = 0;
            for (int j = 0; j < randomArray.length; j++) {
                if (randomArray[i] == randomArray[j]) {
                    contador++;
                }
            }

            if (contador > maxContador) {
                maxContador = contador;
                numeroRepetido = randomArray[i];
            }
        }

        for (int i = min; i <= max; i++) {
            boolean bandera = false;

            for (int j = 0; j < randomArray.length; j++) {
                if (randomArray[j] == i) {
                    bandera = true;
                    break;
                }
            }

            if (!bandera) {

                System.out.println("\nNo esta presente: " + i);
            }
        }

        System.out.println("\nEl elemento que mas se repite es: "+ numeroRepetido);

    }

//        3. Hacer una función que, dada una palabra (String) o frase, diga si la misma es palíndrome o
//no. Una palabra/frase palíndrome es aquella que se lee igual tanto de atrás para adelante,
//como de adelante para atrás. Ejemplos de palíndromes: "MADAM", "RACECAR", "AMOR,
//ROMA", "BORROW OR ROB", "WAS IT A CAR OR A CAT I SAW?".
    public static void ejercicioTres(){
        String original= "RACECAR", reverse ="";
        char ch;

        for (int i=0; i<original.length(); i++)
        {
            ch= original.charAt(i); //extrae cada caracter
            reverse = ch + reverse; //añade cada caracter en frente del existente
        }

        String originalSinEspacios = original.replaceAll("\\s","");
        String reverseSinEspacios = reverse.replaceAll("\\s","");

        System.out.println("Palabra original: "+ original);
        System.out.println("Palabra reversa: "+ reverse);


        if (originalSinEspacios.equals(reverseSinEspacios)){
            System.out.println("La palabra es palindrome");
        } else {
            System.out.println("La palabra no es palindrome");
        }
    }


 //        4. Dada una cadena de caracteres (String) de longitud desconocida que tiene solamente dígitos,
//crear un array de N elementos (donde N es el tamaño de la cadena) que tenga cada uno de los
//valores numéricos de los dígitos.
    public static void ejercicioCuatro(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese un numero: ");
        String input = scanner.next();

        char[] digitos = input.toCharArray(); //array de caracteres

        System.out.println("Array de digitos: ");
        for (int i = 0; i < digitos.length ; i++) {
            System.out.print("["+digitos[i]+"]"+ " ");
        }
    }
}