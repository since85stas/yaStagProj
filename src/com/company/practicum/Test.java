package com.company.practicum;
import java.io.File;
import java.util.*;

public class Test {

    static int N;
    static int K = 3;
    static int goalNum;

    static  Boolean[] arr;
    static List<Integer> tokens;

    static TreeMap<Integer, Integer> tree= new TreeMap<>();

    public static void main(String[] args) {


        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            goalNum = scanner.nextInt();
            tokens = new ArrayList<>();
            while (scanner.hasNextInt()) {
                tokens.add(scanner.nextInt());
            }
            int[] arr = null;
            N = tokens.size();
            int maxV = Integer.MAX_VALUE;
            int goalSum = 0;

            HashSet<Combination> comb = genComb();

//            for (Combination set: comb) {
////                int[] pos = new int[set.size()];
////                for (int i = 0; i < set.array.length; i++) {
////                    if (set.array[i])
////                      sum += tokens.get(i);
////                }
//                int diff = Math.abs(set.sum - goalNum);
//                tree.put(diff, set.sum);
//                if (diff < maxV) {
//                    maxV = diff;
//                    goalSum = set.sum;
//                }
//            }

            System.out.println(tree.firstEntry().getValue());
        } catch (Exception e) {
            System.out.println("" + e);
        }



        System.out.println("");

    }

    private static HashSet<Combination> genComb() {
        arr = new Boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = false;
        }
        for (int i = 0; i < K; i++) {
            arr[i] = true;
        }

        int com = numComb(N,K);

        List<Boolean> list = Arrays.asList(arr);
        HashSet<Combination> set = new HashSet<>();

        int count = 0;
        while (set.size() != com) {
//            System.out.println(count);
            count++;
            Combination comb = new Combination(list);
            if (!set.contains(comb)) {
                set.add(comb);
                int diff = Math.abs(comb.sum - goalNum);
                tree.put(diff, comb.sum);
            }
            Collections.shuffle(list);
        }
        return set;
    }

    static private class Combination {

        boolean[] array;

        int sum;

        Combination (List<Boolean> list) {
            array = new boolean[list.size()];
            sum =0;
            for (int i = 0; i < list.size(); i++) {
                array[i] = list.get(i);
                if (array[i]) {
                    sum +=tokens.get(i);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Combination)) return false;
            Combination that = (Combination) o;
            return Arrays.equals(array, that.array);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(array);
        }
    }

    private static int numComb(int n, int k) {
        float num = 1;
        for (int i = 1; i < k+1; i++) {
            float up = (float)(n-(k-i));
            float down = (float) i;
            num *= up/down;
        }
        return Math.round(num);
    }

}
