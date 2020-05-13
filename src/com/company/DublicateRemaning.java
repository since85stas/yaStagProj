package com.company;

import java.io.File;
import java.util.Scanner;

public class DublicateRemaning {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int size = scanner.nextInt();
            if (size > 0) {
                int firstNum = scanner.nextInt();
                System.out.println(firstNum);
                for (int i = 1; i < size; i++) {
                    int num = scanner.nextInt();
                    if (num > firstNum) {
                        System.out.println(num);
                        firstNum = num;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

}

