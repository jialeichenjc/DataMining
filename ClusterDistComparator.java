package com.company;

import javafx.util.Pair;

import java.util.Comparator;

public class ClusterDistComparator implements Comparator<Pair<Cluster, Cluster>> {
    @Override
    public int compare(Pair<Cluster, Cluster> p1, Pair<Cluster, Cluster> p2){
        double dist1 = HierarchicalClustering.getClustersDistanceMeanLink(
                p1.getKey(), p1.getValue());
        double dist2 = HierarchicalClustering.getClustersDistanceMeanLink(
                p2.getKey(), p2.getValue());

        // min heap
        if(dist1 > dist2) {
            return 1;
        }
        if(dist1 < dist2) {
            return -1;
        }
        return 0;
    }
}
