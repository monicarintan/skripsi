/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahc.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


/**
 *
 * @author MONICA
 */
public class DistanceMatrix {

    //map?? karena arraylist nggak support buat mapping. maping pair point sama distancenya.

    private final Map<Pair, Double> matrix;

    public DistanceMatrix() {
        matrix = new HashMap<>();
    }

    public void computeAll(List<Cluster> clusters) {
        for (int i = 0; i < clusters.size() - 1; i++) {
            for (int j = i + 1; j < clusters.size(); j++) {
                getDistance(clusters.get(i), clusters.get(j));
            }
        }
    }
    
    public Pair getMinimumDistance() {
        Set<Map.Entry<Pair, Double>> set = matrix.entrySet();
        Entry<Pair, Double> min = set.iterator().next();
        for (Entry<Pair, Double> e : set) {
            if (e.getValue() < min.getValue()) {
                min = e;
            }
        }
        return min.getKey();
    }

    //get distance untuk mengitung / mengambil jarak antara 2 point
    //kalo belum ada di daftar, dia ngtung trs dimasukin.
    public double getDistance(Cluster point1, Cluster point2) {
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
