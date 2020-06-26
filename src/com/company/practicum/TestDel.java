package com.company.practicum;

import java.io.File;
import java.util.*;

public class TestDel {

    static int N;
    static int K = 3;
    static int goalNum;

    static List<Integer> tokens;


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

            List<Node> list = new ArrayList<>();
            for (int i = 0; i < tokens.size(); i++) {
                Node node = new Node((Math.abs(tokens.get(i) - goalNum)), tokens.get(i));
                list.add(node);
            }

            Collections.sort(list);

            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += list.get(i).val;
            }

            System.out.println(sum);
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    static class Node implements Comparable<Node>{

        int del;
        int val;

        Node(int del, int val) {
            this.del = del;
            this.val = val;
        }

        @Override
        public int compareTo(Node node) {
            if (del == node.del) {
                return 0;
            } else if (del < node.del) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
