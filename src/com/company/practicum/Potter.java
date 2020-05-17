package com.company.practicum;

import java.io.File;
import java.util.*;

public class Potter {

    private static final int M = 3;
    private static int N;

//    private static int sumMin ;
    static List<Integer> tokens;

    public static String bitprint(int u){
        String s= "";
        for(int n= 0;u > 0;++n, u>>= 1)
            if((u & 1) > 0) s+= n + " ";
        return s;
    }

    public static int bitcount(int u){
        int n;
        for(n= 0;u > 0;++n, u&= (u - 1));//Turn the last set bit to a 0
        return n;
    }

    public static LinkedList<String> comb(int c, int n){
        LinkedList<String> s= new LinkedList<String>();

        for(int u= 0;u < 1 << n;u++)
            if(bitcount(u) == c) s.push(bitprint(u));
        Collections.sort(s);
        return s;
    }

    public static void main(String[] args) {

        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            int goalNum = scanner.nextInt();
            tokens = new ArrayList<>();
            while (scanner.hasNextInt()) {
                tokens.add(scanner.nextInt());
            }
            int[] arr = null;
            N = tokens.size();
//            TreeMap<Integer, Integer> sums = new TreeMap<>();
            int maxV = Integer.MAX_VALUE;
            int goalSum = 0;

            LinkedList<String> comb = comb(M,100);
            TreeMap<Integer, Integer> tree= new TreeMap<>();
            for (String set: comb) {
                String[] strings = set.split(" ");
                int[] pos = new int[strings.length];
                int sum = 0;
                for (int i = 0; i < pos.length; i++) {
                    pos[i] = Integer.valueOf(strings[i]);
                    sum += tokens.get(pos[i]);
                }
                int diff = Math.abs(sum - goalNum);
                tree.put(diff, sum);
                if (diff < maxV) {
                    maxV = diff;
                    goalSum = sum;
                }
            }

            System.out.println(tree.firstEntry().getValue());
        } catch (Exception e) {
            System.out.println("" + e);
        }

    }

}
