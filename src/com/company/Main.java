package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

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
        System.out.println(list.stream().mapToLong(i->i).distinct().sum());
    }



}
