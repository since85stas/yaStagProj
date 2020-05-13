package com.company.practicum;

import java.io.File;
import java.util.*;

public class Potter {

    private static final int M = 3;
    private static int N;

    private static int[] generateCombinations(int[] arr) {
        if (arr == null) {
            arr = new int[M];
            for (int i = 0; i < M; i++)
                arr[i] = i + 1;
            return arr;
        }
        for (int i = M - 1; i >= 0; i--)
            if (arr[i] < N - M + i + 1) {
                arr[i]++;
                for (int j = i; j < M - 1; j++)
                    arr[j + 1] = arr[j] + 1;
                return arr;
            }
        return null;
    }

    public static void main(String[] args) {

        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            int goalNum = scanner.nextInt();
            List<Integer> tokens = new ArrayList<>();
            while (scanner.hasNextInt()) {
                tokens.add(scanner.nextInt());
            }
            int[] arr = null;
            N = tokens.size();
            TreeMap<Integer, Integer> sums = new TreeMap<>();
            while ((arr = generateCombinations(arr)) != null) {
                if (arr != null) {
                    int sum = 0;
                    for (int i = 0; i < arr.length; i++) {
                        sum += tokens.get(arr[i]-1);
                    }
                    sums.put( Math.abs(sum - goalNum), sum);
//                    System.out.println(Arrays.toString(arr));
                }
            }
            int answ = sums.firstEntry().getValue();
            System.out.println(answ);
        } catch (Exception e) {
            System.out.println("" + e);
        }

    }

}
