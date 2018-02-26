package com.company;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Utility util = new Utility();
        try {
            util.FileToPoint2D("ClusterData1.txt");
        }
        catch (IOException e) {
            System.out.println("Please double check your file name and file format");
        }
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
