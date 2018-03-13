package com.company;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        MajorityCount mc = new MajorityCount();
        HashMap<Character, Integer> map = new HashMap<>();
        try {
            map = mc.GetKMajorityChars("data/FreqData1.txt", 9);
        }
        catch (IOException e) {}

        Utility.PrintHashMap(map);

    }

    public static void printWordGrams (HashSet<ArrayList<String>> set) {
        Iterator<ArrayList<String>> it = set.iterator();
        while(it.hasNext()){
            ArrayList<String> list = it.next();
            for(int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}
