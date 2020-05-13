package com.company.practicum;

import java.io.File;
import java.util.Scanner;

public class CodeNum {

    public static void main(String[] args) {
        try {

            File file = new File("input.txt");
            Scanner scanner = new Scanner( file);
            short number = scanner.nextShort();
            boolean isNeg = false;
            if (number < 0) {
                isNeg = true;
                System.out.print("-");
            }

            number = (short) Math.abs(number);
            if (number == 0) System.out.println(number);
            boolean isPrint = false;
            while (number != 0) {
                short cel = (short) (number / 10);
                short ost = (short) (number - cel * 10);
                if (ost != 0 ) {
                    System.out.print(ost);
                    isPrint = true;
                } else {
                    if (isPrint) System.out.print(ost);
                }
                number = cel;
            }

//            System.out.println("end");

        } catch (Exception e) {
            System.out.println("" + e);
        }
    }
}
