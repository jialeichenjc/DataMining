package com.company;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HierarchicalClustering {

    ArrayList<Cluster> clusterList;

    // constructor
    public HierarchicalClustering() {
        clusterList = new ArrayList<>();
    }

    public ArrayList<Cluster> getKClusters(int k, ArrayList<Point2D> ptList) {
        int n = ptList.size();

        ArrayList<Cluster> result = new ArrayList<>();

        for(Point2D pt : ptList) {
            Cluster cluster = new Cluster();
            cluster.initializeCluster(pt);
            result.add(cluster);
        }
        System.out.println(result.size());

        if(result.size() <= k) return result;
        Comparator<Pair<Cluster,Cluster>> comparator = new ClusterDistComparator();
        PriorityQueue<Pair<Cluster, Cluster>> pq = new PriorityQueue<>(n, comparator);

        for(int i = 0; i < result.size()-1; i++) {
            for(int j = i+1; j < result.size(); j++) {
                Pair<Cluster, Cluster> pair = new Pair(result.get(i), result.get(j));
                pq.offer(pair);
            }
        }
        System.out.println("Pq size : " + pq.size());


        while(result.size() > k && !pq.isEmpty()) {
            Pair<Cluster, Cluster> curr = pq.poll();
            Cluster cluster = mergeTwoClusters(curr.getKey(), curr.getValue());
            result.remove(curr.getKey());
            result.remove(curr.getValue());
            result.add(cluster);

            //re-calculate the distance between this new cluster and every other cluster
            pq.clear();
            for(int i = 0; i < result.size(); i++) {
                for(int j = i+1; j < result.size(); j++) {
                   // Cluster c1 = result.get(i);
                    //Cluster c2 = result.get(j);
                    Pair<Cluster, Cluster> pair = new Pair(result.get(i), result.get(j));
                    pq.offer(pair);
                }
            }

        }


        return result;
    }

    // merge two clusters (in Euclidean space)
    public Cluster mergeTwoClusters(Cluster c1, Cluster c2) {
        Cluster cluster = new Cluster();
        cluster.pointList.addAll(c1.pointList);
        cluster.pointList.addAll(c2.pointList);

        cluster.initializeCluster();

        return cluster;
    }


    // get the distance of two clusters using the single link method
    public static double getClustersDistanceSingleLink(Cluster c1, Cluster c2) {
        double minDist = Double.MAX_VALUE;
        ArrayList<Point2D> ptList1 = c1.pointList;
        ArrayList<Point2D> ptList2 = c2.pointList;
        System.out.println("list1 size: " + ptList1.size()
        + "list2 size: " + ptList2.size());

        for(Point2D pt1 : c1.pointList) {
            for(Point2D pt2 : c2.pointList) {
                double currDist = Point2D.getDistPoints(pt1, pt2);
                minDist = Math.min(minDist, currDist);
            }
        }
        return minDist;
    }

    public static double getClustersDistanceCompleteLink(Cluster c1, Cluster c2) {
        double maxDist = Double.MIN_VALUE;
        ArrayList<Point2D> ptList1 = c1.pointList;
        ArrayList<Point2D> ptList2 = c2.pointList;

        for(int i = 0; i < ptList1.size(); i++) {
            for(int j = 0; j < ptList2.size(); j++) {
                double currDist = Point2D.getDistPoints(ptList1.get(i), ptList2.get(i));
                maxDist = Math.min(maxDist, currDist);
            }
        }

        return maxDist;
    }

    public static double getClustersDistanceMeanLink(Cluster c1, Cluster c2) {
        Point2D centroid1 = c1.centroid;
        Point2D centroid2 = c2.centroid;

        double dist = Point2D.getDistPoints(centroid1, centroid2);

        return dist;
    }
}
