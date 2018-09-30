package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// implement the
public class MajorityCount {

    HashMap<Character, Integer> counterMap;

    public MajorityCount() {

    }

    // k is the number of counters
    HashMap<Character, Integer> GetKMajorityChars(String fileName, int k) throws IOException{
        counterMap = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        int val = 0;
        int count = 0;
        while((val = reader.read()) != -1) {
            count++;
            char ch = (char)val;

            if(counterMap.containsKey(ch)) {
                counterMap.put(ch, counterMap.get(ch) + 1);
            }
            else if(!counterMap.containsKey(ch) && counterMap.size() < k) {
                counterMap.put(ch, 1);
                continue;
            }

            else if(counterMap.size() == k) {
                for(Character c : counterMap.keySet()) {
                    counterMap.put(c, counterMap.get(c) - 1);
                    //if(counterMap.get(c) == 0) counterMap.remove(c);
                }
            }

            for(Iterator<Map.Entry<Character, Integer>> it = counterMap.entrySet().iterator(); it.hasNext(); ) {
                Map.Entry<Character, Integer> entry = it.next();
                if(entry.getValue() == 0) {
                    it.remove();
                }
            }

        }
    /*
        for(Character c : counterMap.keySet()) {
            System.out.print(c + " count: " + counterMap.get(c));
        }
    */
        System.out.println("Count: " + count);

        return counterMap;
    }


}
