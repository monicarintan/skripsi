/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahc.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.commons.math3.ml.distance.DistanceMeasure;

/**
 *
 * @author MONICA
 */
public class DistanceMatrix {

    private final DistanceMeasure distanceMeasure;
    //map?? karena arraylist nggak support buat mapping. maping pair point sama distancenya.

    private final Map<Pair, Double> matrix;

    public DistanceMatrix(DistanceMeasure distancemeasure) {
        distanceMeasure = distancemeasure;
        matrix = new HashMap<>();
    }

    public void computeAll(List<? extends Point> points) {
//        double min = 1000;
//        double x = 0, y = 0;
        for (int i = 0; i < points.size() - 1; i++) {

            for (int j = i + 1; j < points.size(); j++) {

                getDistance(points.get(i), points.get(j));
//buat ngitung minimalnya nih.. tapi kok jadi ndobel2???? 
//                if ((getDistance(points.get(i), points.get(j)) < min) && (getDistance(points.get(i), points.get(j)) != 0 && min != 0)) {
//                    min = getDistance(points.get(i), points.get(j));
//                    x = i;
//                    y = j;
//                }
            }
        }

//        System.out.println("minimal " + min);
//        System.out.println(" i " + y);
//        System.out.println(" j " + x);
    }

    public Map.Entry<Pair, Double> getMinimumDistance() {
        Set<Map.Entry<Pair, Double>> set = matrix.entrySet();
        Entry<Pair, Double> min = set.iterator().next();
        for (Entry<Pair, Double> e : set) {
            if (e.getValue() < min.getValue()) {
                min = e;
            }
        }
        return min;
    }

    //get distance untuk mengitung / mengambil jarak antara 2 point
    //kalo belum ada di daftar, dia ngtung trs dimasukin.
    public double getDistance(Point point1, Point point2) {
        Pair p = new Pair(point1, point2);
        if (!matrix.containsKey(p)) {
            double dist;
            dist = point1.distanceTo(point2);
            matrix.put(p, dist);
            return dist;
        }
        return matrix.get(p);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pair p : matrix.keySet()) {
            sb.append(p.getLeft().toString())
                    .append("<=>")
                    .append(p.getRight().toString())
                    .append(": ")
                    .append(matrix.get(p))
                    .append("\n");
        }
        return sb.toString();
    }
}
