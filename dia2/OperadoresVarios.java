/*
*
* 1. Declara dos variables numéricas (con el valor que desees), muestra por consola la
suma, resta, multiplicación, división y módulo (resto de la división).
2. Declara 2 variables numéricas (con el valor que desees), he indica cual es mayor de los dos.
Si son iguales indicarlo también. Ves cambiando los valores para comprobar que funciona.
3. Declara un String que contenga tu nombre, después muestra un mensaje de bienvenida
por consola. Por ejemplo: si introduzco “Fernando”, me aparezca “Bienvenido Fernando”.
4. Modifica la aplicación anterior, para que nos pida el nombre que queremos introducir.
5. Lee un número por teclado e indica si es divisible entre 2 (resto = 0). Si no lo es,
también debemos indicarlo.
6. Lee un número por teclado que pida el precio de un producto (puede tener
decimales) y calcule el precio final con IVA. El IVA sera una constante que sera del
10%.
7. Muestra los números del 1 al 100 (ambos incluidos) divisibles entre 2 y 3.
8. Lee un número por teclado y comprueba que este numero es mayor o igual que cero, si
no lo es lo volverá a pedir (do while), después muestra ese número por consola.
9. Escribe una aplicación con un String que contenga una contraseña cualquiera. Después
se te pedirá que introduzcas la contraseña, con 3 intentos. Cuando aciertes ya no pedirá
mas la contraseña y mostrara un mensaje diciendo “Correcto!”. Piensa bien en la
condición de salida (3 intentos y si acierta sale, aunque le queden intentos, si no acierta
en los 3 intentos mostrar el mensaje “Fallaste jaja!!”).
10. Crea una aplicación que nos pida un día de la semana y que nos diga si
*
*
* */


import java.util.Scanner;

public class OperadoresVarios {

    public static final double IVA = 0.10;

    public static void main(String[] args) {
        int num1 = 30, num2 = 15;
        String name = "Sara";

//        getOperaciones(num1, num2);
//        getComparaciones(num1, num2);
//        bienvenida(name);
//        bienvenidaPersonalizada();
//        findDivisible();
//        getPrecio();
//        listDivisible();
//        findCero();
//        doLogin();
        getDiaLaboral();

    }

/* 1. Declara dos variables numéricas (con el valor que desees), muestra por consola la
    suma, resta, multiplicación, división y módulo (resto de la división).
*/

    public static void getOperaciones(int a, int b){
        int suma = a + b;
        int resta = a - b;
        int multiplicacion = a * b;
        float division = (float) a/b;
        int resto = a%b;

        System.out.println("Los numeros son: "+a+", "+b);
        System.out.println("Suma: "+suma);
        System.out.println("Resta: "+ resta);
        System.out.println("Multiplicacion: "+multiplicacion);
        System.out.println("Division: "+ division);
        System.out.println("Resto: "+ resto);

    }
/*
2. Declara 2 variables numéricas (con el valor que desees), he indica cual es mayor de los dos.
Si son iguales indicarlo también. Ves cambiando los valores para comprobar que funciona.
 */
    public static void getComparaciones(int a, int b){
        if (a > b) {
            System.out.println("El mayor es: " + a );
        } else if (a < b){
            System.out.println("El mayor es: " + b );
        } else {
            System.out.println("Los numeros son iguales");
        }
    }

/*
3. Declara un String que contenga tu nombre, después muestra un mensaje de bienvenida
por consola. Por ejemplo: si introduzco “Fernando”, me aparezca “Bienvenido Fernando”.
 */
    public static void bienvenida (String nombre){
        System.out.println("\nBienvenida "+nombre);
    }
/*
* 4. Modifica la aplicación anterior, para que nos pida el nombre que queremos introducir.
* */

    public static void bienvenidaPersonalizada(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngresa tu nombre: ");
        String input = scanner.next();

        System.out.println("Bienvenido/a " + input);
    }
/*
* 5. Lee un número por teclado e indica si es divisible entre 2 (resto = 0). Si no lo es,
también debemos indicarlo.
* */

    public static void findDivisible(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese un numero: ");
        String input = scanner.next();

        int numero = Integer.parseInt(input);

        if (numero%2 == 0) {
            System.out.println("El numero es divisible entre 2");
        } else {
            System.out.println("El numero no es divisible entre 2");
        }
    }
/*6. Lee un número por teclado que pida el precio de un producto (puede tener
decimales) y calcule el precio final con IVA. El IVA sera una constante que sera del
10%.
*/
    public static void getPrecio(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese el precio del producto: ");
        String input = scanner.next();

        double precio = Double.parseDouble(input);

        double precioFinal = (precio * IVA) + precio;

        System.out.println("El precio final es: " + precioFinal);

    }

/*
7. Muestra los números del 1 al 100 (ambos incluidos) divisibles entre 2 y 3.
*/

    public static void listDivisible(){
        System.out.println("\nLos numeros divisibles entre 2 y 3 son: ");
        for (int i = 0; i<100;i++){
            if (i % 2 == 0 && i % 3 == 0)
                System.out.println("Numero: "+ i);
        }
    }

//    8. Lee un número por teclado y comprueba que este numero es mayor o igual que cero, si
//    no lo es lo volverá a pedir (do while), después muestra ese número por consola.
    public static void findCero() {
        boolean bandera = false;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nIngrese un numero: ");
            String input = scanner.next();

            int numero = Integer.parseInt(input);

            if (numero >= 0 )
                bandera = true;

        } while (!bandera);
    }
//    9. Escribe una aplicación con un String que contenga una contraseña cualquiera. Después
//    se te pedirá que introduzcas la contraseña, con 3 intentos. Cuando aciertes ya no pedirá
//    mas la contraseña y mostrara un mensaje diciendo “Correcto!”. Piensa bien en la
//    condición de salida (3 intentos y si acierta sale, aunque le queden intentos, si no acierta
//            en los 3 intentos mostrar el mensaje “Fallaste jaja!!”).
    public static void doLogin(){
        String password = "abc123";

        int intentos = 0;

        while (intentos < 3){
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nIngrese la contrasenha: ");
            String input = scanner.next();

            if (input.equals(password)){
                System.out.println("Correcto!");
                break;
            } else {
                intentos++;
            }
        }

        if (intentos==3)
            System.out.println("Fallaste jaja!!");
    }


//10. Crea una aplicación que nos pida un día de la semana y que nos diga si es un dia
//    laboral o no (“De lunes a viernes consideramos dias laborales”).
    public static void getDiaLaboral(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese el dia: ");
        String input = scanner.next();

        switch (input.toLowerCase()){
            case "lunes":
                System.out.println("\nEl dia ingresado es un dia laboral");
                break;
            case "martes":
            case "míercoles":
            case "jueves":
            case "viernes":
            default:
                System.out.println("\nEl dia ingresado no es un dia laboral");
                break;

        }
    }

}
