package com.company;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        kGram testKGram = new kGram();
        HashSet<ArrayList<String>> resTest = new HashSet<ArrayList<String>>();

        try {
            resTest = testKGram.kGramWordBased("test.txt", 2);
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

    }

}
