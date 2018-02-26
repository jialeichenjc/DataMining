package com.company;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        HierarchicalClustering hCluster = new HierarchicalClustering();
        Utility util = new Utility();
        ArrayList<Point2D> ptList = new ArrayList<>();
        try {
            ptList = util.FileToPoint2D("ClusterDataTest.txt");
        }

        catch (IOException e) {

        }
        int k = 4;
        ArrayList<Cluster> result = hCluster.getKClusters(2, ptList);
        for(Cluster c : result) {
            util.PrintPt2D(c.centroid);
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
