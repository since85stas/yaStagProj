package com.company.practicum;

import java.io.File;
import java.util.*;

public class BioExperiment {

    public static void main(String[] args) {

        TreeMap<Short, Bactery> map = new TreeMap<>();
        TreeMap<Short, Short> childsMap = new TreeMap<>();
//        TreeMap<Short, Short> levelNum = new TreeMap<>();
//        BacteryTree bacteryTree = new BacteryTree();

        try {

            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            short numbers = scanner.nextShort();
//            InputForm[] format = new InputForm[numbers];

            for (int i = 0; i < numbers; i++) {
                short numB = scanner.nextShort();
                short time = scanner.nextShort();
                short anc1 = scanner.nextShort();
                short anc2 = scanner.nextShort();
                Bactery bac = new Bactery(numB, time, anc1, anc2);
                if (i == 0) {
                    bac.level = 1;
                } else {
                    short curN = bac.num;
                    if (childsMap.containsKey(curN)) {
                        bac.level = (short) (map.get(childsMap.get(curN)).level + 1);
                    }
                }
//                map.put(numB, bac);
                map.put(numB, bac);
                childsMap.put(bac.leftCh, bac.num);
                childsMap.put(bac.rightCh, bac.num);
//                format[i] = new InputForm(numB, time, anc1, anc2);
            }

            List<List<Short>> times = new ArrayList<>();
            short lev = map.lastEntry().getValue().level;

            for (int j = 1; j < lev + 1; j++) {
                List<Short> timeIn = new ArrayList<>();
                int count = 1;
                for (Bactery bac : map.values()) {
                    if (bac.level == j) {
                        timeIn.add(bac.time);
                    }
                }
                times.add(timeIn);
            }

            for (int i = 0; i < times.size(); i++) {
                int sum = 0;
                int count = 0;
                for (int j = 0; j < times.get(i).size(); j++) {
                    sum += times.get(i).get(j);
                    count++;
                }
                float av = (float)(sum)/(float) (count);
                System.out.format(Locale.CANADA,"%.2f ", av);
            }
//            System.out.println("end");

        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    static class Bactery {

        short num;
        short time;
        short leftCh;
        short rightCh;
        short level;

        Bactery(short num, short time, short leftCh, short rightCh) {
            this.num = num;
            this.time = time;
            this.leftCh = leftCh;
            this.rightCh = rightCh;
        }

    }


//    static class InputForm {
//        short num, time, anc1, anc2;
//
//        InputForm(short num, short time, short anc1, short anc2) {
//            this.num = num;
//            this.time = time;
//            this.anc1 = anc1;
//            this.anc2 = anc2;
//        }
//    }

//    static class BacteryTree {
//
//        Node root;
//
//        BacteryTree() {}
//
//        void put ( Bactery elem, short leftC, short rightC) {
//            root = put(root, (short)1, elem);
//
//            if (leftC != -1) root.nodeLeft = new Node(leftC);
//            if (rightC != -1) root.nodeRight = new Node(rightC);
//        }
//
//        private Node put ( Node x,short lev, Bactery bactery) {
//            if ( x==null ) {
//                return new Node(bactery, lev);
//            }
//            if (x.nodeLeft != null && x.nodeLeft.number == bactery.num) {
//                x.nodeLeft.value = bactery;
//                x.nodeLeft.level = (short) (lev+1);
//                put(x.nodeLeft, (short) (lev+1), bactery);
//            }
//            if (x.nodeRight != null && x.nodeRight.number == bactery.num) {
//                x.nodeRight.value = bactery;
//                x.nodeRight.level = (short) (lev+1);
//                put(x.nodeRight, (short) (lev+1), bactery);
//            }
////            boolean even = bactery.num % 2 == 0;
////            if (even) {
////                x.nodeLeft = put(x.nodeLeft, (short) (lev+1), bactery);
////            } else {
////                x.nodeRight = put(x.nodeRight, (short) (lev+1), bactery);
////            }
//
//            return x;
//        }
//
//    }
//
//    static class Node {
//
//        Node nodeLeft, nodeRight;
//
//        short number;
//        short level;
//        Bactery value;
//
//        Node(short num) {
//            number = num;
//        }
//
//        Node (Bactery val, short lev) {
//            value = val;
//            level = lev;
//        }
//    }

//    static class Bactery {
//
//        short num;
//        short time;
//        short level;
//
//        Bactery (short num, short time) {
//            this.num = num;
//            this.time = time;
//        }
//
//    }

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
