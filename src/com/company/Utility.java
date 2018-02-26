package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utility {
    ArrayList<Point2D> FileToPoint2D(String filename) throws IOException {
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
        PrintPt2D(result);
        return result;
    }

    void PrintPt2D(ArrayList<Point2D> ptList) {
        for(int i = 0; i < ptList.size(); i++) {
            Point2D pt = ptList.get(i);
            System.out.println(pt.id + " " + pt.x + " " + pt.y);
        }
    }
}
