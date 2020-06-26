package com.company.gadalka;

import sun.misc.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Gadalka {

    public static void main(String[] args) {
        List<String> words = readFile();

        HashSet<String> wordsSet = new HashSet<>();

        for (String word : words
             ) {
            wordsSet.add(word);
        }

        HashMap<String, Integer> dict = new HashMap<>();
        for (String word : words
        ) {
            if (!dict.containsKey(word)) {
                dict.put(word, 1);
            } else {
                int oldval = dict.get(word);
                dict.put(word, oldval+1);
            }
        }

        System.out.println("end");
    }

    private static List<String> readFile() {
        try {
            String content;
            content = new String(Files.readAllBytes(Paths.get("newfile.txt")), "Cp1251");
            String[] words = content.split(" ");
            List<String> list =  new ArrayList<>();
            for (String word : words
            ) {
                String wordN = word.replaceAll("(\\r|\\n)", "");
                list.add(wordN);
            }
            return list;
        } catch (Exception e) {
            System.out.println("" + e);
            return Collections.emptyList();
        }

    }

}
