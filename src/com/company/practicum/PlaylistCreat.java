package com.company.practicum;

import java.io.File;
import java.util.Scanner;

public class PlaylistCreat {

    public static void main(String[] args) {
        try {

            File file = new File("input.txt");
            Scanner scanner = new Scanner( file);

            short len = scanner.nextShort();
            short[] russians = new short[len];
            short[] english  = new short[len];
            for (int i = 0; i < len; i++) {
                russians[i] = scanner.nextShort();
            }
            for (int i = 0; i < len; i++) {
                english[i] = scanner.nextShort();
            }
            for (int i = 0; i < 2 * len; i++) {
                if ( i%2 == 0) {
                    System.out.print(russians[i/2] + " ");
                } else {
                    System.out.print(english[i/2]+ " ");
                }
            }
            System.out.println("");

        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

}
