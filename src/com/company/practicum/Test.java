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
            File file = new File("input2.txt");
            Scanner scanner = new Scanner(file);
            goalNum = scanner.nextInt();
            tokens = new ArrayList<>();
            while (scanner.hasNextInt()) {
                tokens.add(scanner.nextInt());
            }
            int[] arr = null;

            int maxV = Integer.MAX_VALUE;
            int goalSum = 0;

            tokens = deleteMores();

            N = tokens.size();

            genComb();

            System.out.println(tree.firstEntry().getValue());
        } catch (Exception e) {
            System.out.println("" + e);
        }



        System.out.println("");

    }

    private static List<Integer> deleteMores() {
        List<Integer> newList = new ArrayList<>();
        HashMap<Integer, Integer> elem = new HashMap<>();
        for (int i = 0; i < tokens.size(); i++) {
            int token = tokens.get(i);
            if (!elem.containsKey(token)) {
                elem.put(token, 1);
            } else if ( elem.get(token) >= 3 ){

            } else {
                int num = elem.get( token );
                elem.put(token, num+1);
            }
        }
        for ( Integer key: elem.keySet()
             ) {
            int num = elem.get(key);
            for (int i = 0; i < num; i++) {
                newList.add(key);
            }
        }
        return newList;
    }

    private static void genComb() {
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
            int diff = 0;
            boolean isEnd = false;
            if (!set.contains(comb)) {
                set.add(comb);
                diff = Math.abs(comb.sum - goalNum);
                if (diff == 0) {
                    isEnd = true;
                }
                tree.put(diff, comb.sum);
            }
            if (isEnd) break;
            Collections.shuffle(list);
        }
    }

    static private class Combination {

//        boolean[] array;
        int arrNm[];
        int sum;

        Combination (List<Boolean> list) {
//            array = new boolean[list.size()];
            sum =0;
            arrNm = new int[K];
            int j = 0;
            for (int i = 0; i < list.size(); i++) {
//                array[i] = list.get(i);
                if (list.get(i)) {
                    sum +=tokens.get(i);
                    arrNm[j] = i;
                    j++;
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Combination)) return false;
            Combination that = (Combination) o;
            return Arrays.equals(arrNm, that.arrNm);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(arrNm);
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
