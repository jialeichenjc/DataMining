package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by super on 2/3/2018.
 */
public class kGram {
    public HashSet<ArrayList<String>> kGramWordBased(String filename, int k) throws IOException {
        HashSet<ArrayList<String>> set = new HashSet<ArrayList<String>>();
        ArrayList<String> rawSet = new  ArrayList<String>();
        File file = new File(filename);
        Scanner sc = new Scanner(file).useDelimiter("\\s+");
        while(sc.hasNext()) {
           //int temp = k;
            rawSet.add(sc.next());
        }

        for(int i = 0; i <= rawSet.size() - k; i++) {
            ArrayList<String> curr = new ArrayList<String>();
            for(int j = 0; j < k; j++) {
                curr.add(rawSet.get(i+j));
            }
            set.add(curr);
        }

        sc.close();
        return set;
    }

    public HashSet<String> kGramCharBased(String filename) throws IOException {
        HashSet<String> set = new HashSet<String>();
        File file = new File(filename);
        Scanner sc = new Scanner(file).useDelimiter("\\s+");



        return set;
    }
}
