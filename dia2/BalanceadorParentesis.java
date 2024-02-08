package com.roshka.bootcamp;
import java.util.*;

public class BalanceadorParentesis {
    public static Boolean isBalanced(final String cadena) {
        // creamos un stack vacio
        Stack stack = new Stack();

        // convertimos la cadena en un array de caracteres
        char[] charArray = cadena.toCharArray();

        // iteramos sobre el array de caracteres
        for (int i = 0; i < charArray.length; i++) {
            char actual = charArray[i];

            //verificamos si es un parentesis inicial '(', '[' o '{'
            if (actual == '{' || actual == '[' || actual == '(') {
                //apilamos al top del stack
                stack.push(actual);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }
            //validamos si el caracter del top del stack para extraer el elemento del stack y si es
            // '(', '[' o '{', devuelve falso
            char popChar;
            switch (actual) {
                case ')':
                    popChar = (char) stack.pop();
                    if (popChar == '{' || popChar == '[')
                        return false;
                    break;
                case '}':
                    popChar = (char) stack.pop();
                    if (popChar == '(' || popChar == '[')
                        return false;
                    break;
                case ']':
                    popChar = (char) stack.pop();
                    if (popChar == '(' || popChar == '{')
                        return false;
                    break;
            }
        }
        return (stack.isEmpty());
    }
}

