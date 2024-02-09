package com.roshka.bootcamp;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.list;

public class Generala {
    public static void main(String[] args) {
        Random rd = new Random();
        ArrayList<Integer> randomArray = new ArrayList<Integer>();
        int min = 1, max = 6;

        for (int i = 0; i < 5 ;i++){
            randomArray.add(rd.nextInt(max-min+1) + min);
        }

        Collections.sort(randomArray);
        System.out.print(randomArray);

        jugada(randomArray);

    }

    public static void jugada(ArrayList array){

        long contador = array.stream().distinct().count();

        if(contador <= 1) {
            System.out.println("\nGENERALA");
        } else if (contador == 2 && listDuplicates(array).size() == 2) {
            System.out.println("\nFULL");
        } else if (contador == 2 ) {
            System.out.println("\nPOKER");
        } else if (isEscalera(array)){
            System.out.println("\nESCALERA: "+array);
        } else {
            System.out.println("\nNADA");
        }
    }


    public static List<Integer> listDuplicates(List<Integer> list) {
        List<Integer> duplicates = new ArrayList<>();
        Set<Integer> set = list.stream()
                .filter(i -> Collections.frequency(list, i) > 1)
                .collect(Collectors.toSet());
        duplicates.addAll(set);
        return duplicates;
    }


    public static boolean isEscalera(List<Integer> list){

        if (list.get(0)==1 && list.get(1) == 2 && list.get(2)==3
                && list.get(3) == 4 && list.get(4)==5){
            return true;
        } else if (list.get(0)==2 && list.get(1) == 3 && list.get(2)==4
                && list.get(3) == 5 && list.get(4)==6){
            return true;
        } else if ((list.get(0)==1 && list.get(1) == 3 && list.get(2)==4
                && list.get(3) == 5 && list.get(4)==6)) {
            return true;
        }

        return false;
    }

}
