package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

// implement the
public class MajorityCount {

    HashMap<Character, Integer> counterMap;

    public MajorityCount() {
        counterMap = new HashMap<>();
    }

    // k is the number of counters
    HashMap<Character, Integer> GetKMajorityChars(String fileName, int k) throws IOException{
        ArrayList<Character> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> test = new ArrayList<>();
        test.add(new ArrayList<>());
        test.get(0).add(1);

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        int val = 0;

        while((val = reader.read()) != -1) {
            char ch = (char)val;

            if(counterMap.containsKey(ch)) {
                counterMap.put(ch, counterMap.get(ch) + 1);
            }
            else if(counterMap.size() < k) {
                counterMap.put(ch, 1);
            }
            else if(counterMap.size() == k) {
                for(Character c : counterMap.keySet()) {
                    counterMap.put(c, counterMap.get(c) - 1);
                    //if(counterMap.get(c) == 0) counterMap.remove(c);
                }
            }

            for(Character c : counterMap.keySet()) {
                if(counterMap.get(c) == 0) counterMap.remove(c);
            }

        }

        return counterMap;
    }


}
