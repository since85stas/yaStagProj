package com.company;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Chetnost {
    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        File file = new File("input.txt");
        try {
            Scanner scanner = new Scanner( file);
            while(scanner.hasNextInt()){
                list.add( scanner.nextLong());
            }
        } catch (Exception e) {
            System.out.println("" + e);
        }
        list.remove(0);

        // число не четных элементов
        long sumNeChet = list.stream().mapToLong(i->i).map(i -> i%2).filter(i -> i == 1).sum();

        long sumChet = list.size() - sumNeChet;


        // если отлич больше чем на 1 то невозможно
        if (Math.abs(sumChet - sumNeChet ) > 2) {
            System.out.println(-1);
        } else {
            List<Long> arrayBin = list.stream().map(i -> i%2).collect(Collectors.toList());

            long count = 0;
            for (int i = 1; i < arrayBin.size(); i++) {
                if ( arrayBin.get(i).equals(arrayBin.get(i-1)) ) {
                    int next = getNextOtherchetElem(arrayBin,i);
                    if (next >0) {
                        count++;
                        Collections.swap(arrayBin,i,next);
                        Collections.swap(list,i,next);
                    } else {
                        break;
                    }
                }
            }
            System.out.println(count);
            list.forEach(i -> System.out.print(i + " "));
        }
    }

    public static int getNextOtherchetElem( List<Long> list, int pos ) {
        long elem = list.get(pos);
        for (int i = pos +1; i < list.size(); i++) {
            if (list.get(i) != elem) {
                return i;
            }
        }
        return -1;
    }
}
