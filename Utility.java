package com.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Utility {
    public ArrayList<Point2D> FileToPoint2D(String filename) throws IOException {
        File file = new File(filename);
        Scanner sc = new Scanner(file).useDelimiter("\\s+");
        ArrayList<Point2D> result = new ArrayList<>();

        int count = 0;
        Point2D pt;
        int id = 0;
        double x = 0.0f;
        double y = 0.0f;
        while(sc.hasNext()) {
           // System.out.println(sc.next());

            switch (count % 3) {
                case 0 :
                    id = sc.nextInt();
                    count++;
                    break;
                case 1 :
                    x = sc.nextDouble();
                    count++;
                    break;
                case 2 :
                    y = sc.nextDouble();
                    count++;
                    pt = new Point2D(id, x, y);
                    result.add(pt);
                    break;

            }
        }
        return result;
    }
    void writeHashMapToFile(HashMap<Integer, ArrayList<Point2D>> map,
                            String fileName) throws IOException {
        PrintWriter writer = new PrintWriter(fileName, "UTF-8");
        for(Map.Entry<Integer, ArrayList<Point2D>> entry : map.entrySet()) {
            writer.println("CenterId: ");
            writer.print(entry.getKey());
            writer.println();
            ArrayList<Point2D> currList = entry.getValue();

            writer.println("Point ID ");
            for(Point2D pt : currList) {
                writer.println(pt.id);
            }

            writer.println("x coordinates: ");
            for(Point2D pt : currList) {
                writer.println(pt.x);
            }

            writer.println("y coordiates: ");
            for(Point2D pt : currList) {
                writer.println(pt.y);
            }
        }

        writer.close();
    }

    void PrintPt2D(ArrayList<Point2D> ptList) {
        for(int i = 0; i < ptList.size(); i++) {
            Point2D pt = ptList.get(i);
            System.out.println(pt.id + " " + pt.x + " " + pt.y);
        }
    }

    void PrintPt2D(Point2D pt) {
        System.out.println(pt.id + " " + pt.x + " " + pt.y);
    }

    public static void PrintHashMap(HashMap<Character, Integer> map) {
        for(Character ch : map.keySet()) {
            System.out.println(ch + " " + map.get(ch));
        }
    }
}
