package com.company.practicum;

import java.io.File;
import java.util.Scanner;
import java.util.TreeMap;

public class BioExperiment {

    public static void main(String[] args) {

        TreeMap<Short, Bactery> map = new TreeMap<>();
        BacteryTree bacteryTree = new BacteryTree();

        try {

            File file = new File("input.txt");
            Scanner scanner = new Scanner( file);
            short numbers = scanner.nextShort();

            for (int i = 0; i < numbers; i++) {
                short numB = scanner.nextShort();
                short time = scanner.nextShort();
                short anc1 = scanner.nextShort();
                short anc2 = scanner.nextShort();
                Bactery bac = new Bactery(numB, time);
                map.put(numB, bac);

                bacteryTree.put(bac);

            }

            System.out.println("end");

        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    static class BacteryTree {

        Node root;

        BacteryTree() {}

        void put ( Bactery elem) {
            root = put(root,(short)1, elem);
        }

        private Node put ( Node x,short lev, Bactery bactery) {
            if ( x==null ) {
                return new Node(bactery, lev);
            }
            boolean even = bactery.num % 2 == 0;
            if (even) {
                x.nodeLeft = put(x.nodeLeft, (short) (lev+1), bactery);
            } else {
                x.nodeRight = put(x.nodeRight, (short) (lev+1), bactery);
            }
            return x;
        }

    }

    static class Node {

        Node nodeLeft, nodeRight;

        short level;
        Bactery value;

        Node (Bactery val, short lev) {
            value = val;
            level = lev;
        }
    }

    static class Bactery {

        short num;
        short time;
        short level;

        Bactery (short num, short time) {
            this.num = num;
            this.time = time;
        }

    }

//    public void put(Key key, Value val)
//    { root = put(root, key, val); }
//    private Node put(Node x, Key key, Value val)
//    {
//        if (x == null) return new Node(key, val);
//        int cmp = key.compareTo(x.key);
//        if (cmp < 0)
//            x.left = put(x.left, key, val);
//        else if (cmp > 0)
//            x.right = put(x.right, key, val);
//        else if (cmp == 0)
//            x.val = val;
//        return x;
//    }
}
