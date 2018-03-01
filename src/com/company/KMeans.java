package com.company;

import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.*;

public class KMeans {

    ArrayList<Point2D> getKCenters(ArrayList<Point2D> ptList, int k) {
        HashMap<Integer, Point2D> ptMap = new HashMap<>();
        ArrayList<Point2D> centers = new ArrayList<>();

        // map from id to point
        for(Point2D pt : ptList) {
            ptMap.put(pt.id, pt);
        }

        // add random point as initial center
        Random rand = new Random();
        int initialPt = rand.nextInt(ptList.size()) + 1;

        // add first point as initial center
        centers.add(ptMap.get(initialPt));
        ptMap.remove(initialPt);

        HashMap<Integer, Double> dists = new HashMap<>();

        for(Point2D pt : ptList) {
            double dist = getWeightedDistance(centers, ptMap.size(), pt);
            dists.put(pt.id, dist);
        }

        for(int i = 2; i <= k; i++) {
            addFarthestPointKPP(centers, ptMap, dists);
            updateDistForPointsKPP(centers, ptList, dists);
        }


        return centers;
    }
    void addFarthestPointKPP(ArrayList<Point2D> centers,
                             HashMap<Integer, Point2D> pList,
                             HashMap<Integer, Double> dists) {
        // find the point from the remaining point
        // add it to the centers
        // then remove it from the pList
        Integer farthestPointId = -1;
        double dist = Double.MIN_VALUE;
        for(Map.Entry<Integer, Double> entry : dists.entrySet()) {
            if(entry.getValue() > dist) {
                farthestPointId = entry.getKey();
            }
        }

        Point2D ptToAdd = pList.get(farthestPointId);

        centers.add(ptToAdd);
        if(farthestPointId != -1) {
            dists.remove(farthestPointId);
        }
    }

    void updateDistForPointsKPP(ArrayList<Point2D> centers,
                                ArrayList<Point2D> ptList,
                                HashMap<Integer, Double> dists) {
        for(Point2D pt : ptList) {
            double currDist = getWeightedDistance(centers, ptList.size(), pt);
            dists.put(pt.id, currDist);
        }
    }

    HashMap<Integer, ArrayList<Point2D>> assignToSubsets(ArrayList<Point2D> ptList,
                                                         ArrayList<Point2D> centers) {
        HashMap<Integer, ArrayList<Point2D>> subset = new HashMap<>();

        // ptList contains points that we are assigning to different centers
        for(Point2D pt : ptList) {
            int minCenterId = -1;
            double minDist = Double.MAX_VALUE;

            for(Point2D centerPt : centers) {
                double currDist = Point2D.getDistPoints(pt, centerPt);
                if(currDist < minDist) {
                    minDist = currDist;
                    minCenterId = centerPt.id;
                }
            }
            ArrayList<Point2D> subsetList = subset.get(minCenterId);
            if(subsetList == null) {
                subsetList = new ArrayList<>();
                subset.put(minCenterId, subsetList);
            }
            subsetList.add(pt);

        }

        return subset;
    }
    /*
    void addFarthestPoint(ArrayList<Point2D> centers,
                          HashMap<Integer, Point2D> pList,
                          HashMap<Integer, Double> dists) {
        // find the point from the remaining point
        // add it to the centers
        // then remove it from the pList
        Integer farthestPointId = -1;
        double dist = Double.MIN_VALUE;
        for(Map.Entry<Integer, Double> entry : dists.entrySet()) {
            if(entry.getValue() > dist) {
                farthestPointId = entry.getKey();
            }
        }

        Point2D ptToAdd = pList.get(farthestPointId);

        centers.add(ptToAdd);
        if(farthestPointId != -1) {
            dists.remove(farthestPointId);
        }
    }

    */
    /*
    void updateDistForPoints(ArrayList<Point2D> centers,
                             ArrayList<Point2D> ptList,
                             HashMap<Integer, Double> dists) {
        for(Point2D pt : ptList) {
            double currDist = getDistanceToCenters(centers, pt);
            dists.put(pt.id, currDist);
        }
    }
    */
    // for k mean++
    double getWeightedDistance(ArrayList<Point2D> centers, int totalNumPoints, Point2D pt) {
        double totalDist = 0.0;
        for(Point2D center : centers) {
            totalDist += Point2D.getDistPoints(center, pt);
        }
        double dist = Math.sqrt(totalDist/totalNumPoints);

        return dist;
    }

    // get the (min) distance between one point and a set of centers
    double getDistanceToCenters(ArrayList<Point2D> centers, Point2D pt) {
        double dist = Double.MAX_VALUE;
        for(Point2D center : centers) {
            double currDist = Point2D.getDistPoints(center, pt);
            dist = Math.min(dist, currDist);
        }

        return dist;
    }
}
