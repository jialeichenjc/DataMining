package com.company;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by super on 2/3/2018.
 */
public class kGram {
    public HashSet<String> kGramCharBased(String filename, int k) throws IOException {
        HashSet<String> set = new HashSet<String>();
        File file = new File(filename);
        Scanner sc = new Scanner(file).useDelimiter("\\s+");;
        while(sc.hasNext()) {

        }
        return set;
    }

    public HashSet<String> kGramWordBased(String filename) throws IOException {
        HashSet<String> set = new HashSet<String>();
        File file = new File(filename);
        Scanner sc = new Scanner(file).useDelimiter("\\s+");



        return set;
    }
}
