package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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

    public HashSet<String> kGramCharBased(String filename, int k) throws IOException {
        HashSet<String> set = new HashSet<String>();
        ArrayList<Character> rawSet = new  ArrayList<Character>();

        File file = new File(filename);
        Scanner sc = new Scanner(file).useDelimiter("");
        //Scanner sc = new Scanner(file);

        while(sc.hasNext()) {
            //int temp = k;
            String str = sc.next();
            for(int i = 0; i < str.length(); i++) {
                rawSet.add(str.charAt(i));
            }

            for(int i = 0; i <= rawSet.size() - k; i++) {
                String curr = new String();
                for(int j = 0; j < k; j++) {
                    curr += rawSet.get(i+j);
                }
                set.add(curr);
            }
        }

        return set;
    }

    public float JacSimWordGram(HashSet<ArrayList<String>> set1,
                                HashSet<ArrayList<String>> set2) {
        HashSet<ArrayList<String>> union = new HashSet<ArrayList<String>>();
        HashSet<ArrayList<String>> intersect = new HashSet<ArrayList<String>>();

        Iterator<ArrayList<String>> it1 = set1.iterator();
        Iterator<ArrayList<String>> it2 = set2.iterator();

        while(it1.hasNext()) {
            ArrayList<String> curr = it1.next();
            if(set2.contains(curr)) {
                intersect.add(curr);
            }
            union.add(curr);
        }

        while(it2.hasNext()) {
            union.add(it2.next());
        }

        float unionSize = union.size();
        float interSize = intersect.size();
        System.out.println("union size : " + unionSize);
        System.out.println("intersection size: " + interSize);

        return interSize/unionSize;
    }

    public float JacSimCharGram(HashSet<String> set1, HashSet<String> set2) {
        HashSet<String> union = new HashSet<String>();
        HashSet<String> intersect = new HashSet<String>();

        Iterator<String> it1 = set1.iterator();
        Iterator<String> it2 = set2.iterator();

        while(it1.hasNext()) {
            String curr = it1.next();
            if(set2.contains(curr)) {
                intersect.add(curr);
            }
            union.add(curr);
        }

        while(it2.hasNext()) {
            union.add(it2.next());
        }
        float unionSize = union.size();
        float interSize = intersect.size();
        System.out.println("union size : " + unionSize);
        System.out.println("intersection size: " + interSize);

        return interSize/unionSize;
    }
}
