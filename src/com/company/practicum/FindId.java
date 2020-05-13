package com.company.practicum;
import java.util.*;
import java.util.Scanner;

public class FindId {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
//        int[] massive = new int[num];
        HashSet<Integer> set = new HashSet<>();

        int beg = 1;
        for (int i = 0; i < num; i++) {
//            massive[i] = beg;
            set.add(beg);
            beg++;
        }

        for (int i = 0; i < num - 2; i++) {
            int id = scanner.nextInt();
            set.remove(id);
        }

        for (Integer  rem: set) {
            System.out.println(rem);
        }
    }


}
