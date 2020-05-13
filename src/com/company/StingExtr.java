package com.company;

import java.io.File;
import java.util.Scanner;

public class StingExtr {
    public static void main(String[] args) {
        String string = "";
        File file = new File("input.txt");
        try {
            Scanner scanner = new Scanner( file);
            string = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("" + e);
        }

        int start =0;
        int count =0;
        int countSum = 0;
        for (int i = 0; i < string.length(); i++) {
            if (isCharAnSymbol(string.charAt(i)) &&  i != string.length()-1 && isCharAnSymbol(string.charAt(i+1))) {
                if (isCharAnSymbol(string.charAt(i+1))) {
                    countSum++;
                }
            } else if (isCharDigit(string.charAt(i)) && count == 0) {
                start = i;
                count++;
            } else if (isCharDigit(string.charAt(i))) {
                count ++;
            } else if (!isCharDigit(string.charAt(i)) && count !=0) {
                int num = Integer.parseInt(string.substring(start,start+count));
                countSum += num;
                count = 0;
            } else {
//                countSum++;
            }
        }
        if (isCharDigit(string.charAt(string.length()-1))) {
                int num = Integer.parseInt(string.substring(start, start + count));
                countSum += num;

        } else {
            countSum++;
        }
        System.out.println(countSum );
    }

    protected static boolean isCharAnSymbol(Character c) {
        return Character.isLetter(c);
    }

    protected static boolean isCharDigit(Character c) {
        return Character.isDigit(c);
    }
}
