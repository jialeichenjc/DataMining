package com.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by J.Chen on 2/5/2018.
 */
public class RandomGeneration {
    public void measureTime(int m) throws IOException {
        String fileName = "Coupon" + Integer.toString(m) + "Times";

        PrintWriter writer = new PrintWriter(fileName, "UTF-8");

        for (int i = 250; i <= 4000; i+=500) {
            long startTime = System.currentTimeMillis();
            for(int j = 1; j <= m; j++) {
                runMultipleNoFile(i, j);
            }
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            writer.print(i); // aka n
            writer.print(" ");
            writer.print(elapsedTime);
            writer.println();
        }
        writer.close();
    }
    public int genRandom(int n) {
        HashSet<Integer> h = new HashSet<Integer>();
        Random rand = new Random();
        int r = rand.nextInt(n) + 1;
        int k = 1;
        while(!h.contains(r)) {
            h.add(r);
            r = rand.nextInt(n) + 1;
            k++;
        }

        return k;
    }

    // coupon collector
    public int collectCoupon(int n) {
        HashSet<Integer> h = new HashSet<Integer>();
        Random rand = new Random();
        int r = rand.nextInt(n) + 1;
        int k = 1;
        while(h.size() != n) {
            h.add(r);
            r = rand.nextInt(n) + 1;
            k++;
        }

        return k;
    }

    // run m experiments with input n
    public void runMultiple(int n, int m) throws IOException {
        PrintWriter writer = new PrintWriter("Coupon300TimesNoTime", "UTF-8");
        for (int i = 1; i <= m; i++) {
            int k = collectCoupon(n);
            writer.println(k);
        }
        writer.close();
    }

    public void runMultipleNoFile(int n, int m) {
        for (int i = 1; i <= m; i++) {
            int k = collectCoupon(n);
        }
    }

    public void calCumulative(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        int[] res = new int[21];
        float[] resProb = new float[21];
        int[] raw = new int[300];
        int index = 0;

        while(sc.hasNext()) {
            // raw[index++] = sc.nextInt();
            //res[sc.nextInt()/10]++;
            int n = sc.nextInt();
            if(n/10 < 20) {
                res[n/10]++;
            }
            //System.out.println(sc.nextInt()/10);
        }

        res[20] = 300;
        int sum = res[0];
        for(int i = 1; i < res.length; i++) {
            //System.out.println(res[i]);
            sum = sum+res[i];
            System.out.println(sum);
            resProb[i] = (float)sum/300;
        }

        resProb[20] = 1;
        PrintWriter writer = new PrintWriter("CollisionDensity", "UTF-8");
        for (int i = 0; i < resProb.length; i++) {
            writer.print(i*10); // aka n
            writer.print(" ");
            writer.print(resProb[i]);
            writer.println();;
        }

        writer.close();
    }
    public int calAverage(String fileName, int n) throws IOException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        int sum = 0;
        while(sc.hasNextInt()) {
            sum += sc.nextInt();
        }

        return sum/n;
    }
}
