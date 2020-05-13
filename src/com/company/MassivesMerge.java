package com.company;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class MassivesMerge {
        public static void main(String[] args) {

            byte[][] massivesB;

            File file = new File("input.txt");
            try {
                Scanner scanner = new Scanner(file);
                short numMassives = scanner.nextShort();
                massivesB = new byte[numMassives][];
                int sumLenght = 0;
                for (short i = 0; i < numMassives ; i++) {
                    short s2 = scanner.nextShort();
                    sumLenght += s2;
                    massivesB[i] = new byte[s2];
                    for(short j = 0; j < s2; j++ ) {
                        massivesB[i][j] = scanner.nextByte();
                    }
                }
                byte[] fullArray = new byte[sumLenght];
                int coumt = 0;
                for (int i = 0; i < massivesB.length; i++) {
                    for (int j = 0; j < massivesB[i].length; j++) {
                        fullArray[coumt] = massivesB[i][j];
                        coumt++;
                    }
                }
                if (fullArray.length > 0) {
                    Arrays.sort(fullArray);
                    for (byte num : fullArray
                    ) {
                        System.out.println(num);
                    }
                }
            } catch (Exception e) {
                System.out.println("" + e);
            }
        }
}
