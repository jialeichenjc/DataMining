package com.company;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CountMinSketch {

    HashMap<Character, Integer> CountMin(String fileName, int k, int numHash)
            throws IOException {
        ArrayList<Integer> res = new ArrayList<>();

        HashMap<Character, Integer> map = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        int[][] array = new int[numHash][k];

        // initialize a numHash * k 2d array
        for(int i = 0; i < numHash; i++) {
            for(int j = 0; j < k; j++) {
                array[i][j] = 0;
            }
        }

        int val = 0;

        while((val = reader.read()) != -1) {
            char ch = (char) val;
            for(int i = 0; i < numHash; i++) {
                int index = ((hash1(i) + val * hash2(i)) % 9973) % k;
                array[i][index]++;
            //    System.out.println(index);
            }

        }

        for(int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            int num = (int) ch;
            int minCount = Integer.MAX_VALUE;

            for(int j = 0; j < numHash; j++) {
                int index = ((hash1(j) + num * hash2(j)) % 9973) % k;
                minCount = Math.min(array[j][index], minCount);
            }

            map.put(ch, minCount);
        }


        return map;

    }

    // (ax + b) mod p hash functions
    // with prime numbers a, b and p
    public int hash1(int n) {
        return (2459 * n + 17341) % 7979;
    }

    public int hash2(int n) {
        return (5119 * n + 10589) % 9677;
    }
}
