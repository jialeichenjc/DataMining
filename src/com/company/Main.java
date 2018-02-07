package com.company;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        kGram testKGram = new kGram();
        HashSet<ArrayList<String>> resTest = new HashSet<ArrayList<String>>();
        HashSet<String> resTestChar = new HashSet<String>();

        // 2 grams word based
        HashSet<ArrayList<String>> d1_2GramWordBased = new HashSet<ArrayList<String>>();
        HashSet<ArrayList<String>> d2_2GramWordBased = new HashSet<ArrayList<String>>();
        HashSet<ArrayList<String>> d3_2GramWordBased = new HashSet<ArrayList<String>>();
        HashSet<ArrayList<String>> d4_2GramWordBased = new HashSet<ArrayList<String>>();

        // 3 grams character based
        HashSet<String> d1_3GramCharBased = new HashSet<String>();
        HashSet<String> d2_3GramCharBased = new HashSet<String>();
        HashSet<String> d3_3GramCharBased = new HashSet<String>();
        HashSet<String> d4_3GramCharBased = new HashSet<String>();

        // 2 grams character based
        HashSet<String> d1_2GramCharBased = new HashSet<String>();
        HashSet<String> d2_2GramCharBased = new HashSet<String>();
        HashSet<String> d3_2GramCharBased = new HashSet<String>();
        HashSet<String> d4_2GramCharBased = new HashSet<String>();

        try {
            resTest = testKGram.kGramWordBased("test.txt", 2);
            d1_2GramWordBased = testKGram.kGramWordBased("D1.txt", 2);
            d2_2GramWordBased = testKGram.kGramWordBased("D2.txt", 2);
            d3_2GramWordBased = testKGram.kGramWordBased("D3.txt", 2);
            d4_2GramWordBased = testKGram.kGramWordBased("D4.txt", 2);

            System.out.println("d1_2GramWordBased " + d1_2GramWordBased.size());
            System.out.println("d2_2GramWordBased " + d2_2GramWordBased.size());
            System.out.println("d3_2GramWordBased " + d3_2GramWordBased.size());
            System.out.println("d4_2GramWordBased " + d4_2GramWordBased.size());

            d1_3GramCharBased = testKGram.kGramCharBased("D1.txt", 3);
            d2_3GramCharBased = testKGram.kGramCharBased("D2.txt", 3);
            d3_3GramCharBased = testKGram.kGramCharBased("D3.txt", 3);
            d4_3GramCharBased = testKGram.kGramCharBased("D4.txt", 3);

            System.out.println("d1_3GramCharBased " + d1_3GramCharBased.size());
            System.out.println("d2_3GramCharBased " + d2_3GramCharBased.size());
            System.out.println("d3_3GramCharBased " + d3_3GramCharBased.size());
            System.out.println("d4_3GramCharBased " + d4_3GramCharBased.size());


            d1_2GramCharBased = testKGram.kGramCharBased("D1.txt", 2);
            d2_2GramCharBased = testKGram.kGramCharBased("D2.txt", 2);
            d3_2GramCharBased = testKGram.kGramCharBased("D3.txt", 2);
            d4_2GramCharBased = testKGram.kGramCharBased("D4.txt", 2);

            System.out.println("d1_2GramCharBased " + d1_2GramCharBased.size());
            System.out.println("d2_2GramCharBased " + d2_2GramCharBased.size());
            System.out.println("d3_2GramCharBased " + d3_2GramCharBased.size());
            System.out.println("d4_2GramCharBased " + d4_2GramCharBased.size());

        }

        catch (IOException e) {

        }

       // float d1_d2_wordBased2Gram = testKGram.JacSimWordGram(d1_2GramWordBased, d2_2GramWordBased);
       // System.out.println(d1_d2_wordBased2Gram);
        //float wordBased2Gram = testKGram.JacSimWordGram(d3_2GramWordBased, d4_2GramWordBased);
       // System.out.println(wordBased2Gram);

        float charBased3Gram = testKGram.JacSimCharGram(d3_3GramCharBased, d4_3GramCharBased);
        System.out.println(charBased3Gram);


        //printWordGrams(d1_2GramWordBased);

        /*
        try {
            resTestChar = testKGram.kGramCharBased("testChar.txt", 2);
        }

        catch (IOException e) {

        }

        Iterator<ArrayList<String>> it = resTest.iterator();
        while(it.hasNext()){
            ArrayList<String> list = it.next();
            for(int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }

        Iterator<String> it2 = resTestChar.iterator();

        while(it2.hasNext()){
            String str = it2.next();
            System.out.println(str);
        }
        */
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
