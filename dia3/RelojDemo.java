package com.roshka.bootcamp;

import java.util.Scanner;

public class RelojDemo {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese los segundos: ");
        String input = scanner.next();

        int segundo = Integer.parseInt(input);

        /*
        * * instanciar un objeto Reloj, con el constructor de segundos (que
        *  pida al usuario ingresar por el teclado)
        * */
        Reloj reloj = new Reloj(segundo);

        System.out.println(reloj.toString());

        /*
        * utilizar las funcion tick 10 veces y mostrar la hora cada vez que
        * se ejecuta
        */
        for (int i = 0; i<10;i++){
            reloj.tick();
            System.out.println(reloj.toString());
        }

        /*
        * * crear otro objeto reloj y restar la hora con el metodo
        *  restaReloj()*/

        Reloj reloj2 = new Reloj(4,2,56);

        reloj2.restaReloj(reloj);

        System.out.println(reloj2.toString());


    }
}
