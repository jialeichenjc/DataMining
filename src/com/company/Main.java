package com.company;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //HierarchicalClustering hCluster = new HierarchicalClustering();
        Utility util = new Utility();
        ArrayList<Point2D> ptList = new ArrayList<>();
        ArrayList<Point2D> centers = new ArrayList<>();
        KMeans kMeans = new KMeans();
        try {
            ptList = util.FileToPoint2D("ClusterData2.txt");
        }

        catch (IOException e) {

        }
        int k = 3;

        centers = kMeans.getKCenters(ptList, k);
        HashMap<Integer, ArrayList<Point2D>> subsets = kMeans.assignToSubsets(ptList, centers);

        try{
            util.writeHashMapToFile(subsets, "Data2Subsets.txt");
        }
        catch (IOException e) {
            System.out.println("exception occurred");
        }
        for(Point2D pt : centers) {
            util.PrintPt2D(pt);
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
