package com.company.practicum;

import java.io.File;
import java.util.*;

public class Potter2 {

    static int N;
    static int K = 3;
    static int goalNum;

    static List<Integer> tokens;

    static TreeMap<Integer, Integer> tree= new TreeMap<>();

    static void  combine(int n, int k) {
//        List<List<Integer>> ans = new ArrayList<>();
        dfs(new ArrayList<Integer>(), k, 0, n-k);
//        return ans;
    }

    static private void dfs( List<Integer> list, int kLeft, int from, int to) {
        if (kLeft == 0) {
//            ans.add(new ArrayList<Integer>(list));
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += tokens.get(list.get(i));
            }
            int diff = Math.abs(sum - goalNum);
            tree.put(diff, sum);
            return;
        }
        for (int i=from; i<=to; ++i) {
            list.add(i);
            dfs(list, kLeft-1, i+1, to+1);
            list.remove(list.size()-1);
        }
    }

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

            combine(N, K);
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
    }
}
