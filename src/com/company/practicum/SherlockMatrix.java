package com.company.practicum;

import java.io.File;
import java.util.Scanner;

public class SherlockMatrix {

    private static byte UP = 0;
    private static byte RIGHT = 1;
    private static byte DOWN = 2;
    private static byte LEFT = 3;
    private static short startI = 0;
    private static short startJ = 0;


    private static short[][] matrix = new short[0][0];
    private static boolean[][] passed = new boolean[0][0];

    public static void main(String[] args) {
        File file = new File("input.txt");

        short dim = 0;
        try {
            Scanner scanner = new Scanner( file);
            dim = scanner.nextShort();
            matrix = new short[dim][dim];
            passed = new boolean[dim][dim];
            for (int r = 0; r < dim * dim; r++) {
                short i = (short) (r/dim);
                short j = (short) (r%dim);
                short val = scanner.nextShort();
                matrix[i][j] = val;
            }
        } catch (Exception e) {
            System.out.println("" + e);
        }
        startI = (short) (dim/2 );
        startJ = (short) (dim/2 );
        setPassed(startI , startJ);
        byte dir = UP;
        for (int i = 0; i < dim * dim-1; i++) {
            dir = passNum(startI, startJ, dir);
        }
//        System.out.println(matrix);
    }

    private static byte passNum(short i, short j, byte dir) {
        if (dir == UP) {
            setPassed((short) (i-1), j);
            startI--;
            if (passed[i-1][j+1] == false) {
                return RIGHT;
            } else return UP;
        } else if (dir == RIGHT) {
            setPassed(i,(short) (j+1));
            startJ++;
            if (passed[i+1][j+1] == false) {
                return DOWN;
            } else return RIGHT;
        } else if (dir == DOWN) {
            setPassed((short)(i+1), j);
            startI++;
            if (passed[i+1][j-1] == false) {
                return LEFT;
            } else return DOWN;
        } else if (dir == LEFT) {
            setPassed(i, (short)(j-1));
            startJ--;
            if (passed[i-1][j-1] == false) {
                return UP;
            } else return LEFT;
        }
        return UP;
    }

    private static void setPassed(short i, short j) {
        passed[i][j] = true;
        System.out.println(matrix[i][j]);
    }
}
